/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.util;

import com.lrl.c1.util.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author logic
 */
@Service("C1JsonParserService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class C1JsonParserServiceImpl implements C1JsonParserService {

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);

            if (jsonText.startsWith("[")) {
                int len = jsonText.length();
                jsonText = jsonText.replaceAll("^\\[|\\]$", ""); // first and last char only 
                //System.out.println("jsonText ="+jsonText);
            }
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public JSONArray readJsonArrayFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = new JSONArray(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

   
    
//       // HTTP POST request
    public void sendPost() throws Exception {
        
        String USER_AGENT = "Mozilla/5.0";

        //String url = "https://selfsolve.apple.com/wcResults.do";
        
        String advertiserId ="41008096";//"51235043" ;// "41008096";
        String puplisherId = "78815656";//"269233203"; //"78815656";
        String orderName = "SharanTest";//mp.getName();
        String startDate = "13/08/2013 01:42:00"; //sdf.format(mp.getStartDate());
        String endDate = "17/08/2013 06:59:00"; //sdf.format(mp.getEndDate());
        
        
        String urlParameters = "&orderName=" + orderName + "&puplisherId=" + puplisherId + "&startDate=" + startDate + "&endDate=" + endDate + "&networkId=269233203";
        String url = "http://50.112.157.222/CIS/orders?advertiserId=" + advertiserId+urlParameters;
        //String URL1 = url.replaceAll(" ", "%20");
        URL obj = new URL(url);
        System.out.println("stage 0");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        System.out.println("stage 0.1");

        //add reuqest header
        con.setRequestMethod("PUT");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Content-Type", "application/json");
        
        System.out.println("stage 0.2");

        //String urlParameters = "&orderName=" + orderName + "&puplisherId=" + puplisherId + "&startDate=" + startDate + "&endDate=" + endDate + "&networkId=269233203";

        // Send post request
        con.setDoOutput(true);
        con.connect();
//        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//        wr.writeBytes(urlParameters);
//        wr.flush();
//        wr.close();
//        
//        System.out.println("stage 0.3");
//        
//        int responseCode = con.getResponseCode();
//        
//        System.out.println("\nSending 'POST' request to URL : " + url);
//        System.out.println("Post parameters : " + urlParameters);
//        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        System.out.println("stage 1");
        
        String inputLine;
        StringBuffer response = new StringBuffer();
        System.out.println("stage 2");
        
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        System.out.println("stage 3");
        in.close();

        //print result
        System.out.println("RESPONSE DATA : = "+response.toString());

    }
    
    
    
//    
//    // HTTP GET request
//	private void sendGet() throws Exception {
// 
//		String url = "http://www.google.com/search?q=mkyong";
// 
//		URL obj = new URL(url);
//		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
// 
//		// optional default is GET
//		con.setRequestMethod("GET");
// 
//		//add request header
//		con.setRequestProperty("User-Agent", USER_AGENT);
// 
//		int responseCode = con.getResponseCode();
//		System.out.println("\nSending 'GET' request to URL : " + url);
//		System.out.println("Response Code : " + responseCode);
// 
//		BufferedReader in = new BufferedReader(
//		        new InputStreamReader(con.getInputStream()));
//		String inputLine;
//		StringBuffer response = new StringBuffer();
// 
//		while ((inputLine = in.readLine()) != null) {
//			response.append(inputLine);
//		}
//		in.close();
// 
//		//print result
//		System.out.println(response.toString());
// 
//	}
//    
    // HTTP POST request 
//    private void sendPost() throws Exception {
//
//        String url = "https://selfsolve.apple.com/wcResults.do";
//        URL obj = new URL(url);
//        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
//
//        //add reuqest header
//        con.setRequestMethod("POST");
//        con.setRequestProperty("User-Agent", USER_AGENT);
//        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//
//        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
//
//        // Send post request
//        con.setDoOutput(true);
//        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//        wr.writeBytes(urlParameters);
//        wr.flush();
//        wr.close();
//
//        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'POST' request to URL : " + url);
//        System.out.println("Post parameters : " + urlParameters);
//        System.out.println("Response Code : " + responseCode);
//
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//
//        //print result
//        System.out.println(response.toString());
//
//    }
}
