package com.example.wean.weebo.gson;

import java.util.List;

/**
 * Created by Wean on 2017/7/7.
 */

public class Root {
    private List<Statuses> statuses ;

    private List<Advertises> advertises ;

    private List<Ad> ad ;

    private boolean hasvisible;

    private int previous_cursor;

    private int next_cursor;

    private int total_number;

    private int interval;

    private int uve_blank;

    private int since_id;

    private int max_id;

    private int has_unread;

    public void setStatuses(List<Statuses> statuses){
        this.statuses = statuses;
    }
    public List<Statuses> getStatuses(){
        return this.statuses;
    }
    public void setAdvertises(List<Advertises> advertises){
        this.advertises = advertises;
    }
    public List<Advertises> getAdvertises(){
        return this.advertises;
    }
    public void setAd(List<Ad> ad){
        this.ad = ad;
    }
    public List<Ad> getAd(){
        return this.ad;
    }
    public void setHasvisible(boolean hasvisible){
        this.hasvisible = hasvisible;
    }
    public boolean getHasvisible(){
        return this.hasvisible;
    }
    public void setPrevious_cursor(int previous_cursor){
        this.previous_cursor = previous_cursor;
    }
    public int getPrevious_cursor(){
        return this.previous_cursor;
    }
    public void setNext_cursor(int next_cursor){
        this.next_cursor = next_cursor;
    }
    public int getNext_cursor(){
        return this.next_cursor;
    }
    public void setTotal_number(int total_number){
        this.total_number = total_number;
    }
    public int getTotal_number(){
        return this.total_number;
    }
    public void setInterval(int interval){
        this.interval = interval;
    }
    public int getInterval(){
        return this.interval;
    }
    public void setUve_blank(int uve_blank){
        this.uve_blank = uve_blank;
    }
    public int getUve_blank(){
        return this.uve_blank;
    }
    public void setSince_id(int since_id){
        this.since_id = since_id;
    }
    public int getSince_id(){
        return this.since_id;
    }
    public void setMax_id(int max_id){
        this.max_id = max_id;
    }
    public int getMax_id(){
        return this.max_id;
    }
    public void setHas_unread(int has_unread){
        this.has_unread = has_unread;
    }
    public int getHas_unread(){
        return this.has_unread;
    }
}
