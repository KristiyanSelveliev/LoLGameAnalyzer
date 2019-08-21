package com.lol.analizer.dto;

public class EncryptedSummonerDto {

       private String id;
       private String accountId;
       private String puuid;
       private String name;
       private String summonerLevel;

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

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(String summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    @Override
    public String toString() {
        return "EncryptedSummonerDto{" + "\n" +
                "id='" + id + '\'' + "\n" +
                ", accountId='" + accountId + '\'' + "\n" +
                ", puuid='" + puuid + '\'' + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", summonerLevel='" + summonerLevel + '\'' +
                '}';
    }
}
