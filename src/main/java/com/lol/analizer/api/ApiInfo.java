package com.lol.analizer.api;

public class ApiInfo {

    private static final String CHAMPION_MASTERY_URL = "https://euw1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/";
    private static final String ENCRYPTED_SUMMONER_ID_URL = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
    private static final String ALL_CHAMPIONS = "http://ddragon.leagueoflegends.com/cdn/9.3.1/data/en_US/champion.json";


    public static String getChampionMasteryUrl(String encryptedSummonerId) {
        return CHAMPION_MASTERY_URL + encryptedSummonerId +  "?api_key=" + ApiKey.getApiKey();
    }

    public static String getEncryptedSummonerIdUrl(String summonerName) {
        return ENCRYPTED_SUMMONER_ID_URL + summonerName + "?api_key=" + ApiKey.getApiKey();
    }
}
