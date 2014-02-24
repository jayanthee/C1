/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.service;

//import com.amazonaws.http.HttpResponse;
import com.lrl.c1.dao.MediaPlanCreationDAO;
import com.lrl.c1.dao.MediaPlanDAO;
import com.lrl.c1.dao.MediaPlanInventoryDAO;
import com.lrl.c1.entity.Adunits;
import com.lrl.c1.entity.Adunitsplacements;
import com.lrl.c1.entity.Mediaplan;
import com.lrl.c1.entity.Mediaplanline;
import com.lrl.c1.entity.Placements;
import com.lrl.c1.entity.Publisher;
import com.lrl.c1.util.C1JsonParserService;
import com.lrl.c1.wrapper.AdunitsData;
import com.lrl.c1.wrapper.PublisherData;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
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
@Service("mediaPlanInventoryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MediaPlanInventoryServiceImpl implements MediaPlanInventoryService {

    @Autowired
    private MediaPlanCreationDAO mediaPlanCreateDao;
    @Autowired
    private MediaPlanDAO mediaplanDao;
    @Autowired
    private MediaPlanInventoryDAO mediaplanInvDao;
    @Autowired
    private C1JsonParserService c1jsonparser;
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    SimpleDateFormat sdfhms = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
    SimpleDateFormat sdfhmsaddslash = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    NumberFormat nf = new DecimalFormat("0.00");

    public Integer getPublisherImpressions(Integer mpid, Integer pubid) {
        return mediaPlanCreateDao.getPublisherImpressions(mpid, pubid);
    }

    public List<PublisherData> getGroupofPubList(List<Publisher> list) {
        try {

            if (list == null || list.size() == 0) {
                list = mediaPlanCreateDao.getGroupofPublishersList();
            }

            List<PublisherData> lst = new ArrayList<PublisherData>();
            // Impression and CPM from invtargeting table
            for (Publisher pub : list) {

                Integer impression = this.getPublisherImpressions(0, pub.getId()); // get the impression value
                Integer placementCount = mediaPlanCreateDao.getPublisherPlacementCount(pub.getId());
                Integer adunitsCount = mediaPlanCreateDao.getPublisherAdunitsCount(pub.getId());
                Double CPM = mediaplanDao.getPublisherCPM(0, pub.getId());
                PublisherData publisherData = new PublisherData(pub.getName(), pub.getId(), placementCount, adunitsCount, impression, CPM);
                lst.add(publisherData);
            }

            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PublisherData> getGroupofPlcList(Integer pubid) {

        List<Placements> list = mediaplanInvDao.getPlacementsLines(pubid);
        List<Adunits> adlist = mediaplanInvDao.getPlacementsAdLines(pubid);

        List<PublisherData> lst = new ArrayList<PublisherData>();

        for (Placements placements : list) {
            Integer plcid = placements.getId();
            String name = placements.getName();
            Integer impression = mediaplanInvDao.getPlcImpr(placements.getId());
            Integer adunitsCount = mediaplanInvDao.getPlcAdunitsCount(placements.getId());
            Double CPM = Double.valueOf(placements.getCpm().toString());
            // new PublisherData(,,,0,) // here 0 indicate placements table and 1 indicate Adunit table ie. in json "inventoryPlacements":0/1
            PublisherData publisherData = new PublisherData(name, plcid, adunitsCount, 0, impression, CPM);
            lst.add(publisherData);
        }

        for (Adunits adunits : adlist) {
            Integer aduid = adunits.getId();
            String name = adunits.getName();
            Integer impression = mediaplanInvDao.getAdUnitPlcImpr(aduid);
            Integer adunitsCount = mediaplanInvDao.getAdUnitPlcCount(aduid);
            Double CPM = Double.valueOf(adunits.getCpm().toString());
            PublisherData publisherData = new PublisherData(name, aduid, adunitsCount, 1, impression, CPM);
            lst.add(publisherData);
        }

        return lst;
    }

    public List<PublisherData> getGroupofAdUnitList(Integer plcid, Integer pubid) {
        Integer mplid = 0;
        List<Adunitsplacements> list = mediaplanInvDao.getPlcAdUnitsList(plcid);

        List<Adunits> adlist = mediaplanInvDao.getAduAdUnitsList(pubid); // PARENT ID IS NULL

        List<PublisherData> lst = new ArrayList<PublisherData>();

        for (Adunitsplacements adu : list) {
            Integer adUnitId = adu.getAdUnitId().getId();
            String name = adu.getAdUnitId().getName();
            Integer impression = mediaplanInvDao.getAdUnitImpCount(adUnitId);
            Double CPM = mediaplanInvDao.getAdUnitCPM(adUnitId);

            PublisherData publisherData = new PublisherData(name, adUnitId, null, 0, impression, CPM);

            lst.add(publisherData);
        }

        for (Adunits adl : adlist) {
            Integer adUnitId = adl.getId();
            String name = adl.getName();
            Integer impression = mediaplanInvDao.getAdUnitImpCount(adUnitId);
            Double CPM = mediaplanInvDao.getAdUnitCPM(adUnitId);
            PublisherData publisherData = new PublisherData(name, adUnitId, null, 1, impression, CPM);

            lst.add(publisherData);
        }

        return lst;
    }

    // NOT USED
    public List<AdunitsData> getSubAdUnitList(Integer id, Integer flag) {

        // if flag = 0, its comes from placements table
        // if flag = 1, its comes from adunits table

        Integer mplid = 0;
        List<Adunitsplacements> list = null;
        List<Adunits> adlist = null;

        //List<PublisherData> lst = new ArrayList<PublisherData>();
        List<AdunitsData> lst = new ArrayList<AdunitsData>();

        if (flag == 0) {
            list = mediaplanInvDao.getPlcSubAdUnitsList(id, ""); // placement id , category id
            System.out.println("list size ==" + list.size());

            for (Adunitsplacements adu : list) {
                Integer adUnitId = adu.getAdUnitId().getId();
                String name = adu.getAdUnitId().getName();
                String Size = adu.getAdUnitId().getSizes();
                String Style = adu.getAdUnitId().getStyle();
                Integer impression = adu.getAdUnitId().getImpression();
                Double CPM = Double.valueOf(adu.getAdUnitId().getCpm().toString());// mediaPlanCreateDao.getAdUnitCPM(adUnitId);

                Integer parentId = null;
                Integer publisherId = adu.getAdUnitId().getPublisherId().getId();
                Integer prnId = mediaplanInvDao.getParentId(adUnitId); //### Cast case exp                

                parentId = (prnId > 0) ? prnId : null;

                System.out.println("Placement -> parent id ==" + parentId);

                String positions = adu.getAdUnitId().getPositions();
                Integer placementId = adu.getId();

                AdunitsData Data = new AdunitsData(adUnitId, name, Size, Style, CPM, positions, publisherId, adUnitId, id, parentId, impression);
                //AdunitsData(Integer id, String name, String sizes, String style, BigDecimal cpm, String positions, Integer publiserid, Integer adunitid, Integer placementid, Integer parentaddunitid, Integer impression)
                lst.add(Data);
            }

        } else {
            adlist = mediaplanInvDao.getAduSubAdUnitsList(id, "");// adunit id
            for (Adunits au : adlist) {
                Integer adUnitId = au.getId();
                String name = au.getName();
                Integer impression = 15000; //
                Double CPM = Double.valueOf(au.getCpm().toString());// mediaPlanCreateDao.getAdUnitCPM(adUnitId);
                String Style = au.getStyle();
                String Size = au.getSizes();

                Integer publisherId = au.getPublisherId().getId();
                Integer parentId = null;
                Integer prnId = mediaplanInvDao.getParentId(adUnitId); //### Cast case exp                
                parentId = (prnId > 0) ? prnId : null;
                System.out.println("Adunit -> parent id ==" + parentId);
                String positions = au.getPositions();

                AdunitsData Data = new AdunitsData(adUnitId, name, Size, Style, CPM, positions, publisherId, adUnitId, 0, parentId, impression);

                lst.add(Data);
            }
        }

        return lst;
    }

    public Integer AddToLine(Integer mpid, Integer pubid, Integer adunitid, Integer plcid, Integer parauid, Integer flag) {
        try {
            Integer value = mediaplanInvDao.AddToLine(mpid, pubid, adunitid, plcid, parauid, flag);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // CIS service place io
    public boolean invokePlaceIO(Integer mpid) {
        try {
            // API OR-1
            //"http://50.112.157.222/CIS/orders/225689416?networkId=269233203";
            
            String orderId = this.callOR1Api(mpid);  // create order            
            boolean c = this.callOL1Api(mpid, orderId); //             
            //boolean c =  this.callOL1_hardcode(mpid, "0"); // 
            
            if (c && orderId != "0") {
                //if ( orderId !="0" ) {
                // if (c ) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(MediaPlanInventoryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        }
    }

    public String callOR1Api(Integer mpid) {
        String urlstr = "";
        Mediaplan mp = mediaplanInvDao.getMediaplan(mpid);
        return this.accessPUTmethod(mp);
    }

    public boolean callOR1Api_(Integer mpid) { // ###

        // API OR-1    
        //"http://50.112.157.222/CIS/orders/225689416?networkId=57383456"; // old 
        //"http://50.112.157.222/CIS/orders/225689416?networkId=269233203";

        //Mediaplan mp = mediaplanInvDao.getMediaplan(mpid);
        String advertiserId = "51235043";//"41008096";//"51235043" ;// "41008096";
        String publisherId = "95295803";//"78815656";//"269233203"; //"78815656";
        String orderName = "ORDER5";//mp.getName();
        String startDate = "13/08/2013 01:42:00"; //sdf.format(mp.getStartDate());
        String endDate = "17/08/2013 06:59:00"; //sdf.format(mp.getEndDate());
        String str = "http://50.112.157.222/CIS/";
        String netID = "?networkId=269233203";
        String args = "http://50.112.157.222/CIS/orders?advertiserId=" + advertiserId + "&orderName=" + orderName + "&publisherId=" + publisherId + "&startDate=" + startDate + "&endDate=" + endDate + "&networkId=269233203";

        String URL = args.replaceAll(" ", "%20");

        // InputStream is = new URL(url).openStream();

//        String URL="";
//        try {
//            URL = URLEncoder.encode(args, "ISO-8859-1"); // "ISO-8859-1" OR "UTF-8"
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(MediaPlanInventoryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        

        try {
            JSONObject json1 = c1jsonparser.readJsonFromUrl(URL);
            String IntegerationId = json1.get("orderId").toString();

            System.out.println("CREATE ORDER ID =" + IntegerationId);

            String status = json1.get("status").toString();
            // mediaplanInvDao.updateMediaplan(mpid, IntegerationId, status);// ###
        } catch (IOException ex) {
            Logger.getLogger(MediaPlanInventoryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(MediaPlanInventoryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

    public boolean callOL1Api_(Integer mpid) {
        //API - OL1 //http://50.112.157.222/CIS/orderLines/61347616?networkId=57383456

        ObjectMapper mapper = new ObjectMapper();



        List<Mediaplanline> mpl = mediaplanInvDao.getMediaplanlineList(mpid);

        List s = new ArrayList<String>();
        List s1 = new ArrayList<String>();
        List targetingPlcArr = new ArrayList<String>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("orderId", "207192203");
        map.put("startDate", 29);
        map.put("endDate", 29);
        map.put("impressions", 29);
        map.put("sizes", 29);
        map.put("targetedAdUnits", 29);
        map.put("targetedPlacements", 29);

        List<Object> list = new ArrayList<Object>();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        map.put("messages", list);


        for (Mediaplanline mpldata : mpl) {

            List<Adunits> adlist = mediaplanInvDao.getAdunitsList(mpldata.getId());

            for (Adunits adl : adlist) {
                List<String> sizesarr = new ArrayList<String>();
                List<String> targarr = new ArrayList<String>();
                sizesarr.add(adl.getSizes());
                s.add(sizesarr);
                targarr.add(adl.getIntegrationId());
                s1.add(targarr);
            }
            // old code
            //List<Adunits> plclist = mediaplanInvDao.getPlcTarAdunitsList(mpldata.getId()); // old code

            List<Placements> plclist = mediaplanInvDao.getPlcTarAdunitsList(mpldata.getId());

            for (Placements p : plclist) {
                List<String> plctar = new ArrayList<String>();
                plctar.add(p.getIntegrationId());
                targetingPlcArr.add(plctar);
            }




//?networkId=269233203
            String orderId = "207192203";//"225689416";  //225677656   // ###              
            // String orderId = mpldata.getId().toString();
            String startDt = sdfhms.format(mpldata.getStartDate()); //.toString();
            String endDt = sdfhms.format(mpldata.getEndDate()); //.toString();
            String impression = mediaplanInvDao.getMediaplanlineImpCount(mpldata.getId()).toString();
            String sizes = s.toString();
            String targettedAdUnits = s1.toString();
            String tgPlacement = targetingPlcArr.toString();

            System.out.println("startDt =" + startDt);
            System.out.println("endDt =" + endDt);
            System.out.println("impression =" + impression);
            System.out.println("sizes=" + sizes);
            System.out.println("tar=" + targettedAdUnits);
            System.out.println("plc=" + tgPlacement);

            String args = "http://50.112.157.222/CIS/orderLines?orderId=" + orderId + "&startDate=" + startDt + "&endDate=" + endDt + "&impressions=" + impression + "&sizes=" + sizes + "&targetedAdUnits=" + targettedAdUnits + "&targetedPlacements=" + tgPlacement + "&networkId=57383456";
            String URL = args.replaceAll(" ", "%20");
            System.out.println("URL ==>" + URL);
            boolean flg = true;//this.assembleJasonData(URL, mpldata.getId());
            return flg;
        }
        return false;
    }

    public boolean callOL1Api_old(Integer mpid, String OrderId) {
        //API - OL1 //http://50.112.157.222/CIS/orderLines/61347616?networkId=57383456
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonParam = "";
            String orderId = OrderId;
            List<Mediaplanline> mpl = mediaplanInvDao.getMediaplanlineList(mpid);

            List s = new ArrayList<String>();
            List s1 = new ArrayList<String>();
            List targetingPlcArr = new ArrayList<String>();

            DefaultHttpClient httpClient = new DefaultHttpClient();

            for (Mediaplanline mpldata : mpl) {
                org.json.simple.JSONObject obj = new org.json.simple.JSONObject();

                obj.put("orderId", orderId); // ### 
                obj.put("startDate", sdfhmsaddslash.format(mpldata.getStartDate()));
                obj.put("endDate", sdfhmsaddslash.format(mpldata.getEndDate()));
                obj.put("impressions", mediaplanInvDao.getMediaplanlineImpCount(mpldata.getId()).toString());

                org.json.simple.JSONArray sizesObj = new org.json.simple.JSONArray();
                org.json.simple.JSONArray tarAdUnitObj = new org.json.simple.JSONArray();
                org.json.simple.JSONArray tarPlacementObj = new org.json.simple.JSONArray();

                List<Adunits> adlist = mediaplanInvDao.getAdunitsList(mpldata.getId());
                List<String> sizesarr = new ArrayList<String>();
                List<String> targarr = new ArrayList<String>();

                for (Adunits adl : adlist) {
                    sizesarr.add(adl.getSizes());
                    s.add(sizesarr);
                    sizesObj.add(this.widthHeightJsonConvert(adl.getSizes()));
                    targarr.add(adl.getIntegrationId());
                    String adu = (adl.getIntegrationId().equals("")) ? "0" : adl.getIntegrationId();
                    tarAdUnitObj.add(adu);
                    s1.add(targarr);
                }
                obj.put("sizes", sizesObj);
                obj.put("adunits", tarAdUnitObj);

                List<Placements> plclist = mediaplanInvDao.getPlcTarAdunitsList(mpldata.getId());
                List<String> plctar = new ArrayList<String>();
                // consider later 
//                for (Placements p : plclist) {
//                    plctar.add(p.getIntegrationId());
//                    String plc = (p.getIntegrationId().equals("")) ? "0" :p.getIntegrationId();
//                    tarPlacementObj.add(p.getIntegrationId());
//                    targetingPlcArr.add(plctar);
//                }

                tarPlacementObj.add("1120523");
                obj.put("placements", tarPlacementObj);

                //convert map to JSON string
                jsonParam = mapper.writeValueAsString(obj).replace("\\", "").replace("\"{", "{").replace("}\"", "}");
                System.out.println("JSON OBJECT==" + jsonParam);

                String urlStr = "http://50.112.157.222/CIS/orderLines?networkId=269233203";

                URL url = new URL(urlStr);
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                httpCon.setDoOutput(true);
                httpCon.setRequestMethod("PUT");
                httpCon.setRequestProperty("Content-Type", "application/json");
                httpCon.setRequestProperty("charset", "utf-8");
                //httpCon.setRequestProperty("Content-Length", "" + Integer.toString(param1.getBytes().length));
                OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
                out.write(jsonParam);
                out.flush();
                out.close();

                BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream(), Charset.forName("UTF-8")));
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    result.append(line);
                }
                System.out.println("result===" + result.toString());
                in.close();




//                String jsonText = this.readAll(in);
//                //this.jsonReader(in);
//                System.out.println("outter");
//                System.out.println("stage1 =" + jsonText);
//                JSONArray jsonObj = new JSONArray(jsonText);
//                System.out.println("json ===" + jsonObj);
//                in.close();

                //you will need api key here!!
//
//                System.out.println("JSON REQUEST ==" + obj.toJSONString());
//
//                //  return false;
//
//                HttpPut request = new HttpPut("http://50.112.157.222/CIS/orderLines?networkId=269233203");
//                StringEntity params = new StringEntity(obj.toJSONString());
//
//                params.setContentType("application/json");//text/plain;charset=UTF-8
//               // params.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8"));
//                //request.setHeader("application/json", "charset=UTF-8");
//                params.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
//                
//               // request.addHeader("content-type", "application/x-www-form-urlencoded");
//                //request.addHeader("application/json", "charset=UTF-8");
//                request.setHeader("Accept", "application/json");
//                request.setHeader("Content-Type", "application/json");
//                request.setEntity(params);
//                org.apache.http.HttpResponse response = httpClient.execute(request);
//                System.out.println("");
//
//                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//                StringBuilder result = new StringBuilder();
//                String line;
//                while ((line = rd.readLine()) != null) {
//                    result.append(line);
//                }
//                System.out.println("result===" + result.toString());
//                rd.close();
//                System.out.println("status:" + response.getStatusLine());
//
//
//
//                boolean flg = true;//this.assembleJasonData(jsonObj);
//
//                //boolean flg = true;//this.assembleJasonData(URL, mpldata.getId());
//                // return flg;
            }
            return true;
        } catch (Exception ex) {
            System.out.println("Error from callOL1Api() Imp Ser");
            return false;
        }
    }

    public boolean callOL1Api(Integer mpid, String OrderId) {
        //API - OL1 //http://50.112.157.222/CIS/orderLines/61347616?networkId=57383456
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonParam = "";
            String orderId = OrderId;
            List<Mediaplanline> mpl = mediaplanInvDao.getMediaplanlineList(mpid);

            List s = new ArrayList<String>();
            List s1 = new ArrayList<String>();
            List targetingPlcArr = new ArrayList<String>();

            DefaultHttpClient httpClient = new DefaultHttpClient();

            for (Mediaplanline mpldata : mpl) {
                org.json.simple.JSONObject obj = new org.json.simple.JSONObject();

                obj.put("orderId", orderId); // ### 
                obj.put("startDate", sdfhmsaddslash.format(mpldata.getStartDate()));
                obj.put("endDate", sdfhmsaddslash.format(mpldata.getEndDate()));
                obj.put("impressions", mediaplanInvDao.getMediaplanlineImpCount(mpldata.getId()).toString());
                //obj.put("name", mpldata.getName());
                // obj.put("costType","CPC"); // 
                //obj.put("currency", mpldata.getCurrency());
                // obj.put("cost",1000000); // 
                org.json.simple.JSONArray sizesObj = new org.json.simple.JSONArray();
                org.json.simple.JSONArray tarAdUnitObj = new org.json.simple.JSONArray();
                org.json.simple.JSONArray tarPlacementObj = new org.json.simple.JSONArray();

                List<Adunits> adlist = mediaplanInvDao.getAdunitsList(mpldata.getId());
                List<String> sizesarr = new ArrayList<String>();
                List<String> targarr = new ArrayList<String>();

                for (Adunits adl : adlist) {
                    sizesarr.add(adl.getSizes());
                    s.add(sizesarr);
                    sizesObj.add(this.widthHeightJsonConvert(adl.getSizes()));
                    targarr.add(adl.getIntegrationId());
                    String adu = (adl.getIntegrationId().equals("")) ? "0" : adl.getIntegrationId();
                    tarAdUnitObj.add(adu);
                    s1.add(targarr);
                }
                obj.put("sizes", sizesObj);
                obj.put("adunits", tarAdUnitObj);

                List<Placements> plclist = mediaplanInvDao.getPlcTarAdunitsList(mpldata.getId());
                List<String> plctar = new ArrayList<String>();
                // consider later 
//                for (Placements p : plclist) {
//                    plctar.add(p.getIntegrationId());
//                    String plc = (p.getIntegrationId().equals("")) ? "0" :p.getIntegrationId();
//                    tarPlacementObj.add(p.getIntegrationId());
//                    targetingPlcArr.add(plctar);
//                }

                tarPlacementObj.add("1120523");
                obj.put("placements", tarPlacementObj);

                //convert map to JSON string
                jsonParam = mapper.writeValueAsString(obj).replace("\\", "").replace("\"{", "{").replace("}\"", "}");

                //System.out.println("GIVEN JSON OBJECT==" + jsonParam);

                String urlStr = "http://50.112.157.222/CIS/orderLines?networkId=269233203";

                URL url = new URL(urlStr);
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                httpCon.setDoOutput(true);
                httpCon.setRequestMethod("PUT");
                httpCon.setRequestProperty("Content-Type", "application/json");
                httpCon.setRequestProperty("charset", "utf-8");
                //httpCon.setRequestProperty("Content-Length", "" + Integer.toString(param1.getBytes().length));
                OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
                out.write(jsonParam);
                out.flush();
                out.close();

                BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream(), Charset.forName("UTF-8")));
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    result.append(line);
                }
                in.close();

                //System.out.println("result===" + result.toString());
                String replacedData = "[" + result.toString() + "]";
                //System.out.println("final REP DATA ==" + replacedData); // 

                JSONArray json = new JSONArray(replacedData);
                //System.out.println("Converting json array =" + json);
                this.assembleJasonData(json, mpldata.getId());
            }
            return true;
        } catch (Exception ex) {
            System.out.println("Error from callOL1Api() Imp Ser");
            ex.printStackTrace();
            return false;
        }
    }

    public boolean callOL1_hardcode(Integer mpid, String OrderId) {
        //API - OL1 //http://50.112.157.222/CIS/orderLines/61347616?networkId=57383456
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonParam = "";
            String orderId = OrderId;
            List<Mediaplanline> mpl = mediaplanInvDao.getMediaplanlineList(mpid);

            List s = new ArrayList<String>();
            List s1 = new ArrayList<String>();
            List targetingPlcArr = new ArrayList<String>();

            DefaultHttpClient httpClient = new DefaultHttpClient();

            //  for (Mediaplanline mpldata : mpl) {
            org.json.simple.JSONObject obj = new org.json.simple.JSONObject();

            obj.put("orderId", "207263483"); // ### 
            obj.put("startDate", "12/09/2014 12:12:12");
            obj.put("endDate", "12/01/2015 11:11:11");
            obj.put("impressions", "350000000");

            org.json.simple.JSONArray sizesObj = new org.json.simple.JSONArray();
            org.json.simple.JSONArray tarAdUnitObj = new org.json.simple.JSONArray();
            org.json.simple.JSONArray tarPlacementObj = new org.json.simple.JSONArray();


            List<String> sizesarr = new ArrayList<String>();
            List<String> targarr = new ArrayList<String>();

            sizesObj.add(this.widthHeightJsonConvert("728x90"));
            sizesObj.add(this.widthHeightJsonConvert("970x90"));
            tarAdUnitObj.add("268233563");
            tarAdUnitObj.add("268364003");
            obj.put("sizes", sizesObj);
            obj.put("adunits", tarAdUnitObj);

            tarPlacementObj.add("1120523");
            obj.put("placements", tarPlacementObj);

            //convert map to JSON string
            jsonParam = mapper.writeValueAsString(obj).replace("\\", "").replace("\"{", "{").replace("}\"", "}");
            System.out.println("JSON OBJECT==" + jsonParam);

            String urlStr = "http://50.112.157.222/CIS/orderLines?networkId=269233203";

            URL url = new URL(urlStr);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
            httpCon.setRequestProperty("Content-Type", "application/json");
            httpCon.setRequestProperty("charset", "utf-8");
            //httpCon.setRequestProperty("Content-Length", "" + Integer.toString(param1.getBytes().length));
            OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
            out.write(jsonParam);
            out.flush();
            out.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream(), Charset.forName("UTF-8")));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
                        
            String replacedData = "[" + result.toString() + "]";

            System.out.println("final REP DATA ==" + replacedData); // first and last char only 

            JSONArray json = new JSONArray(replacedData);
            System.out.println("Converting json array =" + json);
            this.assembleJasonData(json, 0);

            in.close();

            return true;
        } catch (Exception ex) {
            System.out.println("Error from callOL1Api() Imp Ser");
            return false;
        }
    }

    public String widthHeightJsonConvert(String wxh) {

        if (wxh.equals(null) || wxh == "0" || wxh == "") {
            return "";
        }
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> failmap = new HashMap<String, Object>();
        String defaultJason = "";
        String jsonObj = "";
        try {
            String spliter = wxh.toLowerCase();
            map.put("width", Integer.valueOf(spliter.split("x")[0]));
            map.put("height", Integer.valueOf(spliter.split("x")[1]));
            jsonObj = mapper.writeValueAsString(map);
            return jsonObj;
        } catch (Exception e) {
            System.out.println("Error From widthHeightJsonConert()");
            e.printStackTrace();
            return defaultJason;
        }
    }

    public boolean assembleJasonData(JSONArray jsonArr, Integer mplid) {
        System.out.println("stage 1");
        System.out.println("inner array =" + jsonArr);
        boolean f = false;
        try {
            System.out.println("len =" + jsonArr.length() + " get(0) =" + jsonArr.get(0));
            for (int i = 0; i < jsonArr.length(); i++) {
                JSONObject jsonObject = jsonArr.getJSONObject(i);
                String integid = jsonObject.getString("orderLineId");
                System.out.println("ORDER LINE ID=" + integid);
                // this is  wrong data and approach , clarify MRT, laterly  // ###
                f = mediaplanInvDao.insertMediaplanlineIntegrationId(mplid, integid);
            }
            return true;
        } catch (Exception ex) {
            System.out.println("Error from assembleJasonData() in Serv Impl");
            ex.printStackTrace();
            return false;
        }
        //return f;
    }

//    public boolean jsonReader(Reader r) {
//        JSONParser parser = new JSONParser();
//        
//        System.out.println("inner = ");
//
//        try {
//
//            Object obj = parser.parse(r);
//            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) obj;            
//          
//            String orderLineId = (String) jsonObject.get("orderLineId");
//            System.out.println("orderLineId="+orderLineId);
//            
//            String exceptPercent = (String) jsonObject.get("expectedDeliveryPercentage");
//            System.out.println("exceptPercent="+exceptPercent);
//           
//            String actualPercent = (String) jsonObject.get("actualDeliveryPercentage");
//            System.out.println("actualPercent="+actualPercent);
//            String deliverUnit = (String) jsonObject.get("deliveredUnits");
//            System.out.println("deliverUnit"+deliverUnit);
//            String orderId = (String) jsonObject.get("orderId");
//            System.out.println("orderId="+orderId);
//            
//            String status = (String) jsonObject.get("status");
//            System.out.println("status"+status);
//            
//            String stdt = (String) jsonObject.get("startDate");
//            System.out.println("stdt"+stdt);
//
////            long age = (Long) jsonObject.get("age");
////            System.out.println(age);
////
////            // loop array
////            JSONArray msg = (JSONArray) jsonObject.get("messages");
////            Iterator<String> iterator = msg.iterator();
////            while (iterator.hasNext()) {
////                System.out.println(iterator.next());
////            }
//
//        } catch (Exception  e) {
//            System.out.println("Error from jsonReader() in impl ser ");
//            e.printStackTrace();
//        } 
//        return true;
//    }
//    
    public boolean assembleJasonData_(String URL, Integer mplid) {
        boolean f = false;
        try {
            JSONArray jsonArr = c1jsonparser.readJsonArrayFromUrl(URL);
            //System.out.println("len =" + jsonArr.length() + " get(0) =" + jsonArr.get(0));
            for (int i = 0; i < jsonArr.length(); i++) {
                JSONObject jsonObject = jsonArr.getJSONObject(i);
                String integid = jsonObject.getString("orderLineId");
                // this is  wrong data and approach , clarify MRT, laterly  // ###
                f = mediaplanInvDao.insertMediaplanlineIntegrationId(mplid, integid);
            }
            return f;
        } catch (IOException ex) {
            Logger.getLogger(MediaPlanInventoryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(MediaPlanInventoryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

    // DONT DELETE ,WE REFER LATER
    public boolean callOL1Api_laterly_refer(Integer mpid) {
        //API - OL1 //http://50.112.157.222/CIS/orderLines/61347616?networkId=57383456

        List<Mediaplanline> mpl = mediaplanInvDao.getMediaplanlineList(mpid);

        List s = new ArrayList<String>();
        List s1 = new ArrayList<String>();
        List targetingPlcArr = new ArrayList<String>();

        for (Mediaplanline mpldata : mpl) {
            List<Adunits> adlist = mediaplanInvDao.getAdunitsList(mpldata.getId());
            for (Adunits adl : adlist) {
                List<String> sizesarr = new ArrayList<String>();
                List<String> targarr = new ArrayList<String>();
                sizesarr.add(adl.getSizes());
                s.add(sizesarr);
                targarr.add(adl.getIntegrationId());
                s1.add(targarr);
            }
            // old code
            //List<Adunits> plclist = mediaplanInvDao.getPlcTarAdunitsList(mpldata.getId()); // old code

            List<Placements> plclist = mediaplanInvDao.getPlcTarAdunitsList(mpldata.getId());

            for (Placements p : plclist) {
                List<String> plctar = new ArrayList<String>();
                plctar.add(p.getIntegrationId());
                targetingPlcArr.add(plctar);
            }

            String orderId = "225689416";  //225677656               
            // String orderId = mpldata.getId().toString();
            String startDt = sdfhms.format(mpldata.getStartDate()); //.toString();
            String endDt = sdfhms.format(mpldata.getEndDate()); //.toString();
            String impression = mediaplanInvDao.getMediaplanlineImpCount(mpldata.getId()).toString();
            String sizes = s.toString();
            String targettedAdUnits = s1.toString();
            String tgPlacement = targetingPlcArr.toString();

            System.out.println("=========== OL-1 ==========");
//            System.out.println("orderId" + orderId);
//            System.out.println("startDt" + startDt);
//            System.out.println("endDt " + endDt);
//            System.out.println("impres " + impression);
//            System.out.println("Sizes " + sizes);
//            System.out.println("targettedAdUnits " + targettedAdUnits);
//            System.out.println("tgPlacement" + tgPlacement);


            String args = "http://50.112.157.222/CIS/orderLines?orderId=" + orderId + "&startDate=" + startDt + "&endDate=" + endDt + "&impressions=" + impression + "&sizes=" + sizes + "&targetedAdUnits=" + targettedAdUnits + "&targetedPlacements=" + tgPlacement + "&networkId=57383456";
            String URL = args.replaceAll(" ", "%20");
            System.out.println("URL ==>" + URL);

            try {
                JSONArray jsonArr = c1jsonparser.readJsonArrayFromUrl(URL);
                System.out.println("len =" + jsonArr.length() + " get(0) =" + jsonArr.get(0));

                for (int i = 0; i < jsonArr.length(); i++) {
                    JSONObject jsonObject = jsonArr.getJSONObject(i);
                    System.out.println("orderlineid == " + jsonObject.getString("orderLineId"));
                    System.out.println("orderid == " + jsonObject.getString("orderId"));
                    System.out.println("start date == " + jsonObject.getString("startDate"));
                    System.out.println("end date == " + jsonObject.getString("endDate"));
                    System.out.println("expected delivery percentage == " + jsonObject.getDouble("expectedDeliveryPercentage"));
                    System.out.println("actual delivery percentage ==" + jsonObject.getDouble("actualDeliveryPercentage"));
                    System.out.println("delivered units ==" + jsonObject.get("deliveredUnits"));
                    System.out.println("impressions ==" + jsonObject.get("impressions"));


                    if (jsonObject.opt("sizes").toString() != "null") {
                        String str = jsonObject.opt("sizes").toString();
                        JSONArray injson = new JSONArray(str);
                        System.out.println("lengh ===" + injson.length() + " get(0) ==" + injson.get(0));

                        for (int j = 0; j < injson.length(); j++) {
                            JSONObject jsonObj = injson.getJSONObject(j);
                            System.out.println("width =" + jsonObj.get("width"));
                            System.out.println("height =" + jsonObj.get("height"));
                        }
                    }

                    if (jsonObject.opt("targettedAdunits").toString() != "null") {
                        String str = jsonObject.opt("targettedAdunitds").toString();
                        JSONArray injson = new JSONArray(str);
                        System.out.println("lengh ===" + injson.length() + " get(0) ==" + injson.get(0));

//                        for (int j = 0; j < injson.length(); j++) {
//                            JSONObject jsonObj = injson.getJSONObject(j);
//                            System.out.println("width =" + jsonObj.get("width"));
//                            System.out.println("height =" + jsonObj.get("height"));
//                        }
                    }

                    if (jsonObject.opt("targetedPlacements").toString() != "null") {
                        String str = jsonObject.opt("targettedPlacements").toString();
                        JSONArray injson = new JSONArray(str);
                        System.out.println("lengh ===" + injson.length() + " get(0) ==" + injson.get(0));

//                        for (int j = 0; j < injson.length(); j++) {
//                            JSONObject jsonObj = injson.getJSONObject(j);
//                            System.out.println("width =" + jsonObj.get("width"));
//                            System.out.println("height =" + jsonObj.get("height"));
//                        }
                    }

                }

            } catch (IOException ex) {
                Logger.getLogger(MediaPlanInventoryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(MediaPlanInventoryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

//    public boolean syncAdUnits() {
//        boolean syncFlag = false;
//        boolean syncupd = false;
//        try {
//
//            String URL = "http://50.112.157.222/CIS/adunits?networkId=57383456";
//            JSONArray json = c1jsonparser.readJsonArrayFromUrl(URL);
//            // Map<inventoryid, parentid>
//            Map<String,String> map = new HashMap<String,String>();
//
//            for (int i = 0; i < json.length(); i++) {
//                AdunitsData wrapper = new AdunitsData();
//
//                JSONObject jsonObject = json.getJSONObject(i);
//                wrapper.setId(Integer.valueOf(jsonObject.getString("inventoryId").toString())); // in response adunits id                
//                wrapper.setName(jsonObject.getString("name").toString());
//                
//                if (jsonObject.opt("parentId").toString() != "null") {
//                    wrapper.setParentaddunitid(Integer.valueOf(jsonObject.getString("parentId").toString()));
//                    map.put(jsonObject.getString("inventoryId").toString(),jsonObject.getString("parentId").toString());
//                } else {                    
//                    wrapper.setParentaddunitid(0);
//                }
//                wrapper.setPositions(jsonObject.getString("targetWindow").toString());
//
//                if (jsonObject.opt("sizes").toString() != "null") {
//                    String str = jsonObject.opt("sizes").toString();
//                    JSONArray injson = new JSONArray(str);
//                    String sizes = null;
//                    for (int j = 0; j < injson.length(); j++) {
//                        JSONObject jsonObj = injson.getJSONObject(j);
//                        sizes = jsonObj.get("width").toString() + "x" + jsonObj.get("height").toString();
//                    }
//                    wrapper.setSizes(sizes);
//                }
//                syncFlag = mediaplanInvDao.syncInsertAdunits(wrapper);
//            }
//            syncupd = mediaplanInvDao.syncInsertAdunitsUpdatePrentId(map);
//
//        } catch (IOException ex) {
//            Logger.getLogger(MediaPlanInventoryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (JSONException ex) {
//            Logger.getLogger(MediaPlanInventoryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return syncFlag;
//    }
//
//    public boolean syncPlacements() {
//        boolean syncFlag = false;
//        boolean aduflag = false;
//        try {
//            String URL = "http://50.112.157.222/CIS/placements?networkId=57383456";
//            JSONArray json = c1jsonparser.readJsonArrayFromUrl(URL);
//
//            AdunitsData wrapper = new AdunitsData();
//            List<AdunitsData> listwr = new ArrayList<AdunitsData>();
//
//            for (int i = 0; i < json.length(); i++) {
//                JSONObject jsonObject = json.getJSONObject(i);
//                wrapper.setId(Integer.valueOf(jsonObject.getString("inventoryId").toString()));
//                wrapper.setName(jsonObject.getString("name").toString());
//
//                if (jsonObject.opt("targetedAdunitIds").toString() != "null") {
//                    String str = jsonObject.opt("targetedAdunitIds").toString();
//                    JSONArray injson = new JSONArray(str);
//                    for (int j = 0; j < injson.length(); j++) {
//                        AdunitsData aduplcwr = new AdunitsData();
//                        aduplcwr.setId(Integer.valueOf(jsonObject.getString("inventoryId").toString()));
//                        aduplcwr.setAdunitid(Integer.valueOf(injson.get(j).toString()));
//                        listwr.add(aduplcwr);
//                        //aduflag = mediaplanInvDao.syncAdunitPlacements(aduplcwr);                    
//                    }
//                }
//                syncFlag = mediaplanInvDao.syncInsertPlacements(wrapper);
//            }
//
//            for (AdunitsData ad : listwr) {
//                aduflag = mediaplanInvDao.syncAdunitPlacements(ad);
//            }
//            
//            if(syncFlag && aduflag ){            
//                return syncFlag;
//            }else {
//                return false;
//            }
//            
//        } catch (IOException ex) {
//            Logger.getLogger(MediaPlanInventoryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (JSONException ex) {
//            Logger.getLogger(MediaPlanInventoryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return syncFlag;
//    }
    // SHARAN 
    public List<PublisherData> getListofParentFromPlacementsAndAdunits(Integer publisherId, String plcmntTypeId) {
        try {

            List<Placements> list = mediaplanInvDao.getPlacementsLines(publisherId);
            List<Adunits> adlist = mediaplanInvDao.getPlacementsAdLines(publisherId);

            List<PublisherData> lst = new ArrayList<PublisherData>();

            Integer impression = 0;
            Integer impression2 = 0;
            Double CPM = 0.0;
            int i = 1;
            Double CPM1 = 0.0;
            for (Placements placements : list) {
                System.out.println("placement id =" + placements.getId());
                Integer plcid = placements.getId();
                String name = placements.getName();
                impression += mediaplanInvDao.getPlcImpr(placements.getId());
                System.out.println("placemnets impression =" + impression);
                Integer adunitsCount = mediaplanInvDao.getPacementAdunitsCount(publisherId, plcmntTypeId); // old getPlcAdunitsCount(placements.getId());
                CPM += Double.valueOf(placements.getCpm().toString());

                List listofValues = null;//mediaplanInvDao.getListofValuesInPlacement(plcmntTypeId, plcid);
                // new PublisherData(,,,0,) // here 0 indicate placements table and 1 indicate Adunit table ie. in json "inventoryPlacements":0/1
                // PublisherData publisherData = new PublisherData(name, impression, CPM, adunitId, placmentId, parentId, listofValues);
                PublisherData publisherData = new PublisherData(name, impression, CPM, 0, plcid, 0, listofValues);
                lst.add(publisherData);
                i++;
            }

            for (Adunits adunits : adlist) {
                Integer aduid = adunits.getId();
                String name = adunits.getName();
                impression2 += mediaplanInvDao.getAdUnitPlcImpr(aduid);
                Integer adunitsCount = mediaplanInvDao.getAdUnitPlcCount(aduid);
                System.out.println("adunits cpm =" + adunits.getCpm());

                CPM1 += Double.valueOf(adunits.getCpm().toString());
                List listofValues = null;//mediaplanInvDao.getListofValues(plcmntTypeId);
                PublisherData publisherData = new PublisherData(name, impression2, CPM1, aduid, 0, 0, listofValues);
                lst.add(publisherData);
            }
            return lst;

        } catch (Exception e) {
            System.out.println("Error from getListofParentFromPlacementsAndAdunits(Integer publisherId, plcmntTypeId) fun. serviceIml ");
            e.printStackTrace();
            return null;

        }

    }

    public List<AdunitsData> getChildFromPlacementsAndAdunits(Integer placementId, Integer adUnitId, String plcmntTypeId) {
        try {
            List<AdunitsData> finalList = new ArrayList<AdunitsData>();
            List<AdunitsData> plc = this.getChildFromPlacements(placementId, plcmntTypeId);
            List<AdunitsData> adu = this.getChildFromAdunits(adUnitId, plcmntTypeId);
            finalList.addAll(plc);
            finalList.addAll(adu);
            return finalList;
        } catch (Exception e) {
            System.out.println("Error from getChildFromPlacementsAndAdunits(Integer placementId, Integer auUnitId, String plcmntTypeId)  DAO Impl ");
            return null;
        }

    }

    public List<AdunitsData> getChildFromPlacements(Integer placementId, String plcmntTypeId) {
        try {
            List<AdunitsData> lst = new ArrayList<AdunitsData>();
            List<Adunitsplacements> list = null;

            list = mediaplanInvDao.getPlcSubAdUnitsList(placementId, plcmntTypeId);
            System.out.println("list size ==" + list.size());

            for (Adunitsplacements adu : list) {
                Integer adUnitId = adu.getAdUnitId().getId();
                String name = adu.getAdUnitId().getName();
                String Size = adu.getAdUnitId().getSizes();
                String Style = adu.getAdUnitId().getStyle();
                Integer impression = adu.getAdUnitId().getImpression();
                Double CPM = Double.valueOf(adu.getAdUnitId().getCpm().toString()); //mediaplanInvDao.getAdUnitAvgCPM(adUnitId);
                Integer publisherId = adu.getAdUnitId().getPublisherId().getId();

                //this below process getting a pk value from adunits , because this return adunits entity we dont want this, we want pk value only, for the purpose of insert the  invtargteting tables
                Integer parentId = null;
                Integer prnId = mediaplanInvDao.getParentId(adUnitId); //### Cast case exp                
                parentId = (prnId > 0) ? prnId : null;
                System.out.println("Placement -> parent id ==" + parentId);

                String positions = adu.getAdUnitId().getPositions();
                Integer plcId = adu.getId();

                AdunitsData Data = new AdunitsData(adUnitId, name, Size, Style, CPM, positions, publisherId, adUnitId, placementId, parentId, impression);
                //AdunitsData(Integer id, String name, String sizes, String style, BigDecimal cpm, String positions, Integer publiserid, Integer adunitid, Integer placementid, Integer parentaddunitid)
                lst.add(Data);
            }
            return lst;
        } catch (Exception e) {
            System.out.println("Error from getChildFromPlacements(Integer placementId) in DAO Impl ");
            e.printStackTrace();
            return null;
        }
    }

    public List<AdunitsData> getChildFromAdunits(Integer adunitId, String plcmntTypeId) {
        try {
            List<AdunitsData> lst = new ArrayList<AdunitsData>();
            List<Adunits> adlist = null;

            adlist = mediaplanInvDao.getAduSubAdUnitsList(adunitId, plcmntTypeId);
            System.out.println("list size ==" + adlist.size()+"==="+adunitId);

            for (Adunits au : adlist) {
                Integer adUnitId = au.getId();
                String name = au.getName();
                Integer impression = au.getImpression();
                Double CPM = Double.valueOf(au.getCpm().toString());// mediaPlanCreateDao.getAdUnitCPM(adUnitId);
                String Style = au.getStyle();
                String Size = au.getSizes();
                Integer publisherId = au.getPublisherId().getId();
                String positions = au.getPositions();

                //this below process getting a pk value from adunits , because this return adunit's entity we dont want this, we want pk value only, for the purpose of insert the  invtargteting tables
                Integer parentId = null;
                Integer prnId = mediaplanInvDao.getParentId(adUnitId); //### Cast case exp                
                parentId = (prnId > 0) ? prnId : null;
                System.out.println("Adunit -> parent id ==" + parentId);

                AdunitsData Data = new AdunitsData(adUnitId, name, Size, Style, CPM, positions, publisherId, adUnitId, 0, parentId, impression);

                lst.add(Data);
            }
            return lst;
        } catch (Exception e) {
            System.out.println("Error from getChildFromAdunits(Integer placementId) in DAO Impl ");
            e.printStackTrace();
            return null;
        }
    }

    public String accessPUTmethod(Mediaplan mp) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            String jsonParam = "";

            Map<String, String> map = new HashMap<String, String>();

            map.put("advertiserId", "51235043");
            map.put("orderName", mp.getName());
            map.put("publisherId", "95295803");
            map.put("startDate", sdf.format(mp.getStartDate()));
            map.put("endDate", sdf.format(mp.getEndDate()));
            //convert map to JSON string
            jsonParam = mapper.writeValueAsString(map);
            //System.out.println("jsonParam==" + jsonParam);

            String urlStr = "http://50.112.157.222/CIS/orders?networkId=269233203";
            URL url = new URL(urlStr);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
            httpCon.setRequestProperty("Content-Type", "application/json");
            httpCon.setRequestProperty("charset", "utf-8");
            //httpCon.setRequestProperty("Content-Length", "" + Integer.toString(param1.getBytes().length));
            OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());

            out.write(jsonParam);
            out.flush();
            out.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream(), Charset.forName("UTF-8")));
            String inputLine;
            String jsonText = "";
            jsonText = this.readAll(in);
            if (jsonText.startsWith("[")) {
                int len = jsonText.length();
                jsonText = jsonText.replaceAll("^\\[|\\]$", ""); // first and last char only 
                // System.out.println("jsonText =" + jsonText);
            }
            in.close();
            JSONObject json = new JSONObject(jsonText);
            // System.out.println("json ===" + json);

            String IntegrationId = json.get("orderId").toString();
            String status = json.getString("status").toString();
            // System.out.println("mediaplan ORder id =" + IntegrationId);

            if (Integer.parseInt(IntegrationId) > 0) {
                mediaplanInvDao.updateMediaplan(mp.getId(), IntegrationId, status);
                return IntegrationId;
            } else {
                return "0";
            }
        } catch (Exception e) {
            System.out.println("Error from accessPUTmethod() in Impl");
            e.printStackTrace();
            return "0";
        }
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String str) throws IOException, JSONException {

        try {
            String jsonText = str;

            if (jsonText.startsWith("[")) {
                int len = jsonText.length();
                jsonText = jsonText.replaceAll("^\\[|\\]$", ""); // first and last char only 
                //System.out.println("jsonText ="+jsonText);
            }
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
        }
    }
}
