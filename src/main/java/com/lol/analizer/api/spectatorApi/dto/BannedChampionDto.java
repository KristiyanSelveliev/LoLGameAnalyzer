package com.lol.analizer.api.spectatorApi.dto;

public class BannedChampionDto {

    private String pickTurn	;
    private String championId;
    private String teamId;

    public String getPickTurn() {
        return pickTurn;
    }

    public void setPickTurn(String pickTurn) {
        this.pickTurn = pickTurn;
    }

    public String getChampionId() {
        return championId;
    }

    public void setChampionId(String championId) {
        this.championId = championId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
