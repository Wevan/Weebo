package com.example.wean.weebo.gson;

import java.util.List;

/**
 * Created by Wean on 2017/8/9.
 */

public class GetComts {
    private List<Comments> comments ;

    private List<Marks> marks ;

    private boolean hasvisible;

    private int previous_cursor;

    private long next_cursor;

    private int total_number;

    private int since_id;

    private long max_id;

    private Statuses status;

    public void setComments(List<Comments> comments){
        this.comments = comments;
    }
    public List<Comments> getComments(){
        return this.comments;
    }
    public void setMarks(List<Marks> marks){
        this.marks = marks;
    }
    public List<Marks> getMarks(){
        return this.marks;
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
    public void setNext_cursor(long next_cursor){
        this.next_cursor = next_cursor;
    }
    public long getNext_cursor(){
        return this.next_cursor;
    }
    public void setTotal_number(int total_number){
        this.total_number = total_number;
    }
    public int getTotal_number(){
        return this.total_number;
    }
    public void setSince_id(int since_id){
        this.since_id = since_id;
    }
    public int getSince_id(){
        return this.since_id;
    }
    public void setMax_id(long max_id){
        this.max_id = max_id;
    }
    public long getMax_id(){
        return this.max_id;
    }
    public void setStatus(Statuses status){
        this.status = status;
    }
    public Statuses getStatus(){
        return this.status;
    }

}
