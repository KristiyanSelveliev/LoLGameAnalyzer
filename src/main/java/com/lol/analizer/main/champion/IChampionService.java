package com.lol.analizer.main.champion;

import com.lol.analizer.externalApi.championApi.dto.ChampionDto;
import com.lol.analizer.externalApi.gameConstants.ChampionRole;

import java.util.List;


public interface IChampionService {

    int getAllChampionsCount();

    int getAllChampionRolesCount();

    void insertChampion(ChampionDto champion);

    void insertChampions(List<ChampionDto> champions);

    void insertChampionRoles(ChampionRole [] roles);
}
