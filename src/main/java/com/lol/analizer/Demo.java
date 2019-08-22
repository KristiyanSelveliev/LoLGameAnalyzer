package com.lol.analizer;

import com.lol.analizer.api.ApiConnector;
import com.lol.analizer.api.ApiInfo;
import com.lol.analizer.api.platform.Region;
import com.lol.analizer.api.summonerApi.Summoner;
import com.lol.analizer.api.summonerApi.SummonerApi;
import com.lol.analizer.api.summonerApi.dto.EncryptedSummonerDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.MalformedURLException;


public class Demo {

    static String summonerName = "YULSTER";

    public static void main(String [] args) throws MalformedURLException {
      //  ApiConnector apiConnector = new ApiConnector();
//
      //  EncryptedSummonerDto summonerDto = apiConnector.callApi(ApiInfo.getEncryptedSummonerIdUrl(summonerName), EncryptedSummonerDto.class);
      //  System.out.println(summonerDto);
       //        ChampionMasteryDto[] arr = apiConnector.callApi(ApiInfo.getChampionMasteryUrl(summonerDto.getId()), ChampionMasteryDto[].class);
       // Map<ChampionMasteryDto, ChampionDto> map = new HashMap<>();

       // for(ChampionMasteryDto masteryDto : arr){
//
       // }
       // System.out.println(arr);

        SummonerApi summonerApi = new SummonerApi();
        Summoner summoner = summonerApi.getSummonerByName(summonerName, Region.EUW);
        System.out.println(summoner);
    }
}
