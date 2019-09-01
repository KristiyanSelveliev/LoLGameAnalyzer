package com.lol.analizer.externalApi.summonerApi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SummonerDto {

        private int profileIconId;
        private String name;
        private String puuid;
        private long summonerLevel;
        private String accountId;
        private String id;
        private long revisionDate;

}
