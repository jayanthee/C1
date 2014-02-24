/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.dao;

import com.lrl.c1.entity.Adunits;
import com.lrl.c1.entity.Adunitsplacements;
import com.lrl.c1.entity.Impressionsettings;
import com.lrl.c1.entity.Inventorysettings;
import com.lrl.c1.entity.Listofvalues;
import com.lrl.c1.entity.Placements;
import com.lrl.c1.entity.Publisher;
import com.lrl.c1.entity.Ratecard;
import com.lrl.c1.entity.Userprofile;
import com.lrl.c1.entity.Vendors;
import com.lrl.c1.util.C1JsonParserService;
import com.lrl.c1.wrapper.AdunitsData;
import com.lrl.c1.wrapper.ForeCastData;
import com.lrl.c1.wrapper.SellSideSyncSettingData;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Iterator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author logic
 */
@Repository("SellsideInvSyncDAO")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SellSideInventorySyncDAOImpl implements SellSideInventorySyncDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private C1JsonParserService c1jsonparser;

    // ### USED AREA
    public boolean syncAdunitsTable(Map<String, AdunitsData> dataObj, Map<String, String> map, Integer venId, Integer pubId, Integer invSetId, String display) {

        try {
            Session session = sessionFactory.getCurrentSession();

            Map<String, AdunitsData> m = new TreeMap<String, AdunitsData>(dataObj);
            session.beginTransaction().begin();
            int i = 0;
            Integer foreCastImp = 0;

//            Vendors v = (Vendors) session.get(Vendors.class, venId);
//            Publisher p = (Publisher) session.get(Publisher.class, pubId);
//            Listofvalues lsv = this.getListOfValuesPK(display);

            for (Map.Entry<String, AdunitsData> obj : m.entrySet()) {  
                
                if (checkIntegrationIdExist(Integer.valueOf(obj.getValue().getId().toString()), 0)) {
                    Adunits au = new Adunits();
                    au.setName(obj.getValue().getName());
                    au.setSizes(obj.getValue().getSizes());
                    au.setIntegrationId(obj.getValue().getId().toString());
                    au.setPositions(obj.getValue().getPositions());
                    au.setPublisherId(new Publisher(345)); // ###
                    au.setCpm(new BigDecimal("0.0"));// ###
                    au.setCurrency("USD"); // ###
                    au.setDefaultRateCardId(new Ratecard(1)); // ###
                    au.setSpecialRateCardId(new Ratecard(1)); // ##
                    au.setImpression(1500000); // ##
                    au.setPublicInventoryPercent(30); // ##
                    au.setPublicImpressionAvailable(10000); // ##
                    au.setPrivateImpressionAvailable(50000); // ##
                    au.setPlacementType(new Listofvalues(13)); // ##
                    au.setCreatedBy(new Userprofile(1));
                    au.setUpdatedBy(new Userprofile(1));
                    au.setCreated(new Date());
                    au.setUpdated(new Date());
                            
                    // ### its hard code consider later
//                    Ratecard rtcard = new Ratecard();
//                    rtcard.setId(1);
//                    au.setDefaultRateCardId(rtcard);
                    // ###
                    //au.setVendorsId(v);
                    //au.setPublisherId(p);
                    //au.setPlacementType(lsv);                    
                    //ForeCastData fd = new ForeCastData();
                    //fd = this.getAdunitForeCast(obj.getValue().getId().toString());
                    //au.setImpression(Integer.valueOf(fd.getAvailableUnits()));
                    //foreCastImp +=Integer.valueOf(fd.getAvailableUnits());                    
                    session.save(au);
                    i++;
                }
            }

            for (Map.Entry<String, String> obj2 : map.entrySet()) {

                //System.out.println("k=" + obj2.getKey() + " v=" + obj2.getValue());
                // get PK value from  the integration id
                Adunits selectIntegId = this.getPKvalue(Integer.valueOf(obj2.getKey().toString()));
                //get PK value from the parent id
                Adunits selectParId = this.getPKvalue(Integer.valueOf(obj2.getValue().toString()));

                Adunits aa = (Adunits) session.get(Adunits.class, selectIntegId.getId()); // integrationid                
                aa.setParentId(selectParId);
                session.saveOrUpdate(aa);
                session.flush();
                i++;
            }
//
//            if (i % 2 == 0) { //20, same as the JDBC batch size
//                //flush a batch of inserts and release memory:
//                session.flush();
//                session.clear();
//            }

            // dont delete ###
            //boolean b = this.saveInvSettImp(invSetId,foreCastImp);
            session.beginTransaction().commit();
            return true;

        } catch (Exception e) {
            System.out.println("Error from syncAdunitsTable() func()");
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveInvSettImp(Integer invSetId, Integer impr) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Inventorysettings invset = (Inventorysettings) session.get(Inventorysettings.class, invSetId);
            invset.setTotalImpression(impr);
            session.update(impr);
            return true;
        } catch (Exception e) {
            System.out.println("Error from saveInvSettImp() fun in DAO Impl");
            e.printStackTrace();
            return false;
        }
    }

//    public ForeCastData getAdunitForeCast(String integId){
//        try {
//            ForeCastData fd = new ForeCastData();
//            String URL = "http://50.112.157.222/CIS/forecasts/adunit/"+integId+"?networkId=269233203";
//            JSONObject json = c1jsonparser.readJsonFromUrl(URL);
//            fd.setUnitType(json.get("unitType").toString());
//            fd.setAvailableUnits(json.get("availableUnits").toString());
//            fd.setDeliveredUnits(json.get("deliveredUnits").toString());
//            fd.setMatchedUnits(json.get("matchedUnits").toString());
//            fd.setPossibleUnits(json.get("possibleUnits").toString());
//            fd.setReservedUnits(json.get("reservedUnits").toString());
//            return fd;
//        } catch (Exception e) {
//            System.out.println("Error from getAdunitForeCast() DAO Impl");
//            e.printStackTrace();
//            return null;
//        }
//    }
//   
    public Integer getAdunitForeCastImp(Integer venId, Integer dispId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            String qstr = "";
            qstr = "SELECT SUM(A.impression) AS IMP FROM Adunits A WHERE A.vendorId = :venId";
            query = session.createQuery(qstr).setInteger("venId", venId);
            if (query.list().size() > 0) {
                return Integer.valueOf(query.list().get(0).toString());
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Error from getSyncImpression() fun in DAO Impl");
            return 0;
        }
    }

    public Listofvalues getListOfValuesPK(String display) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;
            qstr = "SELECT L FROM Listofvalues L WHERE L.value = :disp ";
            query = session.createQuery(qstr).setString("disp", display);
            List<Listofvalues> data = query.list();
            Iterator i = data.listIterator();
            Listofvalues ls = new Listofvalues();
            while (i.hasNext()) {
                Listofvalues l = (Listofvalues) i.next();
                ls.setId(l.getId());
                ls.setName(l.getName());
                ls.setValue(l.getValue());
                ls.setDescription(l.getDescription());
                ls.setParentId(l);
            }
            return ls;
        } catch (Exception e) {
            System.out.println("Error from getListOfValuesPK() in DAO Impl");
            e.printStackTrace();
            return null;
        }
    }

    public Adunits getPKvalue(Integer id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction().begin();
            String qstr1 = "";
            Query query1 = null;
            qstr1 = "SELECT A FROM Adunits A WHERE A.integrationId = :id ";
            query1 = session.createQuery(qstr1).setInteger("id", id);
            List<Adunits> adl = query1.list();

            Adunits aduObj = null;
            for (Adunits al : adl) {
                aduObj = (Adunits) session.get(Adunits.class, al.getId()); // integrationid                
            }

            return aduObj;

        } catch (Exception e) {
            System.out.println("Error from getPKvalue()");
            e.printStackTrace();
            return null;
        }
    }

    public boolean syncPlacementTable(Map<String, Object> obj1, List<AdunitsData> obj2) {
        try {

            Session session = sessionFactory.getCurrentSession();

            Map<String, Object> m = new TreeMap<String, Object>(obj1);
            Map<Object, Object> temp = new HashMap<Object, Object>();

            session.beginTransaction().begin();

            for (Map.Entry<String, Object> obj : m.entrySet()) {
                //System.out.println("KEY =" + obj.getKey() + " === VALUE == " + obj.getValue());

                if (checkIntegrationIdExist(Integer.valueOf(obj.getKey().toString()), 1)) {
                    temp.put(Integer.valueOf(obj.getKey().toString()), Integer.valueOf(obj.getKey().toString()));
                    Userprofile up = new Userprofile(); //this is hardcode, laterly change // ###
                    up.setId(1);
                    Placements p = new Placements();
                    p.setName(obj.getValue().toString());
                    p.setIntegrationId(obj.getKey().toString());
                    p.setCreated(new Date()); // ###
                    p.setUpdated(new Date()); // ###
                    p.setCreatedBy(up);
                    p.setUpdatedBy(up);

                    // ### its hard code consider later
                    Ratecard rtcard = new Ratecard();
                    rtcard.setId(1);
                    p.setDefaultRateCardId(rtcard);

                    session.save(p);
                }

            }


            Iterator i = obj2.listIterator();
            while (i.hasNext()) {

                AdunitsData ad = (AdunitsData) i.next();
                System.out.println("IntegID =" + ad.getId() + " == Adunitid  =  " + ad.getAdunitid());

                for (Map.Entry<Object, Object> tmp : temp.entrySet()) {

                    if (ad.getId().equals(tmp.getValue())) {
                        Userprofile up = new Userprofile(); //this is hardcode, laterly change // ###
                        up.setId(1);

                        Placements plcid = this.getPlacementPKvalue(Integer.valueOf(ad.getId().toString()));
                        Adunits aduid = this.getPKvalue(Integer.valueOf(ad.getAdunitid().toString()));

                        Adunitsplacements aduplc = new Adunitsplacements();
                        aduplc.setPlacementId(plcid);
                        aduplc.setAdUnitId(aduid);
                        aduplc.setUpdatedBy(up); // ###
                        aduplc.setCreatedBy(up); // ###
                        aduplc.setCreated(new Date()); // ###
                        aduplc.setUpdated(new Date()); // ###

                        // ### its hard code consider later
                        Ratecard rtcard = new Ratecard();
                        rtcard.setId(1);
                        aduplc.setDefaultRateCardId(rtcard);

                        session.save(aduplc);
                        session.flush();
                    }
                }
            }

            session.beginTransaction().commit();
            return true;

        } catch (Exception e) {
            System.out.println("Error from syncPlacementsTable");
            e.printStackTrace();
            return false;
        }
    }

    public Placements getPlacementPKvalue(Integer id) {
        try {
            Session session = sessionFactory.getCurrentSession();

            String qstr1 = "";
            Query query1 = null;
            qstr1 = "SELECT P FROM Placements P WHERE P.integrationId = :id ";
            query1 = session.createQuery(qstr1).setInteger("id", id);
            List<Placements> pl = query1.list();

            Placements plcObj = null;
            for (Placements p : pl) {
                plcObj = (Placements) session.get(Placements.class, p.getId()); // integrationid                
            }

            return plcObj;

        } catch (Exception e) {
            System.out.println("Error from getPlacementPKvalue()");
            e.printStackTrace();
            return null;
        }

    }

    public boolean checkIntegrationIdExist(Integer integId, Integer tblFlag) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr1 = "";
            Query query1 = null;
            if (tblFlag == 0) {
                qstr1 = "SELECT A FROM Adunits A WHERE A.integrationId = :id ";
            } else {
                qstr1 = "SELECT P FROM Placements P WHERE P.integrationId = :id ";
            }

            query1 = session.createQuery(qstr1).setInteger("id", integId);
            System.out.println("list size ==" + query1.list().size());
            if (query1.list().size() > 0) {
                return false; // IntegrationId is exist
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error checkIntegrationExist() fun from DAO Impl");
            return false;
        }

    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public SellSideSyncSettingData createVendors_old(SellSideSyncSettingData sync) {
        Session session = sessionFactory.getCurrentSession();
        try {

            Userprofile up = new Userprofile();
            up.setId(1); // ###

            Vendors ven = new Vendors();
            ven.setName(sync.getVenName());
            ven.setLink(sync.getVenLink());
            ven.setCreated(new Date());
            ven.setUpdated(new Date());
            ven.setCreatedBy(up);
            ven.setUpdatedBy(up);
            session.save(ven);

            Inventorysettings invsync = new Inventorysettings();
            invsync.setVendor(ven);
            invsync.setUserName(sync.getInvSyncUserName());
            invsync.setPassWord(sync.getInvSyncPwd());
            invsync.setStatus(sync.getInvSyncStatus());
            invsync.setTotalImpression(sync.getInvSyncTotImp());
            invsync.setPublicInventroyPercent(sync.getInvSyncPubInvPercent());
            invsync.setPrivateInventoryPercent(sync.getInvSyncPrInvPercent());
            invsync.setCreated(new Date());
            invsync.setUpdated(new Date());
            invsync.setCreatedBy(up);
            invsync.setUpdatedBy(up);
            session.save(invsync);

            System.out.println("invsyc id ==" + invsync.getId());

            return this.setSyncSettingsData(invsync.getId());

        } catch (Exception e) {
            System.out.println("Error createVendors() func. from DAO implements");
            e.printStackTrace();
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public SellSideSyncSettingData createVendors(SellSideSyncSettingData sync) {
        Session session = sessionFactory.getCurrentSession();
        try {

            Userprofile up = new Userprofile();
            up.setId(1); // ###

            Vendors ven = new Vendors();
            ven.setName(sync.getVenName());
            ven.setLink(sync.getVenLink());
            //ven.setLogo(sync.getVenImage());            
            ven.setCreated(new Date());
            ven.setUpdated(new Date());
            ven.setCreatedBy(up);
            ven.setUpdatedBy(up);
            session.save(ven);

            return this.setVendorData(ven.getId());

        } catch (Exception e) {
            System.out.println("Error createVendors() func. from DAO implements");
            e.printStackTrace();
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public SellSideSyncSettingData createInvSync(SellSideSyncSettingData sync) {
        Session session = sessionFactory.getCurrentSession();
        try {
            System.out.println("vend id =" + sync.getVenInvSyncId());

            Userprofile up = new Userprofile();
            up.setId(1); // ###

            Vendors v = (Vendors) session.get(Vendors.class, sync.getVenInvSyncId());
            Publisher p = (Publisher) session.get(Publisher.class, sync.getInvSyncPubId());

            Inventorysettings invsync = new Inventorysettings();
            invsync.setVendor(v);
            invsync.setPublisherId(p);
            invsync.setUserName(sync.getInvSyncUserName());
            invsync.setPassWord(sync.getInvSyncPwd());
            invsync.setStatus(sync.getInvSyncStatus());
            invsync.setTotalImpression(sync.getInvSyncTotImp());
            invsync.setPublicInventroyPercent(sync.getInvSyncPubInvPercent());
            invsync.setPrivateInventoryPercent(sync.getInvSyncPrInvPercent());
            invsync.setCreated(new Date());
            invsync.setUpdated(new Date());
            invsync.setCreatedBy(up);
            invsync.setUpdatedBy(up);
            session.save(invsync);

            return this.setSyncSettingsData(invsync.getId());

        } catch (Exception e) {
            System.out.println("Error createInvSync() func. from DAO implements");
            e.printStackTrace();
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public SellSideSyncSettingData updateVendors_old(SellSideSyncSettingData sync) {

        Session session = sessionFactory.getCurrentSession();

        try {

            Userprofile up = new Userprofile();
            up.setId(1); // ###

            Inventorysettings invsync = (Inventorysettings) session.get(Inventorysettings.class, sync.getInvSyncId());
            Vendors ven = (Vendors) session.get(Vendors.class, sync.getVenId());

            ven.setName(sync.getVenName());
            ven.setLink(sync.getVenLink());
            ven.setUpdated(new Date());
            ven.setUpdatedBy(up);
            session.update(ven);

            invsync.setVendor(ven);
            invsync.setUserName(sync.getInvSyncUserName());
            invsync.setPassWord(sync.getInvSyncPwd());
            invsync.setStatus(sync.getInvSyncStatus());
            invsync.setTotalImpression(sync.getInvSyncTotImp());
            invsync.setPublicInventroyPercent(sync.getInvSyncPubInvPercent());
            invsync.setPrivateInventoryPercent(sync.getInvSyncPrInvPercent());
            invsync.setUpdated(new Date());
            invsync.setUpdatedBy(up);
            session.update(invsync);

            System.out.println(" upd invsyc id ==" + invsync.getId());

            return this.setSyncSettingsData(invsync.getId());

        } catch (Exception e) {
            System.out.println("Error createVendors() func. from DAO implements");
            e.printStackTrace();
            return null;
        }

    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public SellSideSyncSettingData updateVendors(SellSideSyncSettingData sync) {

        Session session = sessionFactory.getCurrentSession();

        try {
            Userprofile up = new Userprofile();
            up.setId(1); // ###

            Vendors ven = (Vendors) session.get(Vendors.class, sync.getVenId());

            ven.setName(sync.getVenName());
            ven.setLink(sync.getVenLink());
            ven.setUpdated(new Date());
            ven.setUpdatedBy(up);
            session.update(ven);

            return this.setVendorData(ven.getId());

        } catch (Exception e) {
            System.out.println("Error updateVendors() func. from DAO implements");
            e.printStackTrace();
            return null;
        }

    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public SellSideSyncSettingData updateInvSync(SellSideSyncSettingData sync) {

        Session session = sessionFactory.getCurrentSession();

        try {

            Userprofile up = new Userprofile();
            up.setId(1); // ###

            Inventorysettings invsync = (Inventorysettings) session.get(Inventorysettings.class, sync.getInvSyncId());
            Vendors ven = (Vendors) session.get(Vendors.class, sync.getVenInvSyncId());

            Publisher p = (Publisher) session.get(Publisher.class, sync.getInvSyncPubId());

            invsync.setVendor(ven);
            invsync.setPublisherId(p);
            invsync.setUserName(sync.getInvSyncUserName());
            invsync.setPassWord(sync.getInvSyncPwd());
            invsync.setStatus(sync.getInvSyncStatus());
            invsync.setTotalImpression(sync.getInvSyncTotImp());
            invsync.setPublicInventroyPercent(sync.getInvSyncPubInvPercent());
            invsync.setPrivateInventoryPercent(sync.getInvSyncPrInvPercent());
            invsync.setUpdated(new Date());
            invsync.setUpdatedBy(up);
            session.update(invsync);

            return this.setSyncSettingsData(invsync.getId());

        } catch (Exception e) {
            System.out.println("Error updateInvSync() func. from DAO implements");
            e.printStackTrace();
            return null;
        }

    }

    public boolean deleteInvSyncVendors(Integer syncId) {

        Session session = sessionFactory.getCurrentSession();

        try {
            Inventorysettings invsync = (Inventorysettings) session.get(Inventorysettings.class, syncId);
            session.delete(invsync);
            session.flush();
            return true;
        } catch (Exception e) {
            System.out.println("Error deleteVendors() fun. from DAO Impl");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteVendors(Integer venId) {

        Session session = sessionFactory.getCurrentSession();
        try {
            Vendors v = (Vendors) session.get(Vendors.class, venId);
            session.delete(v);
            session.flush();
            return true;
        } catch (Exception e) {
            System.out.println("Error deleteVendors() fun. from DAO Impl");
            e.printStackTrace();
            return false;
        }
    }

    public List<Vendors> getVendorsList() {
        Session session = sessionFactory.getCurrentSession();
        try {
            Query query = null;
            String qstr = null;
            qstr = "SELECT V FROM Vendors V";
            query = session.createQuery(qstr);
            return query.list();

        } catch (Exception e) {
            System.out.println("Error from getVendorsList() fun. in DAO Impl");
            e.printStackTrace();
            return null;
        }
    }

    public List<Inventorysettings> getSyncSetVendorsData(Integer venid) {
        Session session = sessionFactory.getCurrentSession();

        try {
            String qstr = "";
            Query query = null;
            qstr = "SELECT I FROM Inventorysettings I WHERE I.vendor = :id ";
            query = session.createQuery(qstr).setInteger("id", venid);
            return query.list();

        } catch (Exception e) {
            System.out.println("Error getSyncSetVendorsData() from DAO Impl");
            return null;
        }
    }

    public SellSideSyncSettingData getVendor(Integer venId) {
        Session session = sessionFactory.getCurrentSession();
        try {
            SellSideSyncSettingData wrapper = new SellSideSyncSettingData();
            Vendors sync = (Vendors) session.get(Vendors.class, venId);
            wrapper.setVenId(sync.getId());
            wrapper.setVenName(sync.getName());
            //wrapper.setVenLogo(sync.getLogo());
            wrapper.setVenLink(sync.getLink());

            return wrapper;

        } catch (Exception e) {
            System.out.println("Error getVendor() from DAO Impl");
            e.printStackTrace();
            return null;
        }
    }

    public SellSideSyncSettingData setVendorData(Integer venId) {
        Session session = sessionFactory.getCurrentSession();
        try {
            SellSideSyncSettingData wrapper = new SellSideSyncSettingData();

            Vendors v = (Vendors) session.get(Vendors.class, venId);

            wrapper.setVenId(v.getId());
            wrapper.setVenName(v.getName());
            wrapper.setVenLink(v.getLink());
            //wrapper.setVenLogo(v.getLogo());
            //create dt, update dt, created by ,updated by missing
            return wrapper;
        } catch (Exception e) {
            System.out.println("Error SetVendorData() fun from DAO Impl ");
            e.printStackTrace();
            return null;
        }
    }

    public SellSideSyncSettingData setSyncSettingsData(Integer syncId) {

        System.out.println("inner =" + syncId);
        Session session = sessionFactory.getCurrentSession();

        try {
            SellSideSyncSettingData wrapper = new SellSideSyncSettingData();

            Inventorysettings sync = (Inventorysettings) session.get(Inventorysettings.class, syncId);

            wrapper.setInvSyncId(sync.getId());
            wrapper.setVenId(sync.getVendor().getId());
            wrapper.setInvSyncUserName(sync.getUserName());
            wrapper.setInvSyncPwd(sync.getPassWord());
            wrapper.setInvSyncStatus(sync.getStatus());
            wrapper.setInvSyncTotImp(sync.getTotalImpression());
            wrapper.setInvSyncPubInvPercent(sync.getPublicInventroyPercent());
            wrapper.setInvSyncPrInvPercent(sync.getPrivateInventoryPercent());
            wrapper.setVenName(sync.getVendor().getName());
            // wrapper.setVenLogo(sync.getVendor().getLogo());
            wrapper.setVenLink(sync.getVendor().getLink());
            return wrapper;
        } catch (Exception e) {
            System.out.println("Error getSyncSettingsData() fun from DAO Impl ");
            e.printStackTrace();
            return null;
        }
    }

    public List<Inventorysettings> fetchGrpVendorsData() {
        Session session = sessionFactory.getCurrentSession();

        try {
            String qstr = "";
            Query query = null;
            qstr = "SELECT I FROM Inventorysettings I, Vendors V WHERE V.id = I.vendor ";
            query = session.createQuery(qstr);
            return query.list();

        } catch (Exception e) {
            System.out.println("Error getSyncSetVendorsData() from DAO Impl");
            return null;
        }
    }

    public boolean updateImpressionSetting(Integer venId, Integer month, Integer year, String flag, Integer percent, Integer pubId) {
        try {
            Session session = sessionFactory.getCurrentSession();

            //Vendors vendor = (Vendors) session.get(Vendors.class, venId); 

            Query query1 = null;
            String qstr1 = "SELECT I FROM Inventorysettings I WHERE I.vendor = :vid AND I.publisherId = :pubid ";
            query1 = session.createQuery(qstr1).setInteger("vid", venId).setInteger("pubid", pubId);
            Inventorysettings inv = (Inventorysettings) query1.uniqueResult();
            String qstr = "";
            Query query = null;
            String str;



            if (flag == "Y") {
                str = "I.privateInventoryPercent= :percent";
            } else {
                str = "I.publicInventoryPercent= :percent";
            }


            qstr = "UPDATE Impressionsettings I SET " + str + "  WHERE I.inventorySettingsId = :id AND I.month = :month And I.year = :year  ";
            query = session.createQuery(qstr);
            query.setInteger("id", inv.getId());
            query.setInteger("month", month);
            query.setInteger("year", year);
            query.setInteger("percent", percent);
            int result = query.executeUpdate();

            return true;


        } catch (Exception e) {
            System.out.println("Error from updateImpressionSetting(venId, month, year) fun in DAO impl  ");
            e.printStackTrace();
            return false;
        }
    }

    public boolean yearlyImpressionSetting(Integer syncId, Integer impression, Integer pubPercent, Integer prvtPercent, Integer month, Integer year) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Userprofile up = (Userprofile) session.get(Userprofile.class, 1);

            Inventorysettings sync = (Inventorysettings) session.get(Inventorysettings.class, syncId);

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            month = month - 1;
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse("01-" + month + "-" + year));

            for (int i = 1; i <= 12; i++) {

                c.add(Calendar.MONTH, 1);
                Impressionsettings imps = new Impressionsettings();
                imps.setInventorySettingsId(sync);
                imps.setMonthlyImpression(impression);
                imps.setMonth(c.get(Calendar.MONTH) + 1);
                imps.setYear(c.get(Calendar.YEAR) );
                imps.setPrivateInventoryPercent(pubPercent);
                imps.setPublicInventoryPercent(prvtPercent);
                imps.setCreated(new Date());
                imps.setUpdated(new Date());
                imps.setCreatedBy(up);
                imps.setUpdatedBy(up);
                session.save(imps);
                month += month;

            }
            return true;

        } catch (Exception e) {
            System.out.println("yearlyImpressionSetting() in DAO Impl");
            return false;
        }

    }
} // END CLASS
