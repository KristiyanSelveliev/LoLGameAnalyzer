package com.lol.analizer;

import com.lol.analizer.api.ApiConnector;
import com.lol.analizer.api.ApiInfo;
import com.lol.analizer.dto.EncryptedSummonerDto;

import java.net.MalformedURLException;

public class Demo {
    static String summonerName = "YULSTER";


    public static void main(String [] args) throws MalformedURLException {
        ApiConnector apiConnector = new ApiConnector();

        EncryptedSummonerDto summonerDto = apiConnector.callApi(ApiInfo.getEncryptedSummonerIdUrl(summonerName), EncryptedSummonerDto.class);
        System.out.println(summonerDto);
    }
}
