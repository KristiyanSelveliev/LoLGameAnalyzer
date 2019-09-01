package com.lol.analizer.externalApi.spectatorApi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CurrentGameInfoDto {

    private long gameId;
    private long gameStartTime;
    private String platformId;
    private String gameMode;
    private long mapId;
    private String gameType;
    private List<BannedChampionDto> bannedChampions;
    private List<CurrentGameParticipant> participants;
    private long gameLength;
    private long gameQueueConfigId;

}
