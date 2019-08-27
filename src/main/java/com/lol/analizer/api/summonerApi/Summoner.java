package com.lol.analizer.api.summonerApi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Summoner {

    private String name;
    private long level;
    private String id;
    private String accountId;

    @Override
    public String toString() {
        return "Summoner{" +
                "name='" + name + '\'' + "\n" +
                ", level='" + level + '\'' + "\n" +
                '}';
    }

}
