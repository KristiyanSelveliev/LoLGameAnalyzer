package com.lol.analizer.main.summoner;

import com.lol.analizer.externalApi.exception.NoDataFoundException;
import com.lol.analizer.externalApi.gameConstants.Region;
import com.lol.analizer.main.summoner.beans.Summoner;

import java.net.MalformedURLException;

public interface ISummonerService {

    Summoner saveSummoner(String summonerName, Region region) throws MalformedURLException, NoDataFoundException;
    Summoner loadSummonerByName(String summonerName, Region region);
    Summoner loadSummonerByAccountId(String id, Region region);
}
