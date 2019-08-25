package com.lol.analizer.api;

public class ApiUtil {

    public static String normalizeUrl(String url){
       return url.replaceAll("\\s", "%20");
    }
}
