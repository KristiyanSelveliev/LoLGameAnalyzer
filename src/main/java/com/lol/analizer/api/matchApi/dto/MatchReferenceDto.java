package com.lol.analizer.api.matchApi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchReferenceDto {

    private String lane;
    private long gameId;
    private int champion;
    private String platformId;
    private int season;
    private int queue;
    private String role;
    private long timestamp;

}
