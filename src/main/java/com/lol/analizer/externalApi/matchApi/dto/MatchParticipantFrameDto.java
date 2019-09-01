package com.lol.analizer.externalApi.matchApi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchParticipantFrameDto {
    int totalGold;
    int teamScore;
    int participantId;
    int level;
    int currentGold;
    int minionsKilled;
    int dominionScore;
    MatchPositionDto position;
    int xp;
    int jungleMinionsKilled;
}
