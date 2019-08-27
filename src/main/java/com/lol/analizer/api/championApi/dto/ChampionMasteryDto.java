package com.lol.analizer.api.championApi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChampionMasteryDto {

    boolean chestGranted;
    private int championLevel;
    private int championPoints;
    private long championId;
    private long championPointsUntilNextLevel;
    private long lastPlayTime;
    private int tokensEarned;
    private long championPointsSinceLastLevel;
    private String summonerId;

    @Override
    public String toString() {
        return "ChampionMasteryDto{" +
                "championLevel='" + championLevel + '\'' +  "\n" +
                ", championPoints='" + championPoints + '\'' + "\n" +
                ", championId='" + championId + '\'' + "\n" +
                ", lastPlayTime='" + lastPlayTime + '\'' + "\n" +
                ", summonerId='" + summonerId + '\'' + "\n" +
                '}';
    }
}
