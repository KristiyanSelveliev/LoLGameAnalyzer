package com.lol.analizer;

import com.lol.analizer.externalApi.exception.NoDataFoundException;
import com.lol.analizer.externalApi.gameConstants.Region;
import com.lol.analizer.externalApi.matchApi.MatchApi;
import com.lol.analizer.main.match.impl.MatchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MatchServiceTest {

    private static String summoner = "YULSTER";

    @Autowired
    private MatchService matchService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void saveMatchForSummoner() throws MalformedURLException, NoDataFoundException {
        matchService.saveMatchForSummoner(summoner, Region.EUW, MatchApi.MatchApiParamsHolder
                .builder()
                .champions(new HashSet<>(Arrays.asList(1)))
                .seasons(new HashSet<>(Arrays.asList(9)))
                .build());
    }




}
