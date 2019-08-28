package com.lol.analizer.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ApiConnector {

    public static <T> T callApi(String url, Class<T> type) throws MalformedURLException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        URL url1 = new URL(ApiUtil.normalizeUrl(url));
        try {
            return objectMapper.readValue(url1, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> apiGetListOfProperties(String url, Class<T> type, String jsonProperty) throws MalformedURLException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        URL url1 = new URL(ApiUtil.normalizeUrl(url));
        try {
            JsonNode jsonNode = objectMapper.readTree(url1);
            jsonNode = jsonNode.get(jsonProperty);
            return getListOfObjectsFromNode(jsonNode, objectMapper ,type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static <T> List<T> getListOfObjectsFromNode(JsonNode node, ObjectMapper objectMapper, Class<T> type) throws JsonProcessingException {
        List<T> list = new ArrayList<T>();
        Iterator<JsonNode> iterator = node.iterator();
        while(iterator.hasNext()){
            JsonNode currentNode = iterator.next();
            list.add( objectMapper.treeToValue(currentNode, type));
        }
        return list;
    }

}
