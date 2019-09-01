package com.lol.analizer.externalApi;

public class ApiUtil {

    public static String normalizeUrl(String url){
       return url.replaceAll("\\s", "%20");
    }
}
