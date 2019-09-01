package com.lol.analizer.externalApi.matchApi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class MatchFrameDto {
    long timestamp;
    Map<String, MatchParticipantFrameDto> participantFrames;
    List<MatchEventDto> events;
}
