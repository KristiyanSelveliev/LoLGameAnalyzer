package com.lol.analizer.externalApi.championApi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChampionDto {

    private String version;
    private String id;
    private String key;
    private String name;
    private String title;
    private String blurb;
    private ChampionInfoDto info;
    private String [] tags;

}
