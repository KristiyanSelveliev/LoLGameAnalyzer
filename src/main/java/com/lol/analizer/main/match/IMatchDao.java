package com.lol.analizer.main.match;

import com.lol.analizer.main.match.beans.Match;
import com.lol.analizer.main.match.beans.SummonerMatch;

public interface IMatchDao {

    void saveMatch(Match match);

    void saveSummonerMatch(SummonerMatch summonerMatch);
}
