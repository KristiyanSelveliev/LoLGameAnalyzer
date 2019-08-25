package com.lol.analizer.api.summonerApi;

public class Summoner {

    private String name;
    private String level;
    private String id;
    private String accountId;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Summoner{" +
                "name='" + name + '\'' + "\n" +
                ", level='" + level + '\'' + "\n" +
                '}';
    }

}
