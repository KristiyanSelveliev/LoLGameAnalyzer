package com.lol.analizer.main.match.beans;

import com.lol.analizer.externalApi.gameConstants.Region;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SummonerMatch {

    private String lane;
    private long matchId;
    private int championId;
    private String region;
    private int season;
    private int queue;
    private String role;
    private long timestamp;
    private String accountId;
}
