package com.lol.analizer.api.gameConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Rank {

    CHALLENGER("CHALLENGER"),
    MASTER    ("MASTER"),
    DIAMOND   ("DIAMOND"),
    PLATINUM  ("PLATINUM"),
    GOLD      ("GOLD"),
    SILVER    ("SILVER"),
    BRONZE    ("BRONZE"),
    IRON      ("IRON"),
    UNRANKED  ("UNRANKED");

    private String value;


}
