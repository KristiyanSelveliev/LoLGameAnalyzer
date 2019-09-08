package com.lol.analizer.main.champion.impl;

import com.lol.analizer.externalApi.championApi.dto.ChampionDto;
import com.lol.analizer.externalApi.gameConstants.ChampionRole;
import com.lol.analizer.main.champion.IChampionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ChampionDao implements IChampionDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ChampionDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getAllChampionsCount() {
        String sql = " SELECT count(*) from champions ";
        return jdbcTemplate.queryForObject(sql, new MapSqlParameterSource(), Integer.class);
    }

    @Override
    public void insertChampion(ChampionDto champion) {
            String sql = " INSERT INTO champions (champion_id, `version`, `key`, `name`, `title`, attack, defense, magic, difficulty)   " +
                         " SELECT :champion_id,:version, :key, :name, :title, :attack, :defense, :magic, :difficulty from dual            " +
                         " WHERE NOT EXISTS (SELECT * FROM champions c                                                                    " +
                         "         WHERE c.name = :name                                                                                   " +
                         "         AND c.champion_id = :champion_id                                                                       " +
                         "         LIMIT 1)                                                                                               ";

            SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                    .addValue("champion_id", champion.getId())
                    .addValue("version", champion.getVersion())
                    .addValue("key", champion.getKey())
                    .addValue("name", champion.getName())
                    .addValue("title", champion.getTitle())
                    .addValue("attack", champion.getInfo().getAttack())
                    .addValue("defense", champion.getInfo().getDefense())
                    .addValue("magic", champion.getInfo().getMagic())
                    .addValue("difficulty", champion.getInfo().getDifficulty());

            jdbcTemplate.update(sql, sqlParameterSource);
    }

    @Override
    public void insertChampionRole(ChampionRole championRole) {
         String sql =  " INSERT INTO champroles (name)                                        " +
                       " SELECT :name from dual                                               " +
                       " WHERE NOT EXISTS (SELECT * FROM champroles c                         " +
                       "         WHERE c.name = :name                                         " +
                       "         LIMIT 1)                                                     ";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("name", championRole.getValue());
        jdbcTemplate.update(sql, sqlParameterSource);
    }

    @Override
    public int getAllChampionRolesCount() {
        String sql = " SELECT count(*) from champroles ";
        return jdbcTemplate.queryForObject(sql, new MapSqlParameterSource(), Integer.class);
    }

    @Override
    public void insertRoleForChampion(String championId, String role) {
        String sql = " INSERT INTO champions_roles (champion_id, role_id)                   " +
                     " SELECT :champion_id, role_id from champroles  c                      " +
                     "         WHERE c.name = :name                                         " +
                     "         LIMIT 1                                                      ";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("champion_id", championId)
                .addValue("name", role);

        jdbcTemplate.update(sql, sqlParameterSource);
    }
}
