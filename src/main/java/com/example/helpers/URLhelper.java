package com.example.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLhelper {
    public static String getcontent(String link )throws IOException{
        URLConnection conn=new URL(link).openConnection();
            try(BufferedReader reader=new BufferedReader(
                new InputStreamReader(conn.getInputStream())
            )){
                String line="";
                StringBuilder content=new StringBuilder();
                while((line=reader.readLine())!=null){
                    content.append(line).append("\r\n");
                }
                return content.toString();
            }


    }



}
