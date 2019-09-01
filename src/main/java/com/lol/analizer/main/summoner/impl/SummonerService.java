package com.lol.analizer.main.summoner.impl;

import com.lol.analizer.externalApi.exception.NoDataFoundException;
import com.lol.analizer.externalApi.gameConstants.Region;
import com.lol.analizer.externalApi.summonerApi.SummonerApi;
import com.lol.analizer.externalApi.summonerApi.dto.SummonerDto;
import com.lol.analizer.main.summoner.ISummonerDao;
import com.lol.analizer.main.summoner.ISummonerService;
import com.lol.analizer.main.summoner.SummonerConverter;
import com.lol.analizer.main.summoner.beans.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;

@Service
public class SummonerService implements ISummonerService {


    private ISummonerDao summonerDao;

    @Autowired
    public SummonerService(ISummonerDao summonerDao) {
        this.summonerDao = summonerDao;
    }

    @Override
    public Summoner saveSummoner(String summonerName, Region region) throws MalformedURLException, NoDataFoundException {
        SummonerDto summonerDto = SummonerApi.getSummonerByName(summonerName, region);
        Summoner summoner = SummonerConverter.convertToSummoner(summonerDto, region);
        summonerDao.saveSummoner(summoner);
        return summoner;
    }

    @Override
    public Summoner loadSummonerByName(String summonerName, Region region) {
        return null;
    }

    @Override
    public Summoner loadSummonerByAccountId(String id, Region region) {
        return null;
    }

}
