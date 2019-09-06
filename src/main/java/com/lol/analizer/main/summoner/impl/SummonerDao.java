package com.lol.analizer.main.summoner.impl;

import com.lol.analizer.externalApi.gameConstants.Region;
import com.lol.analizer.main.summoner.ISummonerDao;
import com.lol.analizer.main.summoner.SummonerMapper;
import com.lol.analizer.main.summoner.beans.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

      String sql =
        " INSERT INTO summoners (name, level, encryptedId, accountId, region)  " +
        " SELECT :name, :level, :encId, :accountId, :region from dual          " +
        " WHERE NOT EXISTS (SELECT * FROM summoners s                          " +
        "         WHERE s.name = :name                                         " +
        "         AND s.accountId = :accountId                                 " +
        "         AND s.region = :region                                       " +
        "         LIMIT 1)                                                     ";

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("name",      summoner.getName())
                .addValue("level",     summoner.getLevel())
                .addValue("encId",     summoner.getEncryptedId())
                .addValue("accountId", summoner.getAccountId())
                .addValue("region",    summoner.getRegion());

        jdbcTemplate.update(sql, sqlParameterSource);
    }

    @Override
    public Summoner loadSummonerByName(String summonerName, Region region) {

        String sql = "  SELECT s.summoner_id, s.name, s.level, s.encryptedId, s.accountId, s.region FROM summoners s " +
                     "  WHERE name = :name                                                                           " +
                     "  AND region = :region                                                                         ";

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("name", summonerName)
                .addValue("region", region.getValue());

        try {
            return jdbcTemplate.queryForObject(sql, sqlParameterSource, new SummonerMapper());
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public Summoner loadSummonerByAccountId(String accountId, Region region) {

        String sql = "  SELECT s.summoner_id, s.name, s.level, s.encryptedId, s.accountId, s.region FROM summoners s " +
                     "  WHERE accountId = :accountId                                                                 " +
                     "  AND region = :region                                                                         ";

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("accountId", accountId)
                .addValue("region", region.getValue());

        try {
            return jdbcTemplate.queryForObject(sql, sqlParameterSource, new SummonerMapper());
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

}
