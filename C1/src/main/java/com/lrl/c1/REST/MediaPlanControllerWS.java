/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.REST;

import com.lrl.c1.bean.MediaplanBean;
import com.lrl.c1.entity.Account;
import com.lrl.c1.entity.Advertiser;
import com.lrl.c1.entity.Mediaplan;
import com.lrl.c1.entity.Publisher;
import com.lrl.c1.entity.Userprofile;
import com.lrl.c1.service.CommonService;
import com.lrl.c1.util.SendEmail;

import org.springframework.beans.factory.annotation.Autowired;
import com.lrl.c1.service.MediaPlanService;
import com.lrl.c1.service.MediaPlanCreationService;
import com.lrl.c1.service.MediaPlanInventoryService;
import com.lrl.c1.wrapper.CreativeData;
import com.lrl.c1.wrapper.CreativelistData;
import com.lrl.c1.wrapper.GraphData;
import com.lrl.c1.wrapper.MediaplanData;
import com.lrl.c1.wrapper.PublisherData;
import com.lrl.c1.wrapper.UploadData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.lrl.c1.wrapper.AdunitsData;
import com.lrl.c1.util.UploadFile;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author logic
 */
@Component
@Path("/mediaplan")
public class MediaPlanControllerWS {

     
    private static final Log log = LogFactory.getLog(MediaPlanControllerWS.class);
    @Autowired
    private MediaPlanService mediaplanService;
    @Autowired
    private MediaPlanCreationService mediaplancreationService;
//    @Autowired
//    private MediaplanBean mpBean;
    @Autowired
    private CommonService commonService;
    @Autowired
    private MediaPlanInventoryService mediaplanInv;
    @Autowired
    private SessionFactory sessionFactory;

    // FIRST PAGE START
    @GET
    @Path("/mediaplanlist/{mpname:.*}/{advname:.*}/{status:.*}") // Layer 1 - 
    @Produces({"application/json"})
    public List<MediaplanData> getMediaPlanGrp(@PathParam("mpname") String mpname, @PathParam("advname") String advname, @PathParam("status") String status) {
        List<MediaplanData> m = mediaplanService.getMediaPlanGrpList(mpname, advname, status);
        return m;
    }

    @GET
    @Path("/publisherlist/{mpid}") // Layer II  
    @Produces({"application/json"})
    public List<MediaplanData> getMediaPlanPublisherGrp(@PathParam("mpid") Integer mpid) {
        List<MediaplanData> m = mediaplanService.getMediaPlanPublishersList(mpid);
        return m;
    }

    @GET
    @Path("/placementlist/{mpid}/{pubid}") // LayerIII 
    @Produces({"application/json"})
    public List<MediaplanData> getMediaPlanPlacementGrp(@PathParam("mpid") Integer mpid, @PathParam("pubid") Integer pubid) {
        List<MediaplanData> m = mediaplanService.getMediaPlanPlcList(mpid, pubid);
        return m;
    }

    @GET
    @Path("/adunitlist/{mplid}/{pubid}") // Layer IV 
    @Produces({"application/json"})
    public List<MediaplanData> getMediaPlanAdGrp(@PathParam("mplid") Integer mplid, @PathParam("pubid") Integer pubid) {
        List<MediaplanData> m = mediaplanService.getMediaPlanAdunitList(mplid, pubid);
        return m;
    }

    @GET
    @Path("/subadunitlist/{mplid}/{pubid}/{aduid}/{plcid}") // Layer V 
    @Produces({"application/json"})
    public List<MediaplanData> getMediaPlanSubAduGrp(@PathParam("mplid") Integer mplid, @PathParam("pubid") Integer pubid, @PathParam("aduid") Integer aduid, @PathParam("plcid") Integer plcid) {
        List<MediaplanData> m = mediaplanService.getMediaPlanSubAdunitList(mplid, pubid, aduid, plcid);
        return m;
    }

    //FIRST PAGE END 
    
    
    // SECOND PAGE'S REST CALLS STARTED - ie., MEDIAPALN CREATION
    @GET
    @Path("/newmedia/createnewmedia")  // create new media plan 
    @Produces({"application/json"})   // url = /newmedia/createnewmedia?mediaName="name"&startdt="date"&enddt="date"
    public Map createNewMediaplan(@Context UriInfo info) {

        SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdft1 = new SimpleDateFormat("MM-dd-yyyy");

        log.debug("Inside REST call creteNewMediaplan() methods");
        String mediaName = info.getQueryParameters().getFirst("mediaName");
        String startDate = info.getQueryParameters().getFirst("startdt");
        String endDate = info.getQueryParameters().getFirst("enddt");

        Mediaplan mp = new Mediaplan();
        Map<String, Object> map = new HashMap<String, Object>();

        mp.setName(mediaName);

        try {
            mp.setStartDate(sdft.parse(startDate));
            mp.setEndDate(sdft.parse(endDate));
        } catch (Exception e) {
            log.error(e);
            System.out.println("parse in date" + e);
        }

        //@@@ fixed
        Account a = new Account();
        a.setId(1);
        mp.setAccountId(a);
        mp.setTotalImpression(0);
        mp.setTotalCost(new BigDecimal(0.0));
        mp.setStatus("PENDING");
        
        Advertiser ad = new Advertiser(1);
        mp.setAdvertiserId(ad); 
        mp = mediaplancreationService.createNewMediaPlan(mp);
        map.put("mediaId", mp.getId());
        map.put("mediaName", mp.getName());
        map.put("mediaStDate", sdft1.format(mp.getStartDate()));
        map.put("mediaEndDate", sdft1.format(mp.getEndDate()));
        return map;
    }

    @GET
    @Path("/newmedia/publisherlist/{catid}")  // show the list of the publihser in mediaplanline
    @Produces({"application/json"})
    public List<PublisherData> getGroupofPubList(@PathParam("catid") String category_id) {
        List<Publisher> p = commonService.getSearchPublishers(category_id);
        System.out.println(" publisher list is " + p);
        List<PublisherData> m = mediaplancreationService.getGroupofPubList(p);
        return m;
    }

    @GET
    @Path("/newmedia/searchpublisherlist/{catid:.*}/{pubname:.*}/{plctypeid:.*}")  // show the list of the publihser in mediaplanline
    @Produces({"application/json"})
    public List<PublisherData> getGroupofsearchPubList(@PathParam("catid") String catid, @PathParam("pubname") String pubname, @PathParam("plctypeid") String plctypeid) {
        List<PublisherData> m = mediaplancreationService.searchPubList(catid, pubname, plctypeid);
        return m;
    }

    // sharan
    @GET
    @Path("/newmedia/placementlist/{pubid}/{plctypeid}") // API S11
    @Produces({"application/json"})
    public List<PublisherData> getGroupofPlacementList(@PathParam("pubid") Integer pubid, @PathParam("plctypeid") String catid) {
        List<PublisherData> m = mediaplanInv.getListofParentFromPlacementsAndAdunits(pubid, catid);
        return m;
    }

    @GET
    @Path("/newmedia/adunitslist/{plcid}")
    @Produces({"application/json"})
    public List<PublisherData> getGroupofAdunitsList(@PathParam("plcid") Integer plcid) {
        List<PublisherData> m = mediaplancreationService.getGroupofAdUnitList(plcid);
        return m;
    }

    //sharan
    @GET   // API 12
    @Path("/newmedia/subadunitslist/{adunitid}/{placementid}/{plctypeid}")
    @Produces({"application/json"})
    public List<AdunitsData> getGroupofSubAdunitsList(@PathParam("adunitid") Integer adunitid, @PathParam("placementid") Integer placementid, @PathParam("plctypeid") String plctypeid) {
        List<AdunitsData> m = mediaplanInv.getChildFromPlacementsAndAdunits(placementid, adunitid, plctypeid);
        return m;
    }
//## NOT USED

    @GET
    @Path("/newmedia/addtoline_j/{mpid}/{pubid}/{aduid}/{plcid}")
    @Produces({"application/json"})
    @Transactional
    public boolean addtoline(@PathParam("mpid") Integer mpid, @PathParam("pubid") Integer pubid, @PathParam("aduid") Integer adunitid, @PathParam("plcid") Integer plcid) {
        boolean isadded = mediaplancreationService.AddToLine(mpid, pubid, adunitid, plcid);
        return isadded;
    }

    // sharan
    @GET
    @Path("/newmedia1/adunitslist/{id}/{flag}") // id = adunit table PK id or placement table id ; flag = 1 / 0 = placement / adunitds
    @Produces({"application/json"})
    public List<AdunitsData> getSubAdunitsList(@PathParam("id") Integer id, @PathParam("flag") Integer flag) {
        List<AdunitsData> d = mediaplanInv.getSubAdUnitList(id, flag);
        return d;
    }
    // sharan

    @GET
    @Path("/newmedia/addtoline/{mpid}/{pubid}/{aduid}/{plcid}/{parauid}/{flag}") // flag = 0, new mediaplan create, and flag = {mpline} id, update for that mpline invtargeting table it used for left side search.  
    @Produces({"application/json"})
    @Transactional
    public Integer addToLine(@PathParam("mpid") Integer mpid, @PathParam("pubid") Integer pubid, @PathParam("aduid") Integer adunitid, @PathParam("plcid") Integer plcid, @PathParam("parauid") Integer parauid, @PathParam("flag") Integer flag) {
        Integer isadded = mediaplanInv.AddToLine(mpid, pubid, adunitid, plcid, parauid, flag);
        return isadded;
    }

    // Sri -- start
    @GET
    @Path("/gender")
    @Produces({"application/json"})
    public List getGenderList() {
        return commonService.getGenderList();

    }

    @GET
    @Path("/agerange")
    @Produces({"application/json"})
    public List getAgeRange() {
        return commonService.getAgeRangeList();
    }

    @GET
    @Path("/placementtypes")
    @Produces({"application/json"})
    public List getPlacementTypes() {
        return commonService.getPlacementTypesList();
    }

    @GET
    @Path("/countries")
    @Produces({"application/json"})
    public List getCountries() {
        return commonService.getCountriesList();

    }

    @GET
    @Path("/countries/states/{country}")
    @Produces({"application/json"})
    public List getStates(@PathParam("country") String c) {
        return commonService.getStatesList(c);
    }

    @GET
    @Path("/states/city/{city}")
    @Produces({"application/json"})
    public List getCity(@PathParam("city") String c) {
        return commonService.getCitiesList(c);
    }

    @GET
    @Path("/publishercontact/{publisher_id}")
    @Produces({"application/json"})
    public Map getPublisherContact(@PathParam("publisher_id") Integer publisher_id) {
        return commonService.getPublisherContactAsMap(publisher_id);
    }

    @GET
    @Path("/publisherid/{category_id}")
    @Produces({"application/json"})
    public List getPublisherId(@PathParam("category_id") String category_id) {
        return commonService.getPublisherIdList(category_id);
    }

    @GET
    @Path("/categorylist")
    @Produces({"application/json"})
    public List getCategoryList() {
        return commonService.getCategoryList();
    }

    // sri end   // 2nd page end 
    // 3rd page ###
    @GET
    @Path("/getmediaplandetails/{mpid}")
    @Produces({"application/json"})
    public MediaplanData getMediaPlanDetails(@PathParam("mpid") Integer mpid) {

        MediaplanData mpd = mediaplancreationService.getMediaPlanDetails(mpid);

        return mpd;


    }

    @GET
    @Path("/updatemediaplanline/{mpid}/{mplid}/{sdt}/{endt}/{imp}")
    @Produces({"application/json"})
    @Transactional
    public String updateMediaplanLine(@PathParam("mpid") Integer mpid, @PathParam("mplid") Integer mplid, @PathParam("sdt") String sdt, @PathParam("endt") String endt, @PathParam("imp") Integer imp) {
        try {



            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date stdt = null;
            Date enddt = null;
            try {
                stdt = sdf.parse(sdt);
                System.out.println(" sdt ==  " + stdt);
                enddt = sdf.parse(endt);
                System.out.println("end ==  " + enddt);
            } catch (Exception e) {
                e.printStackTrace();
            }

            String msg = "";
            boolean isUpdate = mediaplanService.MediaplanlineUpdate(mpid, mplid, stdt, enddt, imp);

            if (isUpdate) {
                msg = "MediaLine updated sucessfully";
            } else {
                msg = "Error in updated";
            }
            return msg;

        } catch (Exception e) {
            return e.toString();
        }


    }

    @GET
    @Path("/deletepublisher/{mpid}/{pubid}")
    @Produces({"application/json"})
    @Transactional
    public boolean deletepublisher(@PathParam("mpid") Integer mpid, @PathParam("pubid") Integer pubid) {
        return mediaplancreationService.DeletePublisher(mpid, pubid);
    }

    @GET
    @Path("/deleteplacement/{mplid}")
    @Produces({"application/json"})
    @Transactional
    public boolean deleteplacement(@PathParam("mplid") Integer mplid) {
        return mediaplancreationService.DeletePlacement(mplid);
    }

    @GET
    @Path("/deleteadunits/{mplid}/{pubid}/{aduid}/{plcid}")
    @Produces({"application/json"})
    @Transactional
    public boolean deleteadunits(@PathParam("mplid") Integer mplid, @PathParam("pubid") Integer pubid, @PathParam("aduid") Integer aduid, @PathParam("plcid") Integer plcid) {
        return mediaplancreationService.DeleteAdunits(mplid, pubid, aduid, plcid);
    }

    @GET
    @Path("/deletesubadunits/{mplid}/{pubid}/{aduid}")
    @Produces({"application/json"})
    @Transactional
    public boolean deletesubadunits(@PathParam("mplid") Integer mplid, @PathParam("pubid") Integer pubid, @PathParam("aduid") Integer aduid) {
        return mediaplancreationService.DeleteSubAdunits(mplid, pubid, aduid);
    }

    @GET
    @Path("/publisherpiechart/{mpid}")
    @Produces({"application/json"})
    public List<GraphData> getPublisherPieChartData(@PathParam("mpid") Integer mpid) {
        return mediaplancreationService.getPublisherPieChartData(mpid);
    }

    @GET
    @Path("/publisherbarchart/{mpid}")
    @Produces({"application/json"})
    public List<GraphData> getPublisherBarGraphData(@PathParam("mpid") Integer mpid) {
        return mediaplancreationService.getBarChartData(mpid);
    }

    /**
     * END *
     */
    // 4th page start
    @GET
    @Path("/linecreatives/{mpid}/{placementtypeid:.*}")
    @Produces({"application/json"})
    public List<CreativeData> getLineCreatives(@PathParam("mpid") Integer mpid, @PathParam("placementtypeid") Integer plctype) {
        List<CreativeData> mp = mediaplancreationService.getMediaPlanlineCreatives(mpid, plctype);
        return mp;
    }

    @GET
    @Path("/searchmediaplanline/{mpid}/{placementtypeid:.*}")
    @Produces({"application/json"})
    public List<CreativeData> getAllCreatives(@PathParam("mpid") Integer mpid, @PathParam("placementtypeid") Integer plctype) {
        List<CreativeData> mp = mediaplancreationService.getMediaPlanlineCreatives(mpid, plctype);
        return mp;
    }

    //NOT USED
    @GET
    @Path("/adunitcreatives/{mplid}/{placementtypeid:.*}")
    @Produces({"application/json"})
    public List<CreativeData> getAdunitCreatives(@PathParam("mplid") Integer mplid, @PathParam("placementtypeid") Integer plctype) {

        List<CreativeData> ad = mediaplancreationService.getAdUnitCreatives(mplid, plctype);

        return ad;
    }

    //NOT USED
    @GET
    @Path("/subadunitcreatives/{mplid}/{placementtypeid}/{aduid}")
    @Produces({"application/json"})
    public List<CreativeData> getSubadunitCreatives(@PathParam("mplid") Integer mplid, @PathParam("placementtypeid") Integer plctype, @PathParam("aduid") Integer aduid) {
        List<CreativeData> ad = mediaplancreationService.getSubAdUnitCreatives(mplid, plctype, aduid);
        return ad;
    }

    @GET
    @Path("/mediaplanlinecreativelist/{mplid}")
    @Produces({"application/json"})
    public List<CreativelistData> showCreativeList(@PathParam("mplid") Integer mplid) {
        System.out.println(" In creative luist  ");
        List<CreativelistData> creative = mediaplancreationService.showCreativeListforline(mplid);
        // System.out.println("   Afterr cterative list ");
        // System.out.println(" Bean ==  "+creative.listIterator().next().getName());

        return creative;
    }

    @GET
    @Path("/mediaplancreativelist/{mpid}")
    @Produces({"application/json"})
    public List<CreativelistData> showCreativeListPlan(@PathParam("mpid") Integer mpid) {
        System.out.println(" In creative luist  ");
        List<CreativelistData> creative = mediaplancreationService.showCreativeListForMediaplan(mpid);
        // System.out.println("   Afterr cterative list ");
        // System.out.println(" Bean ==  "+creative.listIterator().next().getName());

        return creative;
    }

    @GET
    @Path("/deletemediaplancreative/{creativelistid}")
    @Produces({"application/json"})
    public boolean DeleteCreativeListForPlan(@PathParam("creativelistid") Integer mpid) {
        return mediaplancreationService.DeleteCreativeListForPlan(mpid);
    }

    @GET
    @Path("/deletemediaplanlinecreative/{creativeid}")
    @Produces({"application/json"})
    public boolean DeleteCreativeList(@PathParam("creativeid") Integer cid) {
        return mediaplancreationService.DeleteCreativeList(cid);
    }

    @POST
    @Path("/uploadmediaplancreative")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces({"application/json"})
    @Transactional
    public Response uploadcreative(@FormDataParam("mediaplanid") Integer mpid,
            @FormDataParam("size") String size,
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {
        try {

            String error = "";
            if (mpid == null) {

                error += " Mediaplanid is empty,";
            }

            if (size.trim().length() == 0 || size == null) {
                error += " Size is empty,";
            }

             byte[] bytes = IOUtils.toByteArray(uploadedInputStream); 
            if (bytes.length==0) {
                error += " File is empty,";
            }


            if (error.length() > 0) {
                return Response.status(400).entity("Error : " + error).build();
            }


            if (mediaplancreationService.MediaplanExist(mpid) != true) {
                return Response.status(400).entity("Error : Mediaplanid not exist").build();
            }
            String etag = "";
            //saveToFile(  uploadedInputStream, fileDetail.getFileName());   
            UploadFile udf = new UploadFile();
            etag = udf.uploadCreatives(uploadedInputStream, fileDetail);


            if (etag.startsWith("ERROR")) {
                return Response.status(400).entity("Error : Not uploaded in s3 " + etag).build();
            }


            UploadData upd = new UploadData();
            upd.setMediaPlanId(mpid);
            upd.setMediaPlanLineId(0);
            upd.setName(fileDetail.getFileName());

            upd.setSize(size);
            upd.setLink("https://s3-us-west-2.amazonaws.com/c1x/banners/" + fileDetail.getFileName());

            upd = mediaplancreationService.uploadCreative(upd);
            return Response.status(200).entity(upd).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("Error : Check all values " + e.getMessage()).build();
        }

    }

    @POST
    @Path("/uploadmediaplanlinecreative")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces({"application/json"})
    @Transactional 
    public Response uploadlinecreative(@FormDataParam("mediaplanid") Integer mpid,
            @FormDataParam("mediaplanlineid") Integer mplid,
            @FormDataParam("size") String size,
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {
        try {


            String error = "";
            if (mpid == null) {

                error += " Mediaplanid is empty,";
            }

            if (mplid == null) {

                error += " Mediaplanlineid is empty,";
            }

            if (size.trim().length() == 0 || size == null) {
                error += " Size is empty,";
            }

             byte[] bytes = IOUtils.toByteArray(uploadedInputStream); 
            if (bytes.length==0) {
                error += " File is empty,";
            }



            //System.out.println("error.length  "+error.length);
            if (error.length() > 0) {
                return Response.status(400).entity("Error : " + error).build();
            }
            if (mediaplancreationService.MediaplanExist(mpid) != true) {
                return Response.status(400).entity("Error : Mediaplanid not exist").build();
            }

            if (mediaplancreationService.MediaplanlineExist(mpid) != true) {
                return Response.status(400).entity("Error : Mediaplanlineid not exist").build();
            }


            UploadFile udf = new UploadFile();

            String etag = udf.uploadCreatives(uploadedInputStream, fileDetail);

            if (etag.startsWith("ERROR")) {
                return Response.status(400).entity("Error : Not uploaded in s3 " + etag).build();
            }


            UploadData upd = new UploadData();
            upd.setMediaPlanId(mpid);
            upd.setMediaPlanLineId(mplid);
            upd.setName(fileDetail.getFileName());
            upd.setSize(size);
            upd.setLink("https://s3-us-west-2.amazonaws.com/c1x/banners/" + fileDetail.getFileName());
            upd = mediaplancreationService.uploadCreative(upd);



            return Response.status(200).entity(upd).build();
        } catch (Exception e) {
            return Response.status(500).entity("Error : check all values " + e.getMessage()).build();
        }
    }

    // save uploaded file to new location
    private void saveToFile(InputStream uploadedInputStream,
            String uploadedFileLocation) {
        System.out.println("  Saving a file");
        try {
            OutputStream out = null;
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
                System.out.println(" inside loop");
            }
            System.out.println(" saved success");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // end 4th end
//    @GET
//    @Path("/getPubCount/{param}")
//    @Produces({"application/json"})
//    public Map getPubCount(@PathParam("param") Integer mpid) {
//        mpBean.setPubCount(mediaplanService.getPublisherCount(mpid).getPubCount());
//        Map<String, Object> m = new HashMap<String, Object>();
//        m.put("pubCount", mpBean.getPubCount());
//        return m;
//    }

    @GET
    @Path("/requestProposals")
    @Produces({"application/json"})
    public List<Mediaplan> FetchReqProposals() {
        return mediaplanService.FetchReqProposals();
    }

    // CIS INTEGRATION
    @GET
    @Path("/placeio/{mpid}") //
    @Produces({"application/json"})
    public boolean invokePlaceIO(@PathParam("mpid") Integer mpid) {
        boolean b = mediaplanInv.invokePlaceIO(mpid);
        return b;
    }

    @GET
    @Path("/checkuser/{username}/{password}")
    @Produces({"application/json"})
    public boolean authenticate(@PathParam("username") String username, @PathParam("password") String password) {
        return commonService.authenticate(username, password);
    }

    @GET
    @Path("/createaccount")
    @Produces({"application/json"})
    public Map createAccount(@Context UriInfo info) {
        String name = info.getQueryParameters().getFirst("name");
        String address = ("".equals(info.getQueryParameters().getFirst("address1"))) ? " " : info.getQueryParameters().getFirst("address1");
        String address2 = ("".equals(info.getQueryParameters().getFirst("address2"))) ? " " : info.getQueryParameters().getFirst("address2");

        String city = ("".equals(info.getQueryParameters().getFirst("city"))) ? " " : info.getQueryParameters().getFirst("city");
        String state = ("".equals(info.getQueryParameters().getFirst("state"))) ? " " : info.getQueryParameters().getFirst("state");
        String zipCode = ("".equals(info.getQueryParameters().getFirst("zip"))) ? " " : info.getQueryParameters().getFirst("zip");

        String type = ("".equals(info.getQueryParameters().getFirst("type"))) ? " " : info.getQueryParameters().getFirst("type");
        String billingContactFirstName = ("".equals(info.getQueryParameters().getFirst("bcfn"))) ? " " : info.getQueryParameters().getFirst("bcfn");
        String billingContactLastName = ("".equals(info.getQueryParameters().getFirst("bcln"))) ? " " : info.getQueryParameters().getFirst("bcln");

        String billingContactPhone = ("".equals(info.getQueryParameters().getFirst("bcp"))) ? " " : info.getQueryParameters().getFirst("bcp");
        String billingContactEmail = ("".equals(info.getQueryParameters().getFirst("bce"))) ? " " : info.getQueryParameters().getFirst("bce");
        String paymentMethod = ("".equals(info.getQueryParameters().getFirst("pm"))) ? " " : info.getQueryParameters().getFirst("pm");

        String paymentDetails = ("".equals(info.getQueryParameters().getFirst("pdet"))) ? " " : info.getQueryParameters().getFirst("pdet");
        String integrationid = ("".equals(info.getQueryParameters().getFirst("inteid"))) ? " " : info.getQueryParameters().getFirst("inteid");




        Account ac = new Account();
        Map<String, Object> map = new HashMap<String, Object>();

        ac.setName(name);
        ac.setAddress(address);
        ac.setAddress2(address2);
        ac.setCity(city);
        ac.setState(state);
        ac.setZipCode(zipCode);
        ac.setType(type);

        ac.setBillingContactFirstName(billingContactFirstName);
        ac.setBillingContactLastName(billingContactLastName);
        ac.setBillingContactPhone(billingContactPhone);
        ac.setBillingContactEmail(billingContactEmail);

        ac.setPaymentMethod(paymentMethod);
        ac.setPaymentDetails(paymentDetails);

        ac.setIntegrationId(integrationid);
        // ac.setCreatedBy(1);
        // ac.setUpdatedBy(1);
        ac.setCreated(new Date());
        ac.setUpdated(new Date());


        ac = commonService.createNewAccount(ac);
        map.put("accountId", ac.getId());
        map.put("status", "Account Created");
        return map;
    }

    // created contact details.
    @GET
    @Path("/createcontact")
    @Produces({"application/json"})
    public Map createContact(@Context UriInfo info) {

        String accountId = info.getQueryParameters().getFirst("acid");
        Integer acid = new Integer(accountId);
        String firstName = ("".equals(info.getQueryParameters().getFirst("fname"))) ? " " : info.getQueryParameters().getFirst("fname");
        String lastName = ("".equals(info.getQueryParameters().getFirst("lname"))) ? " " : info.getQueryParameters().getFirst("lname");

        String middleName = ("".equals(info.getQueryParameters().getFirst("mname"))) ? " " : info.getQueryParameters().getFirst("mname");
        String emailId = ("".equals(info.getQueryParameters().getFirst("email"))) ? " " : info.getQueryParameters().getFirst("email");
        String timeZone = ("".equals(info.getQueryParameters().getFirst("tz"))) ? " " : info.getQueryParameters().getFirst("tz");

        String contactNo = ("".equals(info.getQueryParameters().getFirst("contactno"))) ? " " : info.getQueryParameters().getFirst("contactno");
        String type = ("".equals(info.getQueryParameters().getFirst("type"))) ? " " : info.getQueryParameters().getFirst("type");
        String status = ("".equals(info.getQueryParameters().getFirst("status"))) ? " " : info.getQueryParameters().getFirst("status");

        String userName = ("".equals(info.getQueryParameters().getFirst("uname"))) ? " " : info.getQueryParameters().getFirst("uname");

        String passWord = commonService.generatePassword();
        String encPassWord = commonService.encryptPassword(passWord);
        System.out.println(" password =" + passWord);


        Userprofile up = new Userprofile();
        Map<String, Object> map = new HashMap<String, Object>();
        Session session = sessionFactory.getCurrentSession();
        Account ac = (Account) session.get(Account.class, acid);
        up.setAccountId(ac);
        up.setFirstName(firstName);
        up.setLastName(lastName);
        up.setMiddleName(middleName);
        up.setEmailId(emailId);
        up.setTimeZone(timeZone);
        up.setContactNo(contactNo);
        // up.setType(type);
        up.setStatus(status);
        up.setUserName(userName);
        up.setPassWord(encPassWord);
        System.out.println("password =" + passWord);
        System.out.println("enc pwd=" + encPassWord);
        up = commonService.createNewUserProfile(up);
        map.put("AccountId", accountId);
        map.put("Contact Id", up.getId());
        map.put("status", "Contact Created");

        //map.put("pwd",passWord);
        SendEmail sm = new SendEmail();
        sm.sendMail(userName, passWord, emailId);
        return map;

    }

   
}
