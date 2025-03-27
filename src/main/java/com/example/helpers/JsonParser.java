package com.example.helpers;

import org.json.JSONArray;
import org.json.JSONObject;


public class JsonParser {
    public static JSONArray parseJson(String content)  {
        JSONObject json=new JSONObject(content);
            JSONArray array=json.getJSONArray("users");
            return array;

    }  
}
