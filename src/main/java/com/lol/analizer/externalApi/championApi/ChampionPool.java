package com.lol.analizer.externalApi.championApi;

import com.lol.analizer.externalApi.championApi.dto.ChampionDto;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ChampionPool {

    private static Map<String, ChampionDto> nameByChampion;
    private static Map<String, String> idByName;

    public static boolean isNotLoaded() {
        return CollectionUtils.isEmpty(nameByChampion) || CollectionUtils.isEmpty(idByName);
    }

    public static void loadChampions() {
      List<ChampionDto> champions = ChampionApi.getAllChampions();
      nameByChampion = ChampionMapper.mapNameByChampion(champions);
      idByName = ChampionMapper.mapIdByName(champions);
    }

    public static ChampionDto getChampionByName(String name) {
        if(isNotLoaded()){
            loadChampions();
        }
        return nameByChampion.get(name);
    }

    public static ChampionDto getChampionById(String id) {
        if(isNotLoaded()){
            loadChampions();
        }
        return getChampionByName(idByName.get(id));
    }

    public static int size(){
        return idByName == null ? 0 : idByName.size();
    }

    public static List<ChampionDto> getAllChampions(){
        if(isNotLoaded()){
            loadChampions();
        }
        return new ArrayList<>(nameByChampion.values());
    }

    static class ChampionMapper{

        private static Map<String, ChampionDto> mapNameByChampion(List<ChampionDto> championDtoList){
          return championDtoList.stream()
                  .collect(Collectors.toMap(x -> x.getName(), x -> x));
        }

        private static Map<String, String> mapIdByName(List<ChampionDto> championDtoList){
          return championDtoList.stream()
                  .collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));
        }
    }

}
