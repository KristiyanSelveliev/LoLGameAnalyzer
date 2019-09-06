package com.lol.analizer.externalApi.gameConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

@Getter
@AllArgsConstructor
public enum Map {

        SUMMONERS_RIFT_SUMMER    (1),
        SUMMONERS_RIFT_AUTUMN    (2),
        THE_PROVING_GROUNDS      (3),
        TWISTED_TREELINE_ORIGINAL(4)	,
        THE_CRYSTAL_SCAR         (8),
        TWISTED_TREELINE_CURRENT (10),
        SUMMONERS_RIFT_CURRENT   (11),
        HOWLING_ABYSS            (12),
        BUTCHERS_BRIDGE          (14),
        COSMIC_RUINS             (16),
        VALORAN_CITY_PARK        (18),
        SUBSTRUCTURE             (19),
        CRASH_SITE	             (20),
        NEXUS_BLITZ	             (21);

        private int id;

        private static final HashMap<Integer, Map> typesByValue = new HashMap<Integer, Map>();

        static {
                for (Map type : Map.values()) {
                        typesByValue.put(type.id, type);
                }
        }

        public static Map forValue(int value) {
                return typesByValue.get(value);
        }

}
