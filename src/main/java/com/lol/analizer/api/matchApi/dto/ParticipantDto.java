package com.lol.analizer.api.matchApi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParticipantDto {

    ParticipantStatsDto stats;
    int participantId;
    List<RuneDto> runes;
    ParticipantTimelineDto timeline;
    int teamId;
    int spell2Id;
    List<MasteryDto> masteries;
    String	highestAchievedSeasonTier;
    int spell1Id;
    int championId;
}
