package com.lol.analizer.main.match;

import com.lol.analizer.externalApi.exception.NoDataFoundException;
import com.lol.analizer.externalApi.gameConstants.Region;
import com.lol.analizer.externalApi.matchApi.MatchApi;
import com.lol.analizer.main.match.beans.Match;
import com.lol.analizer.main.match.beans.SummonerMatch;

import java.net.MalformedURLException;

public interface IMatchService {

    void saveMatch(Match match);

    void saveSummonerMatch(SummonerMatch summonerMatch);

    void saveMatchForSummoner(String summonerName, Region region, MatchApi.MatchApiParamsHolder matchApiParamsHolder) throws MalformedURLException, NoDataFoundException;

    Match findMatchByMatchId(long matchId, Region region) throws MalformedURLException, NoDataFoundException;
}
