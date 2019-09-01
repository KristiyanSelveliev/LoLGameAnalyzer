package com.lol.analizer.externalApi.matchApi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatchTimelineDto {

    List<MatchFrameDto> frames;
    long frameInterval;

}
