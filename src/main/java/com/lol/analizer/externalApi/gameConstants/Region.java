package com.lol.analizer.externalApi.gameConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

@Getter
@AllArgsConstructor
public enum Region {

           RU   ("ru"),
           KR   ("kr"),
           JP   ("jp1"),
           NA   ("na1"),
           EUNE ("eun1"),
           EUW  ("euw1"),
           TR   ("tr1"),
           LA1  ("la1"),
           LA2  ("la2");

    private final String value;

}
