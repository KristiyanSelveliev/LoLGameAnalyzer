package com.lol.analizer;

import com.lol.analizer.externalApi.exception.NoDataFoundException;
import com.lol.analizer.externalApi.gameConstants.Region;
import com.lol.analizer.main.summoner.beans.Summoner;
import com.lol.analizer.main.summoner.impl.SummonerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SummonerServiceTest {

    private static String summoner = "random name";

    @Autowired
    SummonerService summonerService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void saveSummoner() throws MalformedURLException, NoDataFoundException {
       Summoner summoner = summonerService.saveSummoner(SummonerServiceTest.summoner, Region.EUW);
        Assert.assertEquals(summoner.getName().toLowerCase(), SummonerServiceTest.summoner.toLowerCase());
    }

}
