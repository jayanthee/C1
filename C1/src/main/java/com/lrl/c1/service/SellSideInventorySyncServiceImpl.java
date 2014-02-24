/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.service;

import com.lrl.c1.dao.MediaPlanInventoryDAO;
import com.lrl.c1.dao.SellSideInventorySyncDAO;
import com.lrl.c1.entity.Inventorysettings;
import com.lrl.c1.entity.Vendors;
import com.lrl.c1.util.C1JsonParserService;
import com.lrl.c1.wrapper.AdunitsData;
import com.lrl.c1.wrapper.SellSideSyncSettingData;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author logic
 */
@Service("SellsideInvSyncService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SellSideInventorySyncServiceImpl implements SellSideInventorySyncService {

    @Autowired
    private MediaPlanInventoryDAO mediaplanInvDao;
    @Autowired
    private SellSideInventorySyncDAO sellSideInvDAO;
    @Autowired
    private C1JsonParserService c1jsonparser;
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    SimpleDateFormat sdfhms = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
    NumberFormat nf = new DecimalFormat("0.00");

    // CIS service
    public boolean syncAdUnits(Integer venId, Integer pubId, Integer invSetId, String display) {
        boolean syncFlag = false;
        boolean syncupd = false;
        try {

            //String URL = "http://50.112.157.222/CIS/adunits?networkId=57383456";
            String URL = "http://50.112.157.222/CIS/adunits?networkId=269233203";
            JSONArray json = c1jsonparser.readJsonArrayFromUrl(URL);
            // Map<inventoryid, parentid>
            Map<String, String> map = new HashMap<String, String>();

            Map<String, AdunitsData> dataObj = new HashMap<String, AdunitsData>();

            String integrationId = null;

            for (int i = 0; i < json.length(); i++) {
                AdunitsData wrapper = new AdunitsData();

                JSONObject jsonObject = json.getJSONObject(i);
                wrapper.setId(Integer.valueOf(jsonObject.getString("inventoryId").toString())); // in response adunits id                

                wrapper.setName(jsonObject.getString("name").toString());

                if (jsonObject.opt("parentId").toString() != "null") {
                    wrapper.setParentaddunitid(Integer.valueOf(jsonObject.getString("parentId").toString()));
                    map.put(jsonObject.getString("inventoryId").toString(), jsonObject.getString("parentId").toString());
                } else {
                    wrapper.setParentaddunitid(0);
                }
                wrapper.setPositions(jsonObject.getString("targetWindow").toString());

                if (jsonObject.opt("sizes").toString() != "null") {
                    String str = jsonObject.opt("sizes").toString();
                    System.out.println("Str Sizes="+str);
                    JSONArray injson = new JSONArray(str);
                    String sizes = null;
                    for (int j = 0; j < injson.length(); j++) {
                        JSONObject jsonObj = injson.getJSONObject(j);
                        sizes = jsonObj.get("width").toString() + "x" + jsonObj.get("height").toString();
                        System.out.println("AdUnitSizes =="+sizes);
                    }
                    wrapper.setSizes(sizes);

                }
                System.out.println("invId="+jsonObject.getString("inventoryId").toString());
                dataObj.put(jsonObject.getString("inventoryId").toString(), wrapper);
                //syncFlag = mediaplanInvDao.syncInsertAdunits(wrapper);
            }
            //syncupd = mediaplanInvDao.syncInsertAdunitsUpdatePrentId(map);

            return sellSideInvDAO.syncAdunitsTable(dataObj, map, venId, pubId, invSetId, display);

        } catch (IOException ex) {
            Logger.getLogger(SellSideInventorySyncServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(SellSideInventorySyncServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return syncFlag;
    }

    public boolean syncPlacements() {
        boolean syncFlag = false;
        boolean aduflag = false;
        try {
            String URL = "http://50.112.157.222/CIS/placements?networkId=57383456";
            JSONArray json = c1jsonparser.readJsonArrayFromUrl(URL);

            List<AdunitsData> wrapper = new ArrayList<AdunitsData>();
            Map<String, Object> obj1 = new HashMap<String, Object>();

            Map<List<AdunitsData>, List<AdunitsData>> objData = new HashMap<List<AdunitsData>, List<AdunitsData>>();
            List<AdunitsData> listwr = new ArrayList<AdunitsData>();

            for (int i = 0; i < json.length(); i++) {

                JSONObject jsonObject = json.getJSONObject(i);

                obj1.put(jsonObject.getString("inventoryId").toString(), jsonObject.getString("name").toString());


                if (jsonObject.opt("targetedAdunitIds").toString() != "null") {
                    String str = jsonObject.opt("targetedAdunitIds").toString();
                    JSONArray injson = new JSONArray(str);
                    for (int j = 0; j < injson.length(); j++) {
                        AdunitsData aduplcwr = new AdunitsData();
                        aduplcwr.setId(Integer.valueOf(jsonObject.getString("inventoryId").toString()));
                        aduplcwr.setAdunitid(Integer.valueOf(injson.get(j).toString()));
                        listwr.add(aduplcwr);
                    }
                }

            }

            return sellSideInvDAO.syncPlacementTable(obj1, listwr);

        } catch (IOException ex) {
            Logger.getLogger(SellSideInventorySyncServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(SellSideInventorySyncServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return syncFlag;
    }

    public SellSideSyncSettingData createVendors(SellSideSyncSettingData sync) {
        try {
            return sellSideInvDAO.createVendors(sync);
        } catch (Exception e) {
            System.out.println("Error createVendors()fun from services ");
            e.printStackTrace();
            return null;
        }
    }

    public SellSideSyncSettingData createInvSync(SellSideSyncSettingData sync) {
        try {
            return sellSideInvDAO.createInvSync(sync);
        } catch (Exception e) {
            System.out.println("Error createVendors()fun from services ");
            e.printStackTrace();
            return null;

        }
    }

    public SellSideSyncSettingData updateVendors(SellSideSyncSettingData sync) {
        try {
            return sellSideInvDAO.updateVendors(sync);
        } catch (Exception e) {
            System.out.println("Error updateVendors()fun from services ");
            e.printStackTrace();
            return null;
        }
    }

    public SellSideSyncSettingData updateInvSync(SellSideSyncSettingData sync) {
        try {
            return sellSideInvDAO.updateInvSync(sync);
        } catch (Exception e) {
            System.out.println("Error updateInvSync()fun from services ");
            e.printStackTrace();
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean deleteVendors(Integer venId) {
        try {
            return sellSideInvDAO.deleteVendors(venId);
        } catch (Exception e) {
            System.out.println("Error deleteVendors()fun from services ");
            e.printStackTrace();
            return false;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean deleteSyncInvVendors(Integer syncId) {
        try {
            return sellSideInvDAO.deleteInvSyncVendors(syncId);
        } catch (Exception e) {
            System.out.println("Error deleteSyncInvVendors()fun from services ");
            e.printStackTrace();
            return false;
        }
    }

    public List<SellSideSyncSettingData> getAllVendorsList() {
        try {
            List<Vendors> listVen = null;
            List<SellSideSyncSettingData> venWrappper = new ArrayList<SellSideSyncSettingData>();

            listVen = sellSideInvDAO.getVendorsList();
            System.out.println("size =" + listVen.size());
            Iterator i = listVen.listIterator();

            while (i.hasNext()) {
                SellSideSyncSettingData sd = new SellSideSyncSettingData();
                Vendors v = (Vendors) i.next();
                sd.setVenId(v.getId()); // PK value 
                sd.setVenName(v.getName());
                //sd.setVenLogo(v.getLogo());
                sd.setVenLink(v.getLink());
                sd.setInvSyncTotImp(25000); // ###
                venWrappper.add(sd);
            }
            return venWrappper;
        } catch (Exception e) {
            System.out.println("Error getAllVendorsList()fun from services ");
            e.printStackTrace();
            return null;
        }
    }

    public List<SellSideSyncSettingData> getVendorInvSettingList(Integer venId) {
        try {
            List<Inventorysettings> listInvSet = null;
            List<SellSideSyncSettingData> wrappper = new ArrayList<SellSideSyncSettingData>();

            listInvSet = sellSideInvDAO.getSyncSetVendorsData(venId);
            Iterator i = listInvSet.listIterator();

            while (i.hasNext()) {
                SellSideSyncSettingData sd = new SellSideSyncSettingData();
                Inventorysettings invSync = (Inventorysettings) i.next();

                sd.setInvSyncId(invSync.getId());
                sd.setInvSyncUserName(invSync.getUserName());
                sd.setInvSyncStatus(invSync.getStatus());
                sd.setInvSyncTotImp(invSync.getTotalImpression()); // ###
                sd.setInvSyncPubInvPercent(invSync.getPublicInventroyPercent());
                sd.setInvSyncPrInvPercent(invSync.getPrivateInventoryPercent());
                wrappper.add(sd);
            }
            return wrappper;
        } catch (Exception e) {
            System.out.println("Error getVendorInvSettingList()fun from services ");
            e.printStackTrace();
            return null;
        }
    }

    public SellSideSyncSettingData getVendor(Integer venId) {
        return sellSideInvDAO.getVendor(venId);
    }

    public List<SellSideSyncSettingData> fetchVendorsListData() { 
        try {

            List<Inventorysettings> listInvSet = null;
            List<SellSideSyncSettingData> wrapper = new ArrayList<SellSideSyncSettingData>();

            listInvSet = sellSideInvDAO.fetchGrpVendorsData();
            Iterator i = listInvSet.listIterator();

            while (i.hasNext()) {
                SellSideSyncSettingData sd = new SellSideSyncSettingData();
                
                Inventorysettings invSync = (Inventorysettings) i.next();
                sd.setVenId(invSync.getVendor().getId());
                sd.setVenName(invSync.getVendor().getName());
                //sd.setVenLogo(invSync.getVendor().getLogo());
                sd.setVenLogo(null);
                sd.setVenLink(invSync.getVendor().getLink());
                sd.setInvSyncId(invSync.getId());
                sd.setInvSyncUserName(invSync.getUserName());
                sd.setInvSyncStatus(invSync.getStatus());
                sd.setInvSyncTotImp(invSync.getTotalImpression()); // ###
                sd.setInvSyncPubInvPercent(invSync.getPublicInventroyPercent());
                sd.setInvSyncPrInvPercent(invSync.getPrivateInventoryPercent());  
                wrapper.add(sd);
            }
            return wrapper;
        } catch (Exception e) {
            System.out.println("Error from fetchVendorsListData() fun in Impl");
            e.printStackTrace();
            return null;
        }
    }
    
    
    public boolean updateImpressionSetting(Integer venId, Integer month,  Integer year, String prvtflag, Integer percent, Integer pubId){
        try {
            
            
            return sellSideInvDAO.updateImpressionSetting(venId, month,  year, prvtflag, percent, pubId);
           
            
        } catch (Exception e) {
            System.out.println("Error from updateImpressionSetting(,,,,,) in Service Impl ");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean twelveMonthImpressionSetting(Integer syncId, Integer impression,  Integer pubPercent, Integer prvtPercent, Integer month, Integer year){
     
        try {
            return sellSideInvDAO.yearlyImpressionSetting(syncId, impression, pubPercent, prvtPercent, month, year);
            
        } catch (Exception e) {
            System.out.println("tweleMonthImpressinSetting() in Service IMP");
            return false;
        }
        
        
    }
}
