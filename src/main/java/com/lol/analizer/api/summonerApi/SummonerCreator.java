package com.lol.analizer.api.summonerApi;

import com.lol.analizer.api.summonerApi.dto.SummonerDto;

public class SummonerCreator {

    public static Summoner createSummoner(SummonerDto summonerDto){
        Summoner summoner = new Summoner();
        summoner.setName(summonerDto.getName());
        summoner.setLevel(summonerDto.getSummonerLevel());
        return summoner;
    }

}
