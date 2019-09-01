package com.lol.analizer.main.summoner.impl;

import com.lol.analizer.main.summoner.ISummonerDao;
import com.lol.analizer.main.summoner.beans.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SummonerDao implements ISummonerDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public SummonerDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveSummoner(Summoner summoner) {
        String sql = " INSERT INTO summoners (name, level, encryptedId, accountId, region)  " +
                     " VALUES (:name, :level, :encId, :accountId, :region)                  ";

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("name",      summoner.getName())
                .addValue("level",     summoner.getLevel())
                .addValue("encId",     summoner.getEncryptedId())
                .addValue("accountId", summoner.getAccountId())
                .addValue("region",    summoner.getRegion().getValue());

        jdbcTemplate.update(sql, sqlParameterSource);
    }

    @Override
    public Summoner loadSummonerByName(String summonerName) {
        return null;
    }

    @Override
    public Summoner loadSummonerByAccountId(String id) {
        return null;
    }
}
