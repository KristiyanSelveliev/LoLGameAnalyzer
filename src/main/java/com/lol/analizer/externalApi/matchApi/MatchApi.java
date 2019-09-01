package com.lol.analizer.externalApi.matchApi;

import com.lol.analizer.externalApi.ApiConnector;
import com.lol.analizer.externalApi.ApiKey;
import com.lol.analizer.externalApi.exception.NoDataFoundException;
import com.lol.analizer.externalApi.matchApi.dto.MatchDto;
import com.lol.analizer.externalApi.matchApi.dto.MatchListDto;
import com.lol.analizer.externalApi.matchApi.dto.MatchTimelineDto;
import com.lol.analizer.externalApi.gameConstants.Region;
import com.lol.analizer.externalApi.summonerApi.SummonerApi;
import com.lol.analizer.externalApi.summonerApi.dto.SummonerDto;
import lombok.Builder;
import org.springframework.util.CollectionUtils;

import java.net.MalformedURLException;
import java.util.Set;

public class MatchApi {

    public static MatchListDto getMatchListByAccountId(String accountId, Region region, MatchApiParamsHolder paramsHolder) throws MalformedURLException, NoDataFoundException {
        return ApiConnector.callApi("https://" + region.getValue() +
                ".api.riotgames.com/lol/match/v4/matchlists/by-account/"
                + accountId
                + ApiKey.getApiKeyRequestParam()
                + UrlConverter.convertToUrl(paramsHolder), MatchListDto.class);
    }

    public static MatchListDto getMatchListBySummonerName(String summonerName, Region region, MatchApiParamsHolder paramsHolder) throws MalformedURLException, NoDataFoundException {
        SummonerDto summoner = SummonerApi.getSummonerByName(summonerName, region);
        return getMatchListByAccountId(summoner.getAccountId(), region, paramsHolder);
    }

    public static MatchTimelineDto getMatchTimeLineByMatchId(long matchId, Region region) throws MalformedURLException, NoDataFoundException {
        return ApiConnector.callApi("https://" + region.getValue() +
                ".api.riotgames.com/lol/match/v4/timelines/by-match/"
                + matchId
                + ApiKey.getApiKeyRequestParam(), MatchTimelineDto.class);
    }

    public static MatchDto getMatchDtoByMatchId(long matchId, Region region) throws MalformedURLException, NoDataFoundException {
        return ApiConnector.callApi("https://" + region.getValue() +
                ".api.riotgames.com/lol/match/v4/matches/"
                + matchId
                + ApiKey.getApiKeyRequestParam(), MatchDto.class);
    }


    @Builder
    public static class MatchApiParamsHolder{
        private Set <Integer> champions;
        private Set <Integer> queues;
        private Set <Integer> seasons;
        private Long endTime;
        private Long beginTime;
        private Integer endIndex;
        private Integer beginIndex;
    }

    private static class UrlConverter{

        private static String convertToUrl(MatchApiParamsHolder paramsHolder){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(convertSetOfParamsToUrl(paramsHolder.champions, "champion"));
            stringBuilder.append(convertSetOfParamsToUrl(paramsHolder.queues, "queue"));
            stringBuilder.append(convertSetOfParamsToUrl(paramsHolder.seasons, "season"));
            stringBuilder.append(paramsHolder.endTime != null ? "&endTime=" +  paramsHolder.endTime : "");
            stringBuilder.append(paramsHolder.beginTime != null ? "&beginTime=" +  paramsHolder.beginTime : "");
            stringBuilder.append(paramsHolder.endIndex != null ? "&endIndex=" +  paramsHolder.endIndex : "");
            stringBuilder.append(paramsHolder.beginIndex != null ? "&beginIndex=" +  paramsHolder.beginIndex : "");
            return stringBuilder.toString();

        }

        private static String convertSetOfParamsToUrl(Set<Integer> set, String paramKey){
            StringBuilder stringBuilder = new StringBuilder();
            if(!CollectionUtils.isEmpty(set)){
                for(Integer i : set){
                    stringBuilder.append("&" + paramKey+"=" + i);
                }
            }
            return stringBuilder.toString();
        }

    }


}
