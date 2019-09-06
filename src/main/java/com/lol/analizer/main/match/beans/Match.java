package com.lol.analizer.main.match.beans;

import com.lol.analizer.externalApi.gameConstants.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Match {

    private long matchId;
    private String region;
    private int season;
    private String patch;
    private String gameMode;
    private Map map;
    private String gameType;
    private long gameCreation;
    private long gameDuration;
}
