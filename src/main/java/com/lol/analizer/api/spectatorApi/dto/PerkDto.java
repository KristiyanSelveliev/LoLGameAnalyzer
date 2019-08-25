package com.lol.analizer.api.spectatorApi.dto;

import java.util.List;

public class PerkDto {

   private String perkStyle;
   private List<String> perkIds;
   private String perkSubStyle;

    public String getPerkStyle() {
        return perkStyle;
    }

    public void setPerkStyle(String perkStyle) {
        this.perkStyle = perkStyle;
    }

    public List<String> getPerkIds() {
        return perkIds;
    }

    public void setPerkIds(List<String> perkIds) {
        this.perkIds = perkIds;
    }

    public String getPerkSubStyle() {
        return perkSubStyle;
    }

    public void setPerkSubStyle(String perkSubStyle) {
        this.perkSubStyle = perkSubStyle;
    }
}
