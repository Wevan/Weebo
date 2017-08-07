package com.example.wean.weebo.gson;

/**
 * Created by Wean on 2017/8/6.
 */

public class Emotions {
    private String phrase;

    private String type;

    private String url;

    private boolean hot;

    private boolean common;

    private String category;

    private String icon;

    private String value;

    private String picid;

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return this.phrase;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public boolean getHot() {
        return this.hot;
    }

    public void setCommon(boolean common) {
        this.common = common;
    }

    public boolean getCommon() {
        return this.common;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setPicid(String picid) {
        this.picid = picid;
    }

    public String getPicid() {
        return this.picid;
    }

    @Override
    public String toString() {
        return "Bean [phrase=" + phrase + ", type=" + type + ", url=" + url + ", hot=" + hot + ", common=" + common + ", category=" + category + ", icon=" + icon + ", value=" + value + ", picid=" + picid + "]";
    }
}
