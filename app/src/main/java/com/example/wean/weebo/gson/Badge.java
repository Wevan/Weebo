package com.example.wean.weebo.gson;

/**
 * Created by Wean on 2017/8/13.
 */

public class Badge {
    private Kuainv kuainv;

    private int uc_domain;

    private int enterprise;

    private int anniversary;

    public void setKuainv(Kuainv kuainv){
        this.kuainv = kuainv;
    }
    public Kuainv getKuainv(){
        return this.kuainv;
    }
    public void setUc_domain(int uc_domain){
        this.uc_domain = uc_domain;
    }
    public int getUc_domain(){
        return this.uc_domain;
    }
    public void setEnterprise(int enterprise){
        this.enterprise = enterprise;
    }
    public int getEnterprise(){
        return this.enterprise;
    }
    public void setAnniversary(int anniversary){
        this.anniversary = anniversary;
    }
    public int getAnniversary(){
        return this.anniversary;
    }
}
