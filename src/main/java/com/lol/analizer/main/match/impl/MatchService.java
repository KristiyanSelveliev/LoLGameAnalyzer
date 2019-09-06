package com.lol.analizer.main.match.impl;

import com.lol.analizer.externalApi.exception.NoDataFoundException;
import com.lol.analizer.externalApi.gameConstants.Region;
import com.lol.analizer.externalApi.matchApi.MatchApi;
import com.lol.analizer.externalApi.matchApi.dto.MatchDto;
import com.lol.analizer.externalApi.matchApi.dto.MatchListDto;
import com.lol.analizer.externalApi.matchApi.dto.MatchReferenceDto;
import com.lol.analizer.main.match.IMatchDao;
import com.lol.analizer.main.match.IMatchService;
import com.lol.analizer.main.match.MatchConverter;
import com.lol.analizer.main.match.beans.Match;
import com.lol.analizer.main.match.beans.SummonerMatch;
import com.lol.analizer.main.summoner.beans.Summoner;
import com.lol.analizer.main.summoner.impl.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.MalformedURLException;

@Service
public class MatchService implements IMatchService {

    private IMatchDao matchDao;
    private SummonerService summonerService;

    @Autowired
    public MatchService(IMatchDao matchDao, SummonerService summonerService) {
        this.matchDao = matchDao;
        this.summonerService = summonerService;
    }

    @Override
    public void saveMatch(Match match) {
        matchDao.saveMatch(match);
    }

    @Override
    public void saveSummonerMatch(SummonerMatch summonerMatch) {
        matchDao.saveSummonerMatch(summonerMatch);
    }

    @Override
    @Transactional
    public void saveMatchForSummoner(String summonerName, Region region, MatchApi.MatchApiParamsHolder paramsHolder) throws MalformedURLException, NoDataFoundException {
        Summoner summoner = summonerService.loadSummonerByName(summonerName, region);
        MatchListDto matchDto = MatchApi.getMatchListByAccountId(summoner.getAccountId(), region, paramsHolder);
        for(MatchReferenceDto matchReferenceDto : matchDto.getMatches()){
            SummonerMatch summonerMatch = MatchConverter.convertToSummonerMatch(matchReferenceDto, summoner.getAccountId());
            Match match = findMatchByMatchId(summonerMatch.getMatchId(), region);
            saveMatch(match);
            saveSummonerMatch(summonerMatch);
        }
    }

    @Override
    public Match findMatchByMatchId(long matchId, Region region) throws MalformedURLException, NoDataFoundException {
        MatchDto matchDto = MatchApi.getMatchDtoByMatchId(matchId, region);
        Match match = MatchConverter.convertToMatch(matchDto);
        return match;
    }


}
