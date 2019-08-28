package com.lol.analizer.api.matchApi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatchDto {
    int seasonId;
    int queueId;
    long gameId;
    List<ParticipantIdentityDto> participantIdentities;
    String gameVersion;
    String platformId;
    String gameMode;
    int  mapId;
    String gameType;
    List<TeamStatsDto> teams;
    List<ParticipantDto> participants;
    long gameDuration;
    long gameCreation;
}
