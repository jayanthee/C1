/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.client;

import com.lrl.c1.wrapper.RatecardData;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import java.io.IOException; 
/**
 *
 * @author logic
 */
 
  


    

      
    public  class SellsideClient {

   
    

        private WebResource webResource;
        private Client client;
        private static final String BASE_URI = "http://localhost:9999/C1/ws";

        public SellsideClient() {
            com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
            client = Client.create(config);
            webResource = client.resource(BASE_URI).path("mediaplan");
        }

        public <T> T getMediaPlanDetails(Class<T> responseType, String mpid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("getmediaplandetails/{0}", new Object[]{mpid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getGenderList(Class<T> responseType) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path("gender");
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getMediaPlanPlacementGrp(Class<T> responseType, String mpid, String pubid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("placementlist/{0}/{1}", new Object[]{mpid, pubid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T addtoline(Class<T> responseType, String mpid, String pubid, String aduid, String plcid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("newmedia/addtoline/{0}/{1}/{2}/{3}", new Object[]{mpid, pubid, aduid, plcid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getSubAdunitsList(Class<T> responseType, String id, String flag) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("newmedia1/adunitslist/{0}/{1}", new Object[]{id, flag}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getMediaPlanSubAduGrp(Class<T> responseType, String mplid, String pubid, String aduid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("subadunitlist/{0}/{1}/{2}", new Object[]{mplid, pubid, aduid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getCategoryList(Class<T> responseType) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path("categorylist");
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T showCreativeList(Class<T> responseType, String mplid, String size) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("showcreativelist/{0}/{1}", new Object[]{mplid, size}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T deletesubadunits(Class<T> responseType, String mplid, String pubid, String aduid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("deletesubadunits/{0}/{1}/{2}", new Object[]{mplid, pubid, aduid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T deleteplacement(Class<T> responseType, String mplid, String pubid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("deleteplacement/{0}/{1}", new Object[]{mplid, pubid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T authenticate(Class<T> responseType, String username, String password) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("checkuser/{0}/{1}", new Object[]{username, password}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T uploadcreative(Class<T> responseType,Object o) throws UniformInterfaceException {
            WebResource resource = webResource;
            return resource.path("uploadmediaplancreative").post(responseType,o);
        }

        public <T> T getGroupofsearchPubList(Class<T> responseType, String catid, String pubname) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("newmedia/searchpublisherlist/{0}/{1}", new Object[]{catid, pubname}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getCountries(Class<T> responseType) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path("countries");
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T deletepublisher(Class<T> responseType, String mpid, String pubid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("deletepublisher/{0}/{1}", new Object[]{mpid, pubid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getStates(Class<T> responseType, String country) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("countries/states/{0}", new Object[]{country}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T FetchReqProposals(Class<T> responseType) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path("requestProposals");
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T createContact(Class<T> responseType) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path("createcontact");
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getMediaPlanAdGrp(Class<T> responseType, String mplid, String pubid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("adunitlist/{0}/{1}", new Object[]{mplid, pubid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getCity(Class<T> responseType, String city) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("states/city/{0}", new Object[]{city}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T createNewMediaplan(Class<T> responseType) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path("newmedia/createnewmedia");
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T fetchMediaPlan(Class<T> responseType) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path("listofmediaplan");
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getPubCount(Class<T> responseType, String param) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("getPubCount/{0}", new Object[]{param}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getGroupofPlacementList(Class<T> responseType, String pubid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("newmedia/placementlist/{0}", new Object[]{pubid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getPlacementTypes(Class<T> responseType) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path("placementtypes");
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T listMediaPlan(Class<T> responseType) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path("mediaURL");
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T invokePlaceIO(Class<T> responseType, String mpid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("placeio/{0}", new Object[]{mpid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getLineCreatives(Class<T> responseType, String mpid, String placementtype) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("linecreatives/{0}/{1}", new Object[]{mpid, placementtype}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T deleteadunits(Class<T> responseType, String mplid, String pubid, String aduid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("deleteadunits/{0}/{1}/{2}", new Object[]{mplid, pubid, aduid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public String updateMediaplanLine(String mpid, String mplid, String sdt, String endt, String imp) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("updatemediaplanline/{0}/{1}/{2}/{3}/{4}", new Object[]{mpid, mplid, sdt, endt, imp}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        }

        public <T> T uploadlinecreative(Class<T> responseType,Object o) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path("uploadlinecreative");
            return resource.post(responseType,o);
        }

        public <T> T getMediaPlanPublisherGrp(Class<T> responseType, String mpid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("publisherlist/{0}", new Object[]{mpid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getAgeRange(Class<T> responseType) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path("agerange");
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getAdunitCreatives(Class<T> responseType, String mplid, String placementtype) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("adunitcreatives/{0}/{1}", new Object[]{mplid, placementtype}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getPublisherId(Class<T> responseType, String category_id) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("publisherid/{0}", new Object[]{category_id}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getGroupofPubList(Class<T> responseType, String catid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("newmedia/publisherlist/{0}", new Object[]{catid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getPublisherPieChartData(Class<T> responseType, String mpid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("publisherpiechart/{0}", new Object[]{mpid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getGroupofAdunitsList(Class<T> responseType, String plcid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("newmedia/adunitslist/{0}", new Object[]{plcid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getPublisherContact(Class<T> responseType, String publisher_id) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("publishercontact/{0}", new Object[]{publisher_id}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T createAccount(Class<T> responseType) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path("createaccount");
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getPublisherBarGraphData(Class<T> responseType, String mpid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("publisherbarchart/{0}", new Object[]{mpid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getMediaPlanGrp(Class<T> responseType, String mpname, String advname, String status) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("mediaplanlist/{0}/{1}/{2}", new Object[]{mpname, advname, status}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T DeleteCreativeList(Class<T> responseType, String cid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("deletecreativelist/{0}", new Object[]{cid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T addToLine(Class<T> responseType, String mpid, String pubid, String aduid, String plcid, String parauid, String flag) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("newmedia1/addtoline/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{mpid, pubid, aduid, plcid, parauid, flag}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getGroupofSubAdunitsList(Class<T> responseType, String adunitid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("newmedia/subadunitslist/{0}", new Object[]{adunitid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getAdunitCreativesSizes(Class<T> responseType, String mplid, String placementtype) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("adunitcreativessizes/{0}/{1}", new Object[]{mplid, placementtype}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getSubadunitCreatives(Class<T> responseType, String mplid, String placementtype, String aduid) throws UniformInterfaceException {
            WebResource resource = webResource;
            resource = resource.path(java.text.MessageFormat.format("subadunitcreatives/{0}/{1}/{2}", new Object[]{mplid, placementtype, aduid}));
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public void close() {
            client.destroy();
        }
  
    

        
        
          public static void main(String[] args ) throws  IOException {
	try {
 
          
            RatecardData rc = new RatecardData();
            rc.setTimeperiodid(null);
            rc.setName("singer1");
            rc.setStartDate("2014-10-10");
            rc.setEndDate("2014-12-12");
            rc.setStatus("Inactive");  
            
            SellsideClient client = new SellsideClient(); 
 
            
            //TEST WITH FORM DATA
            
           // ClientResponse response = client.saveTimeperiod(ClientResponse.class,rc); 
            
            
            
            String i ="3";
            Form form = new Form();
            form.add("name", "n2");
            form.add("startDate", "2014-10-10");
            form.add("endDate", "2014-10-10");
            form.add("status", "Inactive");
            //response = client.saveTimeperiod_test1(ClientResponse.class,form);
            
            //response = client.getAllTimePeriods(ClientResponse.class); 
            
            Form f1 = new Form();
            f1.add("Name", "LRL Leader");
            f1.add("Link", "http://www.logicresearchlabs.com");
            f1.add("Size", "720X90");
            f1.add("MediaPlanId", 222);
            f1.add("MediaPlanLineId", 113);
           
            
            
            
            
            ClientResponse response = client.uploadlinecreative(ClientResponse.class,f1); 
            
            //response = client.getRatecardAdunitsData(ClientResponse.class, i);//.saveTimeperiod_test1(ClientResponse.class,form);
                    
            // It will show exception but still inserting.       
                    
//                    service.path("rest").path("todos")
//                .type(MediaType.APPLICATION_FORM_URLENCODED)
//                .post(ClientResponse.class, form);


            
            
            //ClientResponse response = client.saveTimeperiod_test1(ClientResponse.class); 
           // ClientResponse response = client.uploadFile(); 
            
            //ClientResponse response = client.RemoveTimePeriod(ClientResponse.class, "5");
                
            //ClientResponse response = client.updateAdunitsRatecard(ClientResponse.class,"111", "6");    
//		if (response.getStatus() != 200) {
//		   throw new RuntimeException("Failed : HTTP error code : "
//			+ response.getStatus());
//		}
 
		//String output = response.getEntity(String.class);
            String output = response.getEntity(String.class);
 
		System.out.println("Output from Server .... \n");
		System.out.println(output);
            
            
            
             
            
 
	  } catch (Exception e) {
 
		e.printStackTrace();
 
	  }
 
	}

  
        
        
    }
     
    
    



 