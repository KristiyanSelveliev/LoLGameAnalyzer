package com.lol.analizer.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class ApiConnector {

    public static <T> T callApi(String url, Class<T> type) throws MalformedURLException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        URL url1 = new URL(url);
        try {
            return objectMapper.readValue(url1, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
