package com.lol.analizer.main.summoner;

import com.lol.analizer.externalApi.gameConstants.Region;
import com.lol.analizer.externalApi.summonerApi.dto.SummonerDto;
import com.lol.analizer.main.summoner.beans.Summoner;

public class SummonerConverter {

    public static Summoner convertToSummoner(SummonerDto summonerDto, Region region){
        Summoner summoner = new Summoner();
        summoner.setAccountId(summonerDto.getAccountId());
        summoner.setEncryptedId(summonerDto.getId());
        summoner.setName(summonerDto.getName());
        summoner.setLevel(summonerDto.getSummonerLevel());
        summoner.setRegion(region);
        return summoner;
    }
}
