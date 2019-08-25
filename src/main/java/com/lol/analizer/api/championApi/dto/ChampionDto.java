package com.lol.analizer.api.championApi.dto;

public class ChampionDto {

    private String version;
    private String id;
    private String key;
    private String name;
    private String title;
    private String blurb;
    private ChampionInfoDto info;
    private String [] tags;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public ChampionInfoDto getInfo() {
        return info;
    }

    public void setInfo(ChampionInfoDto info) {
        this.info = info;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
