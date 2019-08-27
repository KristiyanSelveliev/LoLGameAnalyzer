package com.lol.analizer.api.spectatorApi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BannedChampionDto {

    private int pickTurn;
    private long championId;
    private long teamId;

}
