package com.lol.analizer.api.gameConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChampionRole {

    FIGHTER  ("Fighter"),
    TANK     ("Tank"),
    MAGE     ("Mage"),
    ASSASSIN ("Assassin"),
    SUPPORT  ("Support"),
    MARKSMAN ("Marksman");

    private String value;



}
