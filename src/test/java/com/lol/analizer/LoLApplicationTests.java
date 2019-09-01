package com.lol.analizer;

import com.lol.analizer.externalApi.championApi.ChampionApi;
import com.lol.analizer.externalApi.championApi.ChampionLoader;
import com.lol.analizer.externalApi.championApi.dto.ChampionDto;
import com.lol.analizer.externalApi.championApi.dto.ChampionMasteryDto;
import com.lol.analizer.externalApi.exception.NoDataFoundException;
import com.lol.analizer.externalApi.matchApi.MatchApi;
import com.lol.analizer.externalApi.matchApi.dto.MatchDto;
import com.lol.analizer.externalApi.matchApi.dto.MatchListDto;
import com.lol.analizer.externalApi.matchApi.dto.MatchReferenceDto;
import com.lol.analizer.externalApi.matchApi.dto.MatchTimelineDto;
import com.lol.analizer.externalApi.gameConstants.Region;
import com.lol.analizer.externalApi.spectatorApi.SpectatorApi;
import com.lol.analizer.externalApi.spectatorApi.dto.CurrentGameInfoDto;
import com.lol.analizer.externalApi.summonerApi.SummonerApi;
import com.lol.analizer.externalApi.summonerApi.dto.SummonerDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashSet;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LoLApplicationTests {

	private static String summoner = "YULSTER";
	private static String champion = "Caitlyn";

	@Test
	public void contextLoads() {
	}

	@Test
	public void getSummonerByNameWorks() throws MalformedURLException, NoDataFoundException {
		SummonerDto summoner = SummonerApi.getSummonerByName(LoLApplicationTests.summoner, Region.EUW);
		Assert.assertEquals(summoner.getName(), LoLApplicationTests.summoner);
		Assert.assertEquals(summoner.getSummonerLevel(),50);
	}

	@Test
	public void getChampionByNameWorks(){
		ChampionDto championDto = ChampionLoader.loadChampionByName(LoLApplicationTests.champion);
		Assert.assertEquals(championDto.getName(), LoLApplicationTests.champion);
		Assert.assertEquals(championDto.getTitle(),"the Sheriff of Piltover");
	}

	@Test
	public void getChampionMasteryBySummonerId() throws MalformedURLException, NoDataFoundException {
		SummonerDto summoner = SummonerApi.getSummonerByName(LoLApplicationTests.summoner, Region.EUW);
		ChampionDto championDto = ChampionLoader.loadChampionByName(LoLApplicationTests.champion);
		ChampionMasteryDto championMasteryDto = ChampionApi.getChampionMasteryById(summoner.getId(), championDto.getKey(), Region.EUW);
		Assert.assertEquals(championMasteryDto.getChampionLevel(),7);
	}

	@Test
	public void getChampionMasteryBySummonerName() throws MalformedURLException, NoDataFoundException {
		ChampionMasteryDto championMasteryDto = ChampionApi.getChampionMasteryByName(LoLApplicationTests.summoner, LoLApplicationTests.champion, Region.EUW);
		Assert.assertEquals(championMasteryDto.getChampionLevel(),7);
	}

	@Test
	public void getSummonerActiveGame() throws MalformedURLException, NoDataFoundException {
		SummonerDto summoner = SummonerApi.getSummonerByName("Dr Caligari", Region.EUNE);
		Assert.assertEquals(summoner.getName(), "Dr Caligari");
		try {
			CurrentGameInfoDto currentGameInfoDto = SpectatorApi.getActiveGameBySummonerId(summoner.getId(), Region.EUNE);
			Assert.assertEquals(currentGameInfoDto.getPlatformId(), "EUN1");
		}catch (NoDataFoundException e){

		}

	}

	@Test
	public void getMatchListBySummoner() throws MalformedURLException, NoDataFoundException {
		MatchListDto matchListDto = MatchApi.getMatchListBySummonerName(LoLApplicationTests.summoner,
				                                                        Region.EUW,
				                                                        MatchApi.MatchApiParamsHolder
				                                                        .builder()
																		.champions(new HashSet<>(Arrays.asList(1)))
																		.seasons(new HashSet<>(Arrays.asList(9)))
																		.build());
		Assert.assertEquals(matchListDto.getMatches().get(0).getLane(), "MID");
	}

	@Test
    public void getMatchTimeLineByMatchId() throws MalformedURLException, NoDataFoundException {
		MatchListDto matchListDto = MatchApi.getMatchListBySummonerName(LoLApplicationTests.summoner,
				Region.EUW,
				MatchApi.MatchApiParamsHolder
						.builder()
						.champions(new HashSet<>(Arrays.asList(1)))
						.seasons(new HashSet<>(Arrays.asList(9)))
						.build());

		MatchReferenceDto match = matchListDto.getMatches().get(0);
		MatchTimelineDto matchTimelineDto = MatchApi.getMatchTimeLineByMatchId(match.getGameId(), Region.EUW);
		Assert.assertEquals(matchTimelineDto.getFrameInterval(), 60000);
	}

	@Test
	public void getMatchByMatchId() throws MalformedURLException, NoDataFoundException {
		MatchListDto matchListDto = MatchApi.getMatchListBySummonerName(LoLApplicationTests.summoner,
				Region.EUW,
				MatchApi.MatchApiParamsHolder
						.builder()
						.champions(new HashSet<>(Arrays.asList(1)))
						.seasons(new HashSet<>(Arrays.asList(9)))
						.build());
		MatchReferenceDto match = matchListDto.getMatches().get(0);
		MatchDto matchDto = MatchApi.getMatchDtoByMatchId(match.getGameId(), Region.EUW);
		Assert.assertEquals(matchDto.getSeasonId(), 9);

	}

}
