package com.lol.analizer.main.champion.impl;

import com.lol.analizer.externalApi.championApi.dto.ChampionDto;
import com.lol.analizer.externalApi.gameConstants.ChampionRole;
import com.lol.analizer.main.champion.IChampionDao;
import com.lol.analizer.main.champion.IChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChampionServiceImpl implements IChampionService {

    private IChampionDao championDao;

    @Autowired
    public ChampionServiceImpl(IChampionDao championDao) {
        this.championDao = championDao;
    }

    @Override
    public int getAllChampionsCount() {
       return championDao.getAllChampionsCount();
    }

    @Override
    public int getAllChampionRolesCount() {
        return championDao.getAllChampionRolesCount();
    }

    @Override
    @Transactional
    public void insertChampion(ChampionDto champion) {
        championDao.insertChampion(champion);
    }

    @Override
    @Transactional
    public void insertChampions(List<ChampionDto> champions) {
       for(ChampionDto champion : champions){
           insertChampion(champion);
           for(String role : champion.getTags()){
               championDao.insertRoleForChampion(champion.getId(), role);
           }
       }
    }

    @Override
    @Transactional
    public void insertChampionRoles(ChampionRole[] roles) {
        for(ChampionRole role : roles){
            championDao.insertChampionRole(role);
        }
    }
}
