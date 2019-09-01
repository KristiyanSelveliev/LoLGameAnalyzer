package com.lol.analizer.externalApi.spectatorApi;

import com.lol.analizer.externalApi.ApiConnector;
import com.lol.analizer.externalApi.ApiKey;
import com.lol.analizer.externalApi.exception.NoDataFoundException;
import com.lol.analizer.externalApi.gameConstants.Region;
import com.lol.analizer.externalApi.spectatorApi.dto.CurrentGameInfoDto;
import com.lol.analizer.externalApi.summonerApi.SummonerApi;
import com.lol.analizer.externalApi.summonerApi.dto.SummonerDto;

import java.net.MalformedURLException;

public class SpectatorApi {

    public static CurrentGameInfoDto getActiveGameBySummonerName(String summonerName, Region region) throws MalformedURLException, NoDataFoundException {
        SummonerDto summoner = SummonerApi.getSummonerByName(summonerName, region);
        return ApiConnector.callApi("https://" + region.getValue()+
                ".api.riotgames.com/lol/spectator/v4/active-games/by-summoner/"
                + summoner.getId()
                + ApiKey.getApiKeyRequestParam(), CurrentGameInfoDto.class);

    }

    public static CurrentGameInfoDto getActiveGameBySummonerId(String summonerId, Region region) throws MalformedURLException, NoDataFoundException {

        return ApiConnector.callApi("https://" + region.getValue()+
                ".api.riotgames.com/lol/spectator/v4/active-games/by-summoner/"
                + summonerId
                + ApiKey.getApiKeyRequestParam(), CurrentGameInfoDto.class);

    }

}
