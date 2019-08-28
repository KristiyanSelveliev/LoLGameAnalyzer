package com.lol.analizer.api.matchApi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ParticipantTimelineDto {
    String lane;
    int participantid;
    Map<String, Double> csDiffPerMinDeltas;
    Map<String, Double> goldPerMinDeltas;
    Map<String, Double> xpDiffPerMinDeltas;
    Map<String, Double> creepsPerMinDeltas;
    Map<String, Double> xpPerMinDeltas;
    String role;
    Map<String, Double> damageTakenDiffPerMinDeltas;
    Map<String, Double> damageTakenPerMinDeltas;
}
