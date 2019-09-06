package com.lol.analizer.main.match;

import com.lol.analizer.externalApi.gameConstants.Map;
import com.lol.analizer.externalApi.gameConstants.Region;
import com.lol.analizer.externalApi.matchApi.dto.MatchDto;
import com.lol.analizer.externalApi.matchApi.dto.MatchReferenceDto;
import com.lol.analizer.main.match.beans.Match;
import com.lol.analizer.main.match.beans.SummonerMatch;

public class MatchConverter {

    public static SummonerMatch convertToSummonerMatch(MatchReferenceDto matchReferenceDto, String accountId){
        return SummonerMatch.builder()
                .accountId(accountId)
                .championId(matchReferenceDto.getChampion())
                .matchId(matchReferenceDto.getGameId())
                .lane(matchReferenceDto.getLane())
                .queue(matchReferenceDto.getQueue())
                .region(matchReferenceDto.getPlatformId())
                .role(matchReferenceDto.getRole())
                .season(matchReferenceDto.getSeason())
                .timestamp(matchReferenceDto.getTimestamp())
                .build();
    }

    public static Match convertToMatch(MatchDto matchDto){
       return Match.builder()
              .matchId(matchDto.getGameId())
              .map(Map.forValue(matchDto.getMapId()))
              .gameCreation(matchDto.getGameCreation())
              .gameDuration(matchDto.getGameDuration())
              .region(matchDto.getPlatformId())
              .gameMode(matchDto.getGameMode())
              .gameType(matchDto.getGameType())
              .season(matchDto.getSeasonId())
              .patch(matchDto.getGameVersion())
              .build();
    }
}
