package com.lol.analizer.main.summoner.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lol.analizer.externalApi.gameConstants.Region;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Summoner {

    @JsonIgnore
    private String summonerId;
    private String name;
    private long level;
    private String region;
    @JsonIgnore
    private String accountId;
    @JsonIgnore
    private String encryptedId;

    @Override
    public String toString() {
        return "Summoner{" +
                "name='" + name + '\'' + "\n" +
                ", level='" + level + '\'' + "\n" +
                '}';
    }
}
