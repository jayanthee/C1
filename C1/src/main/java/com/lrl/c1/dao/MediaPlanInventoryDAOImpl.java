/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.dao;

import com.lrl.c1.bean.MediaplanBean;
import com.lrl.c1.entity.Adunits;
import com.lrl.c1.entity.Adunitsplacements;
import com.lrl.c1.entity.Invtargeting;
import com.lrl.c1.entity.Mediaplan;
import com.lrl.c1.entity.Mediaplanline;
import com.lrl.c1.entity.Placements;
import com.lrl.c1.entity.Publisher;
import com.lrl.c1.entity.Userprofile;
import com.lrl.c1.wrapper.AdunitsData;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Date;
import java.util.Map;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author logic
 */
@Repository("mediaPlanInventoryDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MediaPlanInventoryDAOImpl implements MediaPlanInventoryDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private MediaplanBean mpBean;

    // USED###
    public List<Placements> getPlacementsLines(Integer id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;
            qstr = "FROM Placements P WHERE P.publisherId = :id";
            query = session.createQuery(qstr).setInteger("id", id); //fixed @@@
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Adunits> getPlacementsAdLines(Integer id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;
            qstr = "FROM Adunits A WHERE A.publisherId = :id AND A.parentId IS NULL";
            query = session.createQuery(qstr).setInteger("id", id);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getAdUnitPlcImpr(Integer aduid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            String qstr = "";
            qstr = "SELECT SUM(A.impression) AS IMP FROM Adunits A WHERE A.id = :aduid";
            query = session.createQuery(qstr).setInteger("aduid", aduid);
            if (query.list().size() > 0) {
                return Integer.valueOf(query.list().get(0).toString());
            } else {
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Integer getAdUnitPlcCount(Integer aduid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            String qstr = "";
            qstr = "SELECT A FROM Adunits A WHERE A.id = :aduid";
            query = session.createQuery(qstr).setInteger("aduid", aduid);
            return query.list().size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Integer getPlcAdunitsCount(Integer plcid) {

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            String qstr = "";
            qstr = "SELECT AP FROM Adunitsplacements AP WHERE AP.placementId = :plcid";
            query = session.createQuery(qstr).setInteger("plcid", plcid);
            return query.list().size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public List<Adunitsplacements> getPlcAdUnitsList(Integer plcid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;
            qstr = "SELECT A FROM Adunitsplacements A WHERE A.placementId = :plcid ";
            query = session.createQuery(qstr).setInteger("plcid", plcid);

            return query.list();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Integer getPlcImpr(Integer plcid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            String qstr = "";
            qstr = "SELECT SUM(A.impression) FROM Adunits A, Adunitsplacements AP WHERE AP.placementId = :plcid AND AP.adUnitId = A.id";
            query = session.createQuery(qstr).setInteger("plcid", plcid);
            if (query.list().size() > 0) {
                return Integer.valueOf(query.list().get(0).toString());
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Integer getAdUnitImpCount(Integer aduid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            String qstr = "";
            qstr = "SELECT SUM(A.impression) FROM Adunits A WHERE A.id = :aduid";
            query = session.createQuery(qstr).setInteger("aduid", aduid);
            if (query.list().size() > 0) {
                return Integer.valueOf(query.list().get(0).toString());
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public Double getAdUnitCPM(Integer aduid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            String qstr = "";
            qstr = "SELECT AVG(A.cpm) AS CPM FROM Adunits A WHERE A.id = :aduid";
            query = session.createQuery(qstr).setInteger("aduid", aduid);
            if (query.list().size() > 0) {
                return Double.valueOf(query.list().get(0).toString());
            } else {
                return 0.0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public List<Adunits> getAduAdUnitsList(Integer pubid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null; 
            qstr = "FROM Adunits A WHERE A.publisherId = :id AND A.parentId IS NULL";
            query = session.createQuery(qstr).setInteger("id", pubid);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ### USED
    public List<Adunits> getAduSubAdUnitsList(Integer adUnitId, String catId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;

            qstr = "SELECT A FROM Adunits A WHERE A.parentId = :aduid AND A.placementType IN ("+catId+") ";
            System.out.println("qsr =="+qstr+"adunidd== "+adUnitId);
            query = session.createQuery(qstr).setInteger("aduid", adUnitId);

            return query.list();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ### USED
    public List<Adunitsplacements> getPlcSubAdUnitsList(Integer plcid, String catId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;
            qstr = "SELECT AP FROM Adunitsplacements AP, Adunits A WHERE AP.placementId = :id AND AP.adUnitId = A.id AND A.placementType IN ("+catId+") ";
            query = session.createQuery(qstr).setInteger("id", plcid);
            return query.list();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getParentId(Integer aduid) {
        Integer id = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;
            qstr = "SELECT A.parentId FROM Adunits A WHERE A.id = :aduid";
            query = session.createQuery(qstr).setInteger("aduid", aduid);

            if (query.list().size() > 0) {
                List<Adunits> lst = query.list();
                Iterator al = lst.listIterator();

                while (al.hasNext()) {
                    Adunits ad = (Adunits) al.next();
                    if (ad.getParentId() != null) {
                        id = Integer.valueOf(ad.getParentId().toString().split("=")[1].split(" ")[0]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return id;
    }

    public Integer AddToLine(Integer mediaplanid, Integer publisherId, Integer adunitId, Integer placementid, Integer parentAdUnitId, Integer flagid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            System.out.println(" media id =  " + mediaplanid + " == " + publisherId + " == " + adunitId + "==" + placementid + "==" + parentAdUnitId);

            Mediaplanline mpl = null;
            Integer returnId = 0;

            if (flagid == 0) {  // 
                mpl = new Mediaplanline();
            } else {
                mpl = (Mediaplanline) session.get(Mediaplanline.class, flagid);
            }

            Publisher p = (Publisher) session.get(Publisher.class, publisherId);
            Adunits a = (Adunits) session.get(Adunits.class, adunitId);
            if(placementid > 0){
                Placements plc = (Placements) session.get(Placements.class, placementid);
                mpl.setName(plc.getName()+" "+a.getSizes());
            }else{
                mpl.setName(a.getName()+" "+a.getSizes());
            }
            
            
            mpl.setPublisherId(p);
            mpl.setCpm(a.getCpm());
            Integer impr = this.getAdUnitImpCount(adunitId);
            mpl.setInventoryProposed(impr);
            mpl.setStatus("PENDING"); // ###
            mpl.setPlanId((Mediaplan) session.get(Mediaplan.class, mediaplanid));
            mpl.setStartDate(new Date()); // ###
            mpl.setEndDate(new Date());  // ###

            if (flagid == 0) {
                session.save(mpl);
                returnId = mpl.getId();
            } else {
                session.saveOrUpdate(mpl);
            }

            this.AddToSubLine(mediaplanid, mpl, p, adunitId, parentAdUnitId, placementid, Double.valueOf(a.getCpm().toString()), impr);

            List<Adunits> list = this.getSubAdUnitsList(adunitId);

            for (Adunits adu : list) {
                Integer adId = adu.getId();
                Integer impression = this.getAdUnitImpCount(adId);
                Double CPM = Double.valueOf(adu.getCpm().toString());
                this.AddToSubLine(mediaplanid, mpl, p, adId, adunitId, placementid, CPM, impression);
            }
            return returnId;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean AddToSubLine(Integer mediaplanid, Mediaplanline mpl, Publisher p, Integer adunitId, Integer parentid, Integer placementid, Double cpm, Integer impr) {
        try {
            Session session = sessionFactory.getCurrentSession();

            Invtargeting inv = new Invtargeting();
            inv.setPublisherId(p);
            Adunits a = (Adunits) session.get(Adunits.class, adunitId);
            if (parentid != null || parentid!=0) {
                Adunits a1 = (Adunits) session.get(Adunits.class, parentid);
                inv.setParentAdUnitId(a1);
            }
            inv.setAdUnitId(a);
             if (placementid!=0) {
            Adunitsplacements ap = (Adunitsplacements) session.get(Adunitsplacements.class, placementid);
            inv.setPlacementId(ap.getPlacementId());
             }
            inv.setParentAdUnitId(a);
            inv.setCpm(BigDecimal.valueOf(cpm));
            inv.setImpressionBooked(impr);
            inv.setPlanLineId(mpl);
            inv.setPrivateFlag("Y");
            inv.setStatus("PENDING");
            inv.setMediaCost(BigDecimal.valueOf(0.00));
            inv.setDiscountPercentage(BigDecimal.valueOf(0.00));
            inv.setCreated(new Date());
            inv.setUpdated(new Date());
            session.save(inv);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Adunits> getSubAdUnitsList(Integer adUnitId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;

            qstr = "SELECT A FROM Adunits A WHERE A.parentId = :aduid ";
            query = session.createQuery(qstr).setInteger("aduid", adUnitId);

            return query.list();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    public Mediaplan getMediaplan(Integer mpid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Mediaplan mp = (Mediaplan) session.get(Mediaplan.class, mpid);
            return mp;
        } catch (Exception e) {
            System.out.println("Error from getMediaplan() from mediaplaninventoryDAOIMPL");
            e.printStackTrace();
            return null;
        }
    }

    
    public boolean updateMediaplan(Integer mpid, String integid, String stat) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Mediaplan mp = (Mediaplan) session.get(Mediaplan.class, mpid);
            mp.setIntegrationId(integid);
            mp.setStatus("PENDING"); // ### because enum type
            session.update(mp);
            session.beginTransaction().commit();
            session.flush();            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Mediaplanline> getMediaplanlineList(Integer mpid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;
            qstr = "SELECT MPL FROM Mediaplanline MPL WHERE MPL.planId = :id";
            query = session.createQuery(qstr).setInteger("id", mpid);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getMediaplanlineImpCount(Integer mplid) {
        Session session = sessionFactory.getCurrentSession();
        String qstr = "SELECT SUM(I.impressionBooked) FROM Invtargeting I WHERE I.planLineId = :mplid";
        Query query = session.createQuery(qstr).setInteger("mplid", mplid);
        Integer totalImp = 0;
        
        if(query.list().size() <=0){
            return totalImp;
        }

        ListIterator mplist = query.list().listIterator();
        try {
            totalImp = ((Long) mplist.next()).intValue();

        } catch (Exception e) {
            totalImp = 0;
            e.printStackTrace();
        }
        return totalImp;
    }
    

    public List<Adunits> getAdunitsList(Integer mplId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;
            qstr = "SELECT A FROM Adunits A , Invtargeting I WHERE I.planLineId = :id AND I.adUnitId = A.id";
            query = session.createQuery(qstr).setInteger("id", mplId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Placements> getPlcTarAdunitsList(Integer mplid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;
            qstr = "SELECT P FROM Placements P , Invtargeting I WHERE I.planLineId = :id AND I.placementId IS NOT NULL AND I.placementId = P.id";
            query = session.createQuery(qstr).setInteger("id", mplid);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertMediaplanlineIntegrationId(Integer mplid, String orderLineId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Mediaplanline mp = (Mediaplanline) session.get(Mediaplanline.class, mplid);
            mp.setIntegrationId(orderLineId);
            session.update(mp);
            session.beginTransaction().commit();
            session.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean syncInsertAdunits(AdunitsData aw) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Adunits au = new Adunits();
            au.setName(aw.getName());
            au.setSizes(aw.getSizes());
            au.setIntegrationId(aw.getId().toString());
            au.setPositions(aw.getPositions());
            session.save(au);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean syncInsertAdunitsUpdatePrentId(Map<String, String> m) {
        try {
            Session session = sessionFactory.getCurrentSession();

            for (Map.Entry<String, String> entry : m.entrySet()) {
                boolean f = this.updateParentIdAdunits(Integer.valueOf(entry.getKey()), Integer.valueOf(entry.getValue()));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateParentIdAdunits(Integer integid, Integer parid) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction().begin();
            String qstr1 = "";
            Query query1 = null;
            qstr1 = "SELECT A FROM Adunits A WHERE A.integrationId = :id ";
            query1 = session.createQuery(qstr1).setInteger("id", integid);
            List<Adunits> adl = query1.list();
            Adunits integrationIdObj = null;
            Adunits parentIdObj = null;
            for (Adunits al : adl) {
                integrationIdObj = (Adunits) session.get(Adunits.class, al.getId()); // integrationid                
            }

            String qstr2 = "";
            Query query2 = null;
            qstr2 = "SELECT A FROM Adunits A WHERE A.integrationId = :parid ";
            query2 = session.createQuery(qstr2).setInteger("parid", parid);

            List<Adunits> adl2 = query2.list();
            for (Adunits al2 : adl2) {
                parentIdObj = (Adunits) session.get(Adunits.class, al2.getId()); // integrationid 
            }

            Adunits aa = (Adunits) session.get(Adunits.class, integrationIdObj.getId()); // integrationid                
            aa.setParentId(parentIdObj);
            session.saveOrUpdate(aa);
            session.flush();
            session.beginTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Exception in updateParentIdAdunits fun");
            e.printStackTrace();
            session.beginTransaction().rollback();
            return false;
        }

    }

    public boolean syncInsertPlacements(AdunitsData wrapper) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction().begin();
            Userprofile up = new Userprofile(); //this is hardcode, laterly change // ###
            up.setId(1);
            Placements p = new Placements();
            p.setId(wrapper.getId());
            p.setName(wrapper.getName());
            p.setCreated(new Date()); // ###
            p.setUpdated(new Date()); // ###
            p.setCreatedBy(up);
            p.setUpdatedBy(up);
            session.save(p);
            session.flush();
            session.beginTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.beginTransaction().rollback();
            return false;
        }
    }

    public boolean syncAdunitPlacements(AdunitsData wr) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction().begin();
            Adunitsplacements ap = new Adunitsplacements();
            Userprofile up = new Userprofile(); //this is hardcode, laterly change // ###
            up.setId(1);
            System.out.println("wr.gitid =" + wr.getId());
            System.out.println("wr.aduid =" + wr.getAdunitid());

            Placements p = (Placements) session.get(Placements.class, wr.getId());
            System.out.println("placement id =" + p.getId());
            ap.setPlacementId(p);

            Adunits a = (Adunits) session.get(Adunits.class, wr.getAdunitid());
            System.out.println("adunit id =" + a.getId());
            ap.setAdUnitId(a);
            ap.setCreated(new Date());
            ap.setUpdated(new Date());
            ap.setCreatedBy(up);
            ap.setUpdatedBy(up);
            session.save(ap);
            session.beginTransaction().commit();
            return true;
        } catch (Exception e) {
            session.beginTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }
 

    // SHARAN
    public List getListofValuesInPlacement(Integer plcmntTypeId, Integer placementId){
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;

            qstr = "SELECT L FROM Adunitsplacements AUP, Adunits, Listofvalues A WHERE AUP.placementId = :placementId AND AUP.adUnitId = A.id AND A.placementType IN ("+plcmntTypeId+") ";
            query = session.createQuery(qstr);
            return query.list();            
        } catch (Exception e) {
            System.out.println("Error from getListofValues() in DAO impl");
            return null;
        }
        
    }
    
    public List<Adunits> getPlacementsAdunits(Integer placementId, Integer plcmntTypeId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;

            qstr = "SELECT A FROM Adunitsplacements AUP, Adunits A WHERE AU.placementId = :placementId P.publisherId = :pid AND P.id = AUP.placementId AND AUP.adUnitId = A.id ";
            query = session.createQuery(qstr).setInteger("pid", placementId);
            return query.list();

        } catch (Exception e) {
            System.out.println("Error from getPlacementsWithPublisherAndType(Integer publisherId, integer plcmntTypeid) fun. in DAO Impl ");
            e.printStackTrace();
            return null;
        }
    }    
    
    public List<Placements> getPlacementsWithPublisherAndType(Integer publisherId, Integer plcmntTypeId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;

            qstr = "SELECT P FROM Placements P, Adunitsplacements AUP, Adunits A WHERE P.publisherId = :pid AND P.id = AUP.placementId AND AUP.adUnitId = A.id ";
            query = session.createQuery(qstr).setInteger("pid", publisherId);
            return query.list();

        } catch (Exception e) {
            System.out.println("Error from getPlacementsWithPublisherAndType(Integer publisherId, integer plcmntTypeid) fun. in DAO Impl ");
            e.printStackTrace();
            return null;
        }
    }

    public List<Adunits> getAdunitsWithPublisherAndType(Integer publisherId, Integer plcmntTypeId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String qstr = "";
            Query query = null;

            qstr = "SELECT A FROM Adunits A WHERE A.publisherId = :pid AND A.parentId IS NULL";
            query = session.createQuery(qstr).setInteger("pid", publisherId);
            return query.list();

        } catch (Exception e) {
            System.out.println("Error from getAdunitsWithPublisherAndType() from DAO impl");
            e.printStackTrace();
            return null;
        }
    }

   public Integer getPacementAdunitsCount(Integer placementId, String plcmntTypeId) {

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            String qstr = "";
            qstr = "SELECT AP FROM Adunitsplacements AP, Adunits A, Listofvalues L WHERE AP.placementId = :plcid AND AP.adUnitId = A.id AND A.placementType IN ("+plcmntTypeId+") ";
            query = session.createQuery(qstr).setInteger("plcid", placementId);
            return query.list().size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
   
    public Double getAdUnitAvgCPM(Integer aduid) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = null;
            String qstr = "";
            qstr = "SELECT AVG(A.CPM) AS CPM FROM Adunits A WHERE A.id = :aduid";
            query = session.createQuery(qstr).setInteger("aduid", aduid);
            if (query.list().size() > 0) {
                return Double.valueOf(query.list().get(0).toString());
            } else {
                return 0.0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
   
} // END CLASS
