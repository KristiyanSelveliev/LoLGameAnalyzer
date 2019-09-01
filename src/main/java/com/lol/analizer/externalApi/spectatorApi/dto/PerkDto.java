package com.lol.analizer.externalApi.spectatorApi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PerkDto {

   private long perkStyle;
   private List<Long> perkIds;
   private long perkSubStyle;

}
