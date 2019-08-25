package com.lol.analizer;

import com.lol.analizer.api.championApi.ChampionApi;
import com.lol.analizer.api.championApi.ChampionLoader;
import com.lol.analizer.api.championApi.dto.ChampionDto;
import com.lol.analizer.api.championApi.dto.ChampionMasteryDto;
import com.lol.analizer.api.platform.Region;
import com.lol.analizer.api.spectatorApi.SpectatorApi;
import com.lol.analizer.api.spectatorApi.dto.CurrentGameInfoDto;
import com.lol.analizer.api.summonerApi.Summoner;
import com.lol.analizer.api.summonerApi.SummonerApi;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LoLApplicationTests {

	private static String summoner = "YULSTER";
	private static String champion = "Caitlyn";

	@Test
	public void contextLoads() {
	}

	@Test
	public void getSummonerByNameWorks() throws MalformedURLException {
		Summoner summoner = SummonerApi.getSummonerByName(LoLApplicationTests.summoner, Region.EUW);
		Assert.assertEquals(summoner.getName(), LoLApplicationTests.summoner);
		Assert.assertEquals(summoner.getLevel(),"49");
	}

	@Test
	public void getChampionByNameWorks(){
		ChampionDto championDto = ChampionLoader.loadChampionByName(LoLApplicationTests.champion);
		Assert.assertEquals(championDto.getName(), LoLApplicationTests.champion);
		Assert.assertEquals(championDto.getTitle(),"the Sheriff of Piltover");
	}

	@Test
	public void getChampionMasteryBySummonerId() throws MalformedURLException {
		Summoner summoner = SummonerApi.getSummonerByName(LoLApplicationTests.summoner, Region.EUW);
		ChampionDto championDto = ChampionLoader.loadChampionByName(LoLApplicationTests.champion);
		ChampionMasteryDto championMasteryDto = ChampionApi.getChampionMasteryById(summoner.getId(), championDto.getKey(), Region.EUW);
		Assert.assertEquals(championMasteryDto.getChampionLevel(),"6");
	}

	@Test
	public void getChampionMasteryBySummonerName() throws MalformedURLException {
		ChampionMasteryDto championMasteryDto = ChampionApi.getChampionMasteryByName(LoLApplicationTests.summoner, LoLApplicationTests.champion, Region.EUW);
		Assert.assertEquals(championMasteryDto.getChampionLevel(),"6");
	}

	@Test
	public void getSummonerActiveGame() throws MalformedURLException {
		Summoner summoner = SummonerApi.getSummonerByName("Red Lust", Region.EUNE);
		Assert.assertEquals(summoner.getName(), "Red Lust");
		CurrentGameInfoDto currentGameInfoDto = SpectatorApi.getActiveGameBySummonerId(summoner.getId(), Region.EUNE);
		if(currentGameInfoDto != null) {
			Assert.assertEquals(currentGameInfoDto.getPlatformId(), "EUN1");
		}
	}


}
