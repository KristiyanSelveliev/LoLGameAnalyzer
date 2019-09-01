package com.lol.analizer.externalApi.championApi;

import com.lol.analizer.externalApi.ApiConnector;
import com.lol.analizer.externalApi.ApiKey;
import com.lol.analizer.externalApi.championApi.dto.ChampionDto;
import com.lol.analizer.externalApi.championApi.dto.ChampionMasteryDto;
import com.lol.analizer.externalApi.exception.NoDataFoundException;
import com.lol.analizer.externalApi.gameConstants.Region;
import com.lol.analizer.externalApi.summonerApi.SummonerApi;
import com.lol.analizer.externalApi.summonerApi.dto.SummonerDto;

import java.net.MalformedURLException;
import java.util.Collections;
import java.util.List;

public class ChampionApi {

    public static List<ChampionDto> getAllChampions(){
        try {
            List<ChampionDto> champions =
                    ApiConnector.apiGetListOfProperties("http://ddragon.leagueoflegends.com/cdn/6.24.1/data/en_US/champion.json",
                            ChampionDto.class, "data");
            return champions;
        }catch (MalformedURLException e){
            return Collections.EMPTY_LIST;
        }
    }

    public static ChampionMasteryDto getChampionMasteryById(String summonerId, String championId, Region region) throws MalformedURLException, NoDataFoundException {
        return ApiConnector.callApi("https://" + region.getValue()+
                ".api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/" + summonerId +
                "/by-champion/" +
                 championId +
                 ApiKey.getApiKeyRequestParam(), ChampionMasteryDto.class);
    }

    public static ChampionMasteryDto getChampionMasteryByName(String summonerName, String championName, Region region) throws MalformedURLException, NoDataFoundException {
        SummonerDto summoner = SummonerApi.getSummonerByName(summonerName, Region.EUW);
        ChampionDto champion= ChampionLoader.loadChampionByName(championName);
        return getChampionMasteryById(summoner.getId(), champion.getKey(), region);
    }



}
