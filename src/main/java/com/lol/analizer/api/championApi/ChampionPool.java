package com.lol.analizer.api.championApi;

import com.lol.analizer.api.championApi.dto.ChampionDto;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChampionPool {

    private static Map<String, ChampionDto> nameByChampion;
    private static Map<String, String> idByName;

    private static boolean isNotLoaded() {
        return CollectionUtils.isEmpty(nameByChampion) || CollectionUtils.isEmpty(idByName);
    }

    private static void loadChampions() {
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
