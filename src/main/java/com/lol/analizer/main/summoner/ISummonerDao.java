package com.lol.analizer.main.summoner;

import com.lol.analizer.main.summoner.beans.Summoner;

public interface ISummonerDao {

    void saveSummoner(Summoner summoner);
    Summoner loadSummonerByName(String summonerName);
    Summoner loadSummonerByAccountId(String id);


}
