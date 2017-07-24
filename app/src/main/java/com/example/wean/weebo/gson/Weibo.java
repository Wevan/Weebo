package com.example.wean.weebo.gson;

import java.util.List;

/**
 * Created by Wean on 2017/7/21.
 */

public class Weibo {
    private List<Statuses> statuses;

    public List<Statuses> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Statuses> statuses) {
        this.statuses = statuses;
    }
}
