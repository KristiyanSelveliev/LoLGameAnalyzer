package com.lol.analizer.api.championApi;

import com.lol.analizer.api.ApiConnector;
import com.lol.analizer.api.championApi.dto.ChampionDto;

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
}
