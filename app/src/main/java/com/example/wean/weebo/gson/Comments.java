package com.example.wean.weebo.gson;

/**
 * Created by Wean on 2017/8/9.
 */

public class Comments {
    private String created_at;

    private long id;

    private long rootid;

    private int floor_number;

    private String text;

    private int source_allowclick;

    private int source_type;

    private String source;

    private User user;

    private String mid;

    private String idstr;

    private Statuses status;

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
    public void setRootid(long rootid){
        this.rootid = rootid;
    }
    public long getRootid(){
        return this.rootid;
    }
    public void setFloor_number(int floor_number){
        this.floor_number = floor_number;
    }
    public int getFloor_number(){
        return this.floor_number;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
    public void setSource_allowclick(int source_allowclick){
        this.source_allowclick = source_allowclick;
    }
    public int getSource_allowclick(){
        return this.source_allowclick;
    }
    public void setSource_type(int source_type){
        this.source_type = source_type;
    }
    public int getSource_type(){
        return this.source_type;
    }
    public void setSource(String source){
        this.source = source;
    }
    public String getSource(){
        return this.source;
    }
    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return this.user;
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
    public void setStatus(Statuses status){
        this.status = status;
    }
    public Statuses getStatus(){
        return this.status;
    }
}
