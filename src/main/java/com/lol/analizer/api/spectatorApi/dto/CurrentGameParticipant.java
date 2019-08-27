package com.lol.analizer.api.spectatorApi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentGameParticipant {

    private long profileIconId;
    private long championId;
    private String summonerName;
    private boolean bot;
    private PerkDto perks;
    private long spell2Id;
    private long teamId;
    private long spell1Id;
    private String summonerId;

}
