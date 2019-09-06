package com.lol.analizer.main.summoner;

import com.lol.analizer.main.summoner.beans.Summoner;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SummonerMapper implements RowMapper<Summoner> {
    @Override
    public Summoner mapRow(ResultSet resultSet, int i) throws SQLException {
        Summoner summoner = new Summoner();
        summoner.setSummonerId(resultSet.getString("summoner_id"));
        summoner.setName(resultSet.getString("name"));
        summoner.setLevel(resultSet.getInt("level"));
        summoner.setEncryptedId(resultSet.getString("encryptedId"));
        summoner.setAccountId(resultSet.getString("accountId"));
        summoner.setRegion(resultSet.getString("region"));
        return summoner;
    }
}
