package com.lol.analizer.api.summonerApi;

public class Summoner {

    private String name;
    private String level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Summoner{" +
                "name='" + name + '\'' + "\n" +
                ", level='" + level + '\'' + "\n" +
                '}';
    }
}