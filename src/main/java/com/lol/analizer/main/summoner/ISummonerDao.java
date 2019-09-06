package com.lol.analizer.main.summoner;

import com.lol.analizer.externalApi.gameConstants.Region;
import com.lol.analizer.main.summoner.beans.Summoner;

public interface ISummonerDao {

    void saveSummoner(Summoner summoner);
    Summoner loadSummonerByName(String summonerName, Region region);
    Summoner loadSummonerByAccountId(String accountId, Region region);
}
