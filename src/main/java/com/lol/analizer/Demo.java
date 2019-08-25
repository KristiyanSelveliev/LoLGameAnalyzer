package com.lol.analizer;

import com.lol.analizer.api.championApi.ChampionLoader;
import com.lol.analizer.api.championApi.dto.ChampionDto;
import com.lol.analizer.api.platform.Region;
import com.lol.analizer.api.summonerApi.Summoner;
import com.lol.analizer.api.summonerApi.SummonerApi;

import java.net.MalformedURLException;


public class Demo {

    static String summonerName = "YULSTER";

    public static void main(String [] args) throws MalformedURLException {

        Summoner summoner = SummonerApi.getSummonerByName(summonerName, Region.EUW);
        System.out.println(summoner);
        ChampionDto championDto = ChampionLoader.loadChampionByName("Caitlyn");
    }
}
