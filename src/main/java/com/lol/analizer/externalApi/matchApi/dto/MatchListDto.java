package com.lol.analizer.externalApi.matchApi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatchListDto {

  	private List <MatchReferenceDto> matches;
    private int totalGames;
    private int startIndex;
    private int endIndex;

}
