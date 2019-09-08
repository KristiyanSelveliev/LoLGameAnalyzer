package com.lol.analizer.main.champion;

import com.lol.analizer.externalApi.championApi.ChampionPool;
import com.lol.analizer.externalApi.gameConstants.ChampionRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ChampionPoolLoader implements ApplicationListener<ContextRefreshedEvent> {

    private IChampionService championService;

    @Autowired
    public ChampionPoolLoader(IChampionService championService) {
        this.championService = championService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
      if(ChampionPool.isNotLoaded()){
          ChampionPool.loadChampions();
      }

      if(championService.getAllChampionRolesCount() != ChampionRole.values().length){
          championService.insertChampionRoles(ChampionRole.values());
      }

      if(championService.getAllChampionsCount() != ChampionPool.size()) {
          championService.insertChampions(ChampionPool.getAllChampions());
      }
    }
}
