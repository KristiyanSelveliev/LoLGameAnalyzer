package com.lol.analizer.main.champion;

import com.lol.analizer.externalApi.championApi.dto.ChampionDto;
import com.lol.analizer.externalApi.gameConstants.ChampionRole;

public interface IChampionDao {

    int getAllChampionsCount();

    void insertChampion(ChampionDto champion);

    void insertChampionRole(ChampionRole championRole);

    int getAllChampionRolesCount();

    void insertRoleForChampion(String championId, String championRole);
}
