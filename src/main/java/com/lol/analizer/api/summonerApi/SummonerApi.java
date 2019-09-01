package com.lol.analizer.api.summonerApi;

import com.lol.analizer.api.ApiConnector;
import com.lol.analizer.api.ApiKey;
import com.lol.analizer.api.gameConstants.Region;
import com.lol.analizer.api.summonerApi.dto.SummonerDto;

import java.net.MalformedURLException;

public class SummonerApi {

    public static Summoner getSummonerByName(String summoner, Region region) throws MalformedURLException {
        SummonerDto summonerDto = getSummonerDto("https://" + region.getValue()+
                ".api.riotgames.com/lol/summoner/v4/summoners/by-name/"
                + summoner
                + ApiKey.getApiKeyRequestParam());

        return SummonerCreator.createSummoner(summonerDto);
    }

    private static SummonerDto getSummonerDto(String url) throws MalformedURLException {
        return ApiConnector.callApi(url, SummonerDto.class);
    }
}
