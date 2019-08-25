package com.lol.analizer.api.spectatorApi.dto;

import java.util.List;

public class CurrentGameInfoDto {

    private String gameId;
    private String gameStartTime;
    private String platformId;
    private String gameMode;
    private String mapId;
    private String gameType;
    private List<BannedChampionDto> bannedChampions;
    private List<CurrentGameParticipant> participants;
    private String gameLength;
    private String gameQueueConfigId;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameStartTime() {
        return gameStartTime;
    }

    public void setGameStartTime(String gameStartTime) {
        this.gameStartTime = gameStartTime;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public List<BannedChampionDto> getBannedChampions() {
        return bannedChampions;
    }

    public void setBannedChampions(List<BannedChampionDto> bannedChampions) {
        this.bannedChampions = bannedChampions;
    }

    public List<CurrentGameParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<CurrentGameParticipant> participants) {
        this.participants = participants;
    }

    public String getGameLength() {
        return gameLength;
    }

    public void setGameLength(String gameLength) {
        this.gameLength = gameLength;
    }

    public String getGameQueueConfigId() {
        return gameQueueConfigId;
    }

    public void setGameQueueConfigId(String gameQueueConfigId) {
        this.gameQueueConfigId = gameQueueConfigId;
    }
}
