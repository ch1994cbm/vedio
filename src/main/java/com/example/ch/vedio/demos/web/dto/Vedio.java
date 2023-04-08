package com.example.ch.vedio.demos.web.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vedio implements Serializable {

    private String bv;
    private String title;
    private LocalDateTime publishTime;
    private String cover;
    private String introduction;
    private String tags;
    private List<String> tagList;
    private List<Play> playList;

    private String type;
    private String category;

    public Vedio(String bv, String title, LocalDateTime publishTime, String cover, String introduction, List<String> tagList, List<Play> playList) {
        this.bv = bv;
        this.title = title;
        this.publishTime = publishTime;
        this.cover = cover;
        this.introduction = introduction;
        this.tagList = tagList;
        this.playList = playList;
    }

    public Vedio() {
    }

    @Override
    public String toString() {
        return "Vedio{" +
                "bv='" + bv + '\'' +
                ", title='" + title + '\'' +
                ", publishTime=" + publishTime +
                ", cover='" + cover + '\'' +
                ", introduction='" + introduction + '\'' +
                ", tagList=" + tagList +
                ", playList=" + playList +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public List<Play> getPlayList() {
        return playList;
    }

    public void setPlayList(List<Play> playList) {
        this.playList = playList;
    }

    public String getBv() {
        return bv;
    }

    public void setBv(String bv) {
        this.bv = bv;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<String> getTagList() {
        if(tags == null){
            return new ArrayList<>();
        }
        String tags = this.tags;
        String[] s = tags.split("_");
        return Arrays.asList(s);
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }
}
