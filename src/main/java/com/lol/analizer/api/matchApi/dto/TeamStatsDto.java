package com.lol.analizer.api.matchApi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamStatsDto {

    boolean firstDragon;
    boolean firstInhibitor;
    List<TeamBansDto> bans;
    int baronKills;
    boolean firstRiftHerald;
    boolean firstBaron;
    int riftHeraldKills;
    boolean firstBlood;
    int teamId;
    boolean firstTower;
    int vilemawKills;
    int inhibitorKills;
    int towerKills;
    int dominionVictoryScore;
    String win;
    int dragonKills;
}
