package com.lol.analizer.externalApi.matchApi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatchEventDto {
    String eventType;
    String towerType;
    int teamId;
    String ascendedType;
    int killerId;
    String levelUpType;
    String pointCaptured;
    List<Integer> assistingParticipantIds;
    String wardType;
    String monsterType;
    String type;
    int skillSlot;
    int victimId;
    long timestamp;
    int afterId;
    String monsterSubType;
    String laneType;
    int itemId;
    int participantId;
    String buildingType;
    int creatorId;
    MatchPositionDto position;
    int beforeId;
}
