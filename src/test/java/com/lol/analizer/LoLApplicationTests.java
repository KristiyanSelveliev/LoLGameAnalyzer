package com.lol.analizer;

import com.lol.analizer.api.championApi.ChampionLoader;
import com.lol.analizer.api.championApi.dto.ChampionDto;
import com.lol.analizer.api.platform.Region;
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

	@Test
	public void contextLoads() {
	}

	@Test
	public void getSummonerByNameWorks() throws MalformedURLException {
		Summoner summoner = SummonerApi.getSummonerByName("YULSTER", Region.EUW);
		Assert.assertEquals(summoner.getName(),"YULSTER");
		Assert.assertEquals(summoner.getLevel(),"48");
	}

	@Test
	public void getChampionByNameWorks(){
		ChampionDto championDto = ChampionLoader.loadChampionByName("Caitlyn");
		Assert.assertEquals(championDto.getName(),"Caitlyn");
		Assert.assertEquals(championDto.getTitle(),"the Sheriff of Piltover");
	}

}
