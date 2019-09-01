package com.lol.analizer.externalApi.summonerApi;

import com.lol.analizer.externalApi.ApiConnector;
import com.lol.analizer.externalApi.ApiKey;
import com.lol.analizer.externalApi.exception.NoDataFoundException;
import com.lol.analizer.externalApi.gameConstants.Region;
import com.lol.analizer.externalApi.summonerApi.dto.SummonerDto;

import java.net.MalformedURLException;

public class SummonerApi {

    public static SummonerDto getSummonerByName(String summoner, Region region) throws MalformedURLException, NoDataFoundException {

            SummonerDto summonerDto = getSummonerDto("https://" + region.getValue() +
                    ".api.riotgames.com/lol/summoner/v4/summoners/by-name/"
                    + summoner
                    + ApiKey.getApiKeyRequestParam());

            return summonerDto;
    }

    private static SummonerDto getSummonerDto(String url) throws MalformedURLException, NoDataFoundException {
        return ApiConnector.callApi(url, SummonerDto.class);
    }
}
