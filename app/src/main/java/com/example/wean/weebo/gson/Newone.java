package com.example.wean.weebo.gson;

/**
 * Created by Wean on 2017/8/13.
 */

public class Newone {
    private String created_at;

    private long id;

    private String mid;

    private String idstr;

    private String text;

    private String source;

    private boolean favorited;

    private boolean truncated;

    private String in_reply_to_status_id;

    private String in_reply_to_user_id;

    private String in_reply_to_screen_name;

    private String thumbnail_pic;

    private String bmiddle_pic;

    private String original_pic;

    private Geo geo;

    private User user;

    private int reposts_count;

    private int comments_count;

    private int attitudes_count;

    private int mlevel;

    private Visible visible;

    public void setCreated_at(String created_at){
        this.created_at = created_at;
    }
    public String getCreated_at(){
        return this.created_at;
    }
    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
    }
    public void setMid(String mid){
        this.mid = mid;
    }
    public String getMid(){
        return this.mid;
    }
    public void setIdstr(String idstr){
        this.idstr = idstr;
    }
    public String getIdstr(){
        return this.idstr;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
    public void setSource(String source){
        this.source = source;
    }
    public String getSource(){
        return this.source;
    }
    public void setFavorited(boolean favorited){
        this.favorited = favorited;
    }
    public boolean getFavorited(){
        return this.favorited;
    }
    public void setTruncated(boolean truncated){
        this.truncated = truncated;
    }
    public boolean getTruncated(){
        return this.truncated;
    }
    public void setIn_reply_to_status_id(String in_reply_to_status_id){
        this.in_reply_to_status_id = in_reply_to_status_id;
    }
    public String getIn_reply_to_status_id(){
        return this.in_reply_to_status_id;
    }
    public void setIn_reply_to_user_id(String in_reply_to_user_id){
        this.in_reply_to_user_id = in_reply_to_user_id;
    }
    public String getIn_reply_to_user_id(){
        return this.in_reply_to_user_id;
    }
    public void setIn_reply_to_screen_name(String in_reply_to_screen_name){
        this.in_reply_to_screen_name = in_reply_to_screen_name;
    }
    public String getIn_reply_to_screen_name(){
        return this.in_reply_to_screen_name;
    }
    public void setThumbnail_pic(String thumbnail_pic){
        this.thumbnail_pic = thumbnail_pic;
    }
    public String getThumbnail_pic(){
        return this.thumbnail_pic;
    }
    public void setBmiddle_pic(String bmiddle_pic){
        this.bmiddle_pic = bmiddle_pic;
    }
    public String getBmiddle_pic(){
        return this.bmiddle_pic;
    }
    public void setOriginal_pic(String original_pic){
        this.original_pic = original_pic;
    }
    public String getOriginal_pic(){
        return this.original_pic;
    }
    public void setGeo(Geo geo){
        this.geo = geo;
    }
    public Geo getGeo(){
        return this.geo;
    }
    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return this.user;
    }
    public void setReposts_count(int reposts_count){
        this.reposts_count = reposts_count;
    }
    public int getReposts_count(){
        return this.reposts_count;
    }
    public void setComments_count(int comments_count){
        this.comments_count = comments_count;
    }
    public int getComments_count(){
        return this.comments_count;
    }
    public void setAttitudes_count(int attitudes_count){
        this.attitudes_count = attitudes_count;
    }
    public int getAttitudes_count(){
        return this.attitudes_count;
    }
    public void setMlevel(int mlevel){
        this.mlevel = mlevel;
    }
    public int getMlevel(){
        return this.mlevel;
    }
    public void setVisible(Visible visible){
        this.visible = visible;
    }
    public Visible getVisible(){
        return this.visible;
    }
}
