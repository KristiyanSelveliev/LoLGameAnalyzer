package com.lol.analizer.api.rank;

public enum Rank {

    CHALLENGER("CHALLENGER"),
    MASTER("MASTER"),
    DIAMOND("DIAMOND"),
    PLATINUM("PLATINUM"),
    GOLD("GOLD"),
    SILVER("SILVER"),
    BRONZE("BRONZE"),
    IRON("IRON"),
    UNRANKED("UNRANKED");

    private String value;

    Rank(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
