package com.example.wean.weebo.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Wean on 2017/7/7.
 */

public class User {
    private long id;

    private String idstr;

    private int classn;

    private String screen_name;

    private String name;

    private String province;

    private String city;

    private String location;

    private String description;

    private String url;

    private String profile_image_url;

    private String cover_image;

    private String cover_image_phone;

    private String profile_url;

    private String domain;

    private String weihao;

    private String gender;

    private int followers_count;

    private int friends_count;

    private int pagefriends_count;

    private int statuses_count;

    private int favourites_count;

    private String created_at;

    private boolean following;

    private boolean allow_all_act_msg;

    private boolean geo_enabled;

    private boolean verified;

    private int verified_type;

    private String remark;

    private Insecurity insecurity;

    private int ptype;

    private boolean allow_all_comment;

    private String avatar_large;

    private String avatar_hd;

    private String verified_reason;

    private String verified_trade;

    private String verified_reason_url;

    private String verified_source;

    private String verified_source_url;

    private int verified_state;

    private int verified_level;

    private int verified_type_ext;

    private boolean has_service_tel;

    private String verified_reason_modified;

    private String verified_contact_name;

    private String verified_contact_email;

    private String verified_contact_mobile;

    private boolean follow_me;

    private int online_status;

    private int bi_followers_count;

    private String lang;

    private int star;

    private int mbtype;

    private int mbrank;

    private int block_word;

    private int block_app;

    private int credit_score;

    private int user_ability;

    private int urank;

    private int story_read_state;

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
    }
    public void setIdstr(String idstr){
        this.idstr = idstr;
    }
    public String getIdstr(){
        return this.idstr;
    }

    @SerializedName("class")
    public void setClass(int classn){
        this.classn = classn;
    }

    public int getClassn() {
        return classn;
    }

    public void setScreen_name(String screen_name){
        this.screen_name = screen_name;
    }
    public String getScreen_name(){
        return this.screen_name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setProvince(String province){
        this.province = province;
    }
    public String getProvince(){
        return this.province;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return this.location;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }
    public void setProfile_image_url(String profile_image_url){
        this.profile_image_url = profile_image_url;
    }
    public String getProfile_image_url(){
        return this.profile_image_url;
    }
    public void setCover_image(String cover_image){
        this.cover_image = cover_image;
    }
    public String getCover_image(){
        return this.cover_image;
    }
    public void setCover_image_phone(String cover_image_phone){
        this.cover_image_phone = cover_image_phone;
    }
    public String getCover_image_phone(){
        return this.cover_image_phone;
    }
    public void setProfile_url(String profile_url){
        this.profile_url = profile_url;
    }
    public String getProfile_url(){
        return this.profile_url;
    }
    public void setDomain(String domain){
        this.domain = domain;
    }
    public String getDomain(){
        return this.domain;
    }
    public void setWeihao(String weihao){
        this.weihao = weihao;
    }
    public String getWeihao(){
        return this.weihao;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }
    public void setFollowers_count(int followers_count){
        this.followers_count = followers_count;
    }
    public String getFollowers_count(){
        return String.valueOf(this.followers_count);
    }
    public void setFriends_count(int friends_count){
        this.friends_count = friends_count;
    }
    public String getFriends_count(){
        return String.valueOf(this.friends_count);
    }
    public void setPagefriends_count(int pagefriends_count){
        this.pagefriends_count = pagefriends_count;
    }
    public int getPagefriends_count(){
        return this.pagefriends_count;
    }
    public void setStatuses_count(int statuses_count){
        this.statuses_count = statuses_count;
    }
    public String getStatuses_count(){
        return String.valueOf(this.statuses_count);
    }
    public void setFavourites_count(int favourites_count){
        this.favourites_count = favourites_count;
    }
    public int getFavourites_count(){
        return this.favourites_count;
    }
    public void setCreated_at(String created_at){
        this.created_at = created_at;
    }
    public String getCreated_at(){
        return this.created_at;
    }
    public void setFollowing(boolean following){
        this.following = following;
    }
    public boolean getFollowing(){
        return this.following;
    }
    public void setAllow_all_act_msg(boolean allow_all_act_msg){
        this.allow_all_act_msg = allow_all_act_msg;
    }
    public boolean getAllow_all_act_msg(){
        return this.allow_all_act_msg;
    }
    public void setGeo_enabled(boolean geo_enabled){
        this.geo_enabled = geo_enabled;
    }
    public boolean getGeo_enabled(){
        return this.geo_enabled;
    }
    public void setVerified(boolean verified){
        this.verified = verified;
    }
    public boolean getVerified(){
        return this.verified;
    }
    public void setVerified_type(int verified_type){
        this.verified_type = verified_type;
    }
    public int getVerified_type(){
        return this.verified_type;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }
    public String getRemark(){
        return this.remark;
    }
    public void setInsecurity(Insecurity insecurity){
        this.insecurity = insecurity;
    }
    public Insecurity getInsecurity(){
        return this.insecurity;
    }
    public void setPtype(int ptype){
        this.ptype = ptype;
    }
    public int getPtype(){
        return this.ptype;
    }
    public void setAllow_all_comment(boolean allow_all_comment){
        this.allow_all_comment = allow_all_comment;
    }
    public boolean getAllow_all_comment(){
        return this.allow_all_comment;
    }
    public void setAvatar_large(String avatar_large){
        this.avatar_large = avatar_large;
    }
    public String getAvatar_large(){
        return this.avatar_large;
    }
    public void setAvatar_hd(String avatar_hd){
        this.avatar_hd = avatar_hd;
    }
    public String getAvatar_hd(){
        return this.avatar_hd;
    }
    public void setVerified_reason(String verified_reason){
        this.verified_reason = verified_reason;
    }
    public String getVerified_reason(){
        return this.verified_reason;
    }
    public void setVerified_trade(String verified_trade){
        this.verified_trade = verified_trade;
    }
    public String getVerified_trade(){
        return this.verified_trade;
    }
    public void setVerified_reason_url(String verified_reason_url){
        this.verified_reason_url = verified_reason_url;
    }
    public String getVerified_reason_url(){
        return this.verified_reason_url;
    }
    public void setVerified_source(String verified_source){
        this.verified_source = verified_source;
    }
    public String getVerified_source(){
        return this.verified_source;
    }
    public void setVerified_source_url(String verified_source_url){
        this.verified_source_url = verified_source_url;
    }
    public String getVerified_source_url(){
        return this.verified_source_url;
    }
    public void setVerified_state(int verified_state){
        this.verified_state = verified_state;
    }
    public int getVerified_state(){
        return this.verified_state;
    }
    public void setVerified_level(int verified_level){
        this.verified_level = verified_level;
    }
    public int getVerified_level(){
        return this.verified_level;
    }
    public void setVerified_type_ext(int verified_type_ext){
        this.verified_type_ext = verified_type_ext;
    }
    public int getVerified_type_ext(){
        return this.verified_type_ext;
    }
    public void setHas_service_tel(boolean has_service_tel){
        this.has_service_tel = has_service_tel;
    }
    public boolean getHas_service_tel(){
        return this.has_service_tel;
    }
    public void setVerified_reason_modified(String verified_reason_modified){
        this.verified_reason_modified = verified_reason_modified;
    }
    public String getVerified_reason_modified(){
        return this.verified_reason_modified;
    }
    public void setVerified_contact_name(String verified_contact_name){
        this.verified_contact_name = verified_contact_name;
    }
    public String getVerified_contact_name(){
        return this.verified_contact_name;
    }
    public void setVerified_contact_email(String verified_contact_email){
        this.verified_contact_email = verified_contact_email;
    }
    public String getVerified_contact_email(){
        return this.verified_contact_email;
    }
    public void setVerified_contact_mobile(String verified_contact_mobile){
        this.verified_contact_mobile = verified_contact_mobile;
    }
    public String getVerified_contact_mobile(){
        return this.verified_contact_mobile;
    }
    public void setFollow_me(boolean follow_me){
        this.follow_me = follow_me;
    }
    public boolean getFollow_me(){
        return this.follow_me;
    }
    public void setOnline_status(int online_status){
        this.online_status = online_status;
    }
    public int getOnline_status(){
        return this.online_status;
    }
    public void setBi_followers_count(int bi_followers_count){
        this.bi_followers_count = bi_followers_count;
    }
    public int getBi_followers_count(){
        return this.bi_followers_count;
    }
    public void setLang(String lang){
        this.lang = lang;
    }
    public String getLang(){
        return this.lang;
    }
    public void setStar(int star){
        this.star = star;
    }
    public int getStar(){
        return this.star;
    }
    public void setMbtype(int mbtype){
        this.mbtype = mbtype;
    }
    public int getMbtype(){
        return this.mbtype;
    }
    public void setMbrank(int mbrank){
        this.mbrank = mbrank;
    }
    public int getMbrank(){
        return this.mbrank;
    }
    public void setBlock_word(int block_word){
        this.block_word = block_word;
    }
    public int getBlock_word(){
        return this.block_word;
    }
    public void setBlock_app(int block_app){
        this.block_app = block_app;
    }
    public int getBlock_app(){
        return this.block_app;
    }
    public void setCredit_score(int credit_score){
        this.credit_score = credit_score;
    }
    public int getCredit_score(){
        return this.credit_score;
    }
    public void setUser_ability(int user_ability){
        this.user_ability = user_ability;
    }
    public int getUser_ability(){
        return this.user_ability;
    }
    public void setUrank(int urank){
        this.urank = urank;
    }
    public int getUrank(){
        return this.urank;
    }
    public void setStory_read_state(int story_read_state){
        this.story_read_state = story_read_state;
    }
    public int getStory_read_state(){
        return this.story_read_state;
    }

}
