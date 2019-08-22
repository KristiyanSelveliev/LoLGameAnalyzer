package com.lol.analizer.api.championApi.dto;

public class ChampionMasteryDto {

    private String championLevel;
    private String championPoints;
    private String championId;
    private String lastPlayTime;
    private String summonerId;

    public String getChampionLevel() {
        return championLevel;
    }

    public void setChampionLevel(String championLevel) {
        this.championLevel = championLevel;
    }

    public String getChampionPoints() {
        return championPoints;
    }

    public void setChampionPoints(String championPoints) {
        this.championPoints = championPoints;
    }

    public String getChampionId() {
        return championId;
    }

    public void setChampionId(String championId) {
        this.championId = championId;
    }

    public String getLastPlayTime() {
        return lastPlayTime;
    }

    public void setLastPlayTime(String lastPlayTime) {
        this.lastPlayTime = lastPlayTime;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

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
