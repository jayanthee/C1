/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.REST;

import com.lrl.c1.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import com.lrl.c1.service.MediaPlanInventoryService;
import com.lrl.c1.service.SellSideInventorySyncService;
import com.lrl.c1.wrapper.SellSideSyncSettingData;
import com.mysql.jdbc.Blob;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author logic
 */
@Component
@Path("/sellcis")
public class SellSideControllerWS {

    private static final Log log = LogFactory.getLog(SellSideControllerWS.class);
    @Autowired
    private MediaPlanInventoryService mediaplanInv;
    @Autowired
    private SellSideInventorySyncService sellSideInvSyncSer;
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CommonService commonService;

    // CIS INTEGRATION
    @GET
    @Path("/placeio/{mpid}") //
    @Produces({"application/json"})
    public boolean invokePlaceIO(@PathParam("mpid") Integer mpid) {
        boolean b = mediaplanInv.invokePlaceIO(mpid);
        return b;
    }

    // CIS API - AU-0
    @GET
    @Path("/syncadunits/{venid}/{pubid}/{invsetid}/{display}")
    @Produces({"application/json"})
    public boolean syncAdUnits(@PathParam("venid") Integer venId, @PathParam("pubid") Integer pubId, @PathParam("invsetid") Integer invSetId, @PathParam("display") String display) {
        boolean b = sellSideInvSyncSer.syncAdUnits(venId, pubId, invSetId, display);
        return b;
    }

    //CIS API - PL-0
    @GET
    @Path("/syncplacements/")
    @Produces({"application/json"})
    public boolean syncPlacements() {
        boolean b = sellSideInvSyncSer.syncPlacements();
        return b;
    }

    @GET
    @Path("/createvendor")
    @Produces({"application/json"})
    public SellSideSyncSettingData createVendor(@Context UriInfo info) {
        //dont delete 
        String vendorName = info.getQueryParameters().getFirst("venname");
        String vendorImage = info.getQueryParameters().getFirst("venimg"); // research more , how to send image         
        String vendorLink = info.getQueryParameters().getFirst("venlink");


        // for testing purpose        
        //String vendorName = "DFP";
        // String vendorImage = ""; // research more , how to send image         
        // String vendorLink = "http://www.dfp.com";

        SellSideSyncSettingData syncdata = new SellSideSyncSettingData(0, vendorName, vendorImage, vendorLink);

        return sellSideInvSyncSer.createVendors(syncdata);

    }

    @POST
    @Path("/createvendor1")
    @Produces({"application/json"})
    public SellSideSyncSettingData createVendor__(@RequestBody SellSideSyncSettingData wr) {// , @RequestParam("file") MultipartFile file ) {
//
//        // for testing purpose
//        
//        String vendorName = wr.getVenName(); //"LiveRail";
//        String vendorImage = ""; // research more , how to send image         
//        String vendorLink = wr.getVenLink();//  "http://www.LiveRail.com";
//        
//        System.out.println("file name ="+file.getName()+"  Org file name ="+file.getOriginalFilename());
//        byte[] bFile = new byte[(int) file.getSize()];
//        
//        try {        
//            file.getInputStream().read(bFile);
//            file.getInputStream().close();
//        } catch (Exception e) {
//            System.out.println("Error in image upload createVendor() fun DAO Impl");
//	     e.printStackTrace();
//        }
//        
//
//        SellSideSyncSettingData syncdata = new SellSideSyncSettingData(0,vendorName, vendorImage, vendorLink, bFile);
//
//        return sellSideInvSyncSer.createVendors(syncdata);

        return null;
    }

    @GET
    @Path("/createinventorysync")
    @Produces({"application/json"})
    public SellSideSyncSettingData createInvSync(@Context UriInfo info) {
        //dont delete   
//        String vendorUser   = info.getQueryParameters().getFirst("venuser");
//        String vendorPwd   = info.getQueryParameters().getFirst("venpwd");
//        String vendorStatus  = info.getQueryParameters().getFirst("venstatus");        
//        Integer vendorTotImp  = 15000;// ### using FC-0 & FC-1 
//        Integer vendorPubInvPer  = Integer.valueOf(info.getQueryParameters().getFirst("venpupper")); 
//        Integer vendorPrivInvPer  = Integer.valueOf(info.getQueryParameters().getFirst("venprivper"));        
//        String passWord      = info.getQueryParameters().getFirst("venpwd"); // check max char for validation 

        // for testing purpose
        Integer vendorId = 3;//2;//1;
        Integer pubId = 345;
        String vendorUser = "dfp";// "liverail";
        String vendorPwd = "dfp";
        String vendorStatus = "sync completed";
        Integer vendorTotImp = 2500000;// ### using FC-0 & FC-1 
        Integer vendorPubInvPer = 30;
        Integer vendorPrivInvPer = 70;
        String encPassWord = commonService.encryptPassword(vendorPwd);
        System.out.println(" password = " + encPassWord);

        SellSideSyncSettingData syncdata = new SellSideSyncSettingData(0, vendorId, vendorUser, encPassWord, vendorStatus, vendorTotImp, vendorPubInvPer, vendorPrivInvPer, pubId);

        return sellSideInvSyncSer.createInvSync(syncdata);

    }

    @GET
    @Path("/updatevendor")
    @Produces({"application/json"})
    public SellSideSyncSettingData updateVendor(@Context UriInfo info) {
// dont delete

//        Integer venId    =  Integer.valueOf(info.getQueryParameters().getFirst("venid")); // PK Id for vendors table
//        Integer invSyncId    =  Integer.valueOf(info.getQueryParameters().getFirst("invsyncid")); // PK Id for inventorysettings table
//        String vendorName    = info.getQueryParameters().getFirst("venname");
//        String vendorImage   = info.getQueryParameters().getFirst("venimg"); // research more , how to send image         
//        String vendorLink   = info.getQueryParameters().getFirst("venlink");
//        
//        String vendorUser   = info.getQueryParameters().getFirst("venuser");
//        String vendorPwd   = info.getQueryParameters().getFirst("venpwd");
//        String vendorStatus  = info.getQueryParameters().getFirst("venstatus");        
//        Integer vendorTotImp  = 15000;// ### using FC-0 & FC-1 
//        Integer vendorPubInvPer  = Integer.valueOf(info.getQueryParameters().getFirst("venpupper")); 
//        Integer vendorPrivInvPer  = Integer.valueOf(info.getQueryParameters().getFirst("venprivper"));
//        
//        String passWord      = info.getQueryParameters().getFirst("venpwd"); // check max char for validation 
//        String encPassWord   = commonService.encryptPassword(passWord);
//        System.out.println(" password = "+passWord);

        // for testing purpose
        Integer venId = 4;
        String vendorName = "LOGIC RESEARCH LABS";
        String vendorImage = ""; // research more , how to send image         
        String vendorLink = "http://www.logicresearchlabs.com";

        SellSideSyncSettingData syncdata = new SellSideSyncSettingData(venId, vendorName, vendorImage, vendorLink);

        return sellSideInvSyncSer.updateVendors(syncdata);

    }

    @GET
    @Path("/updateinventorysync")
    @Produces({"application/json"})
    public SellSideSyncSettingData updateInvSync(@Context UriInfo info) {
// dont delete

//        Integer venId    =  Integer.valueOf(info.getQueryParameters().getFirst("venid")); // PK Id for vendors table
//        Integer invSyncId    =  Integer.valueOf(info.getQueryParameters().getFirst("invsyncid")); // PK Id for inventorysettings table
//        String vendorName    = info.getQueryParameters().getFirst("venname");
//        String vendorImage   = info.getQueryParameters().getFirst("venimg"); // research more , how to send image         
//        String vendorLink   = info.getQueryParameters().getFirst("venlink");
//        
//        String vendorUser   = info.getQueryParameters().getFirst("venuser");
//        String vendorPwd   = info.getQueryParameters().getFirst("venpwd");
//        String vendorStatus  = info.getQueryParameters().getFirst("venstatus");        
//        Integer vendorTotImp  = 15000;// ### using FC-0 & FC-1 
//        Integer vendorPubInvPer  = Integer.valueOf(info.getQueryParameters().getFirst("venpupper")); 
//        Integer vendorPrivInvPer  = Integer.valueOf(info.getQueryParameters().getFirst("venprivper"));
//        
//        String passWord      = info.getQueryParameters().getFirst("venpwd"); // check max char for validation 
//        String encPassWord   = commonService.encryptPassword(passWord);
//        System.out.println(" password = "+passWord);

        // for testing purpose
        Integer venId = 1;
        Integer invSyncId = 1;
        Integer pubId = 345;
        String vendorUser = "liverail";
        String vendorPwd = "liverail";
        String vendorStatus = "sync";
        Integer vendorTotImp = 1500000;// ### using FC-0 & FC-1 
        Integer vendorPubInvPer = 20;
        Integer vendorPrivInvPer = 80;
        String passWord = vendorPwd;
        String encPassWord = commonService.encryptPassword(passWord);
        System.out.println(" password = " + passWord);
        SellSideSyncSettingData syncdata = new SellSideSyncSettingData(invSyncId, venId, vendorUser, vendorPwd, vendorStatus, vendorTotImp, vendorPubInvPer, vendorPrivInvPer, pubId);
        return sellSideInvSyncSer.updateInvSync(syncdata);

    }

    @GET
    @Path("/deletevendor/{venid}") // PK id  from vendor table // in response , use venId arg.
    @Produces({"application/json"})
    public boolean deleteVendor(@PathParam("venid") Integer venId) {
        return sellSideInvSyncSer.deleteVendors(venId);
    }

    @GET
    @Path("/deleteinvsyncvendor/{syncid}") // PK id  from inventorysettings table //  in response , use "invSyncId" arg
    @Produces({"application/json"})
    public boolean deleteSyncInvVendors(@PathParam("syncid") Integer syncId) {
        return sellSideInvSyncSer.deleteSyncInvVendors(syncId);
    }

    @GET
    @Path("/getvendorslist") // 
    @Produces({"application/json"})
    public List<SellSideSyncSettingData> getVendorsList() {
        return sellSideInvSyncSer.getAllVendorsList();
    }

    @GET
    @Path("/getvendor/{venid}") // vendors table's PK // from response , use venId arg.
    @Produces({"application/json"})
    public SellSideSyncSettingData getvendor(@PathParam("venid") Integer venId) {
        return sellSideInvSyncSer.getVendor(venId);
    }

    @GET
    @Path("/getvendorinvsettinglist/{venid}") // vendors table's PK  // from response, use "venId" arg
    @Produces({"application/json"})
    public List<SellSideSyncSettingData> getVenInvSetList(@PathParam("venid") Integer venId) {
        return sellSideInvSyncSer.getVendorInvSettingList(venId);
    }

    @GET
    @Path("/fetchvendors") // vendors table's PK  // from response, use "venId" arg
    @Produces({"application/json"})
    public List<SellSideSyncSettingData> fetchVendorsList() {
        return sellSideInvSyncSer.fetchVendorsListData();
    }

    @GET
    @Path("/updateimpressionsetting/{vendorid}/{month}/{year}/{prvtflag}/{percent}/{pubid}")
    @Produces({"application/json"})
    public boolean updateImpressionSetting(@PathParam("vendorid") Integer venId, @PathParam("month") Integer month, @PathParam("year") Integer year, @PathParam("prvtflag") String prvtflag, @PathParam("percent") Integer percent, @PathParam("pubid") Integer pubid) {
        return sellSideInvSyncSer.updateImpressionSetting(venId, month, year, prvtflag, percent, pubid);
    }

    @GET
    @Path("/generateYearlyMonthImpression/{syncId}/{impression}/{pubPercent}/{prvtPercent}/{month}/{year}")
    @Produces({"application/json"})
    public boolean generateYearlyMonthImpression(@PathParam("syncId") Integer syncId, @PathParam("impression") Integer impression, @PathParam("pubPercent") Integer pubPercent, @PathParam("prvtPercent") Integer prvtPercent, @PathParam("month") Integer month, @PathParam("year") Integer year) {
        return sellSideInvSyncSer.twelveMonthImpressionSetting(syncId, impression, pubPercent, prvtPercent, month, year);
    }
    //yearlyImpressionSetting(Integer syncId, Integer impression, Integer pubPercent, Integer prvtPercent, Integer month, Integer year)
}
