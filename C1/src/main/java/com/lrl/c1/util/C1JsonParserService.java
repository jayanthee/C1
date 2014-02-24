/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.util;

import com.lrl.c1.util.*;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author logic
 */
public interface C1JsonParserService {

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException;

    public JSONArray readJsonArrayFromUrl(String url) throws IOException, JSONException;

    public void sendPost() throws Exception;
}
