package com.lol.analizer.api.spectatorApi;

import com.lol.analizer.api.ApiConnector;
import com.lol.analizer.api.ApiKey;
import com.lol.analizer.api.gameConstants.Region;
import com.lol.analizer.api.spectatorApi.dto.CurrentGameInfoDto;
import com.lol.analizer.api.summonerApi.Summoner;
import com.lol.analizer.api.summonerApi.SummonerApi;

import java.net.MalformedURLException;

public class SpectatorApi {

    public static CurrentGameInfoDto getActiveGameBySummonerName(String summonerName, Region region) throws MalformedURLException {
        Summoner summoner = SummonerApi.getSummonerByName(summonerName, region);
        return ApiConnector.callApi("https://" + region.getValue()+
                ".api.riotgames.com/lol/spectator/v4/active-games/by-summoner/"
                + summoner.getId()
                + ApiKey.getApiKeyRequestParam(), CurrentGameInfoDto.class);

    }

    public static CurrentGameInfoDto getActiveGameBySummonerId(String summonerId, Region region) throws MalformedURLException {

        return ApiConnector.callApi("https://" + region.getValue()+
                ".api.riotgames.com/lol/spectator/v4/active-games/by-summoner/"
                + summonerId
                + ApiKey.getApiKeyRequestParam(), CurrentGameInfoDto.class);

    }

}
