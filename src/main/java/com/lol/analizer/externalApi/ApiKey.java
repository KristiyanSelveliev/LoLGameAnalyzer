package com.lol.analizer.externalApi;

public class ApiKey {

    private static final String API_KEY = "API-KEY-HERE";
    private static final String API_KEY_REQUEST_PARAM =  "?api_key=" + API_KEY;

    public static String getApiKey(){
        return API_KEY;
    }

    public static String getApiKeyRequestParam() {
        return API_KEY_REQUEST_PARAM;
    }
}
