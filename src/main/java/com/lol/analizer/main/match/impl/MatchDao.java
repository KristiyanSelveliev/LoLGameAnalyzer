package com.lol.analizer.main.match.impl;

import com.lol.analizer.main.match.IMatchDao;
import com.lol.analizer.main.match.beans.Match;
import com.lol.analizer.main.match.beans.SummonerMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class MatchDao implements IMatchDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MatchDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveMatch(Match match) {
        String sql =   " INSERT INTO matches (match_id, season, patch, region, gameMode, mapId, gameType, gameDuration, gameCreation)     " +
                       " SELECT :match_id, :season, :patch, :region, :gameMode, :mapId, :gameType, :gameDuration, :gameCreation from dual " +
                       " WHERE NOT EXISTS (SELECT * FROM matches s                                                                        " +
                       "         WHERE s.match_id = :match_id                                                                             " +
                       "         AND s.region = :region                                                                                   " +
                       "         AND s.season = :season                                                                                   " +
                       "         LIMIT 1)                                                                                                 ";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("match_id"    , match.getMatchId())
                .addValue("season"      , match.getSeason())
                .addValue("patch"       , match.getPatch())
                .addValue("region"      , match.getRegion())
                .addValue("gameMode"    , match.getGameMode())
                .addValue("mapId"       , match.getMap().getId())
                .addValue("gameType"    , match.getGameType())
                .addValue("gameDuration", match.getGameDuration())
                .addValue("gameCreation", match.getGameCreation());

        jdbcTemplate.update(sql, sqlParameterSource);
    }

    @Override
    public void saveSummonerMatch(SummonerMatch summonerMatch) {
        String sql =   " INSERT INTO summoners_matches (match_id, accountId, lane, region, season, queue, role, timestamp, championId) " +
                       " SELECT :match_id, :account_id, :lane, :region, :season, :queue, :role, :timestamp, :championId from dual      " +
                       " WHERE NOT EXISTS (SELECT * FROM summoners_matches s                                                           " +
                       "         WHERE s.match_id = :match_id                                                                          " +
                       "         AND s.accountId = :account_id                                                                         " +
                       "         AND s.region = :region                                                                                " +
                       "         AND s.season = :season                                                                                " +
                       "         LIMIT 1)                                                                                              ";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("match_id"  , summonerMatch.getMatchId())
                .addValue("account_id", summonerMatch.getAccountId())
                .addValue("lane"      , summonerMatch.getLane())
                .addValue("region"    , summonerMatch.getRegion())
                .addValue("season"    , summonerMatch.getSeason())
                .addValue("queue"     , summonerMatch.getQueue())
                .addValue("role"      , summonerMatch.getRole())
                .addValue("timestamp" , summonerMatch.getTimestamp())
                .addValue("championId", summonerMatch.getChampionId());

        jdbcTemplate.update(sql, sqlParameterSource);
    }
}
