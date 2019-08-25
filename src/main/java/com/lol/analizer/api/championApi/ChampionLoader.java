package com.lol.analizer.api.championApi;

import com.lol.analizer.api.championApi.dto.ChampionDto;

public class ChampionLoader {

    public static ChampionDto loadChampionByName(String name){
        return ChampionPool.getChampionByName(name);
    }

    public static ChampionDto loadChampionById(String id){
        return ChampionPool.getChampionById(id);
    }

}
