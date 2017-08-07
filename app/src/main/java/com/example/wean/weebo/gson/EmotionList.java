package com.example.wean.weebo.gson;

import java.util.List;

/**
 * Created by Wean on 2017/8/6.
 */

public class EmotionList {
    private List<Emotions> emotions;

    public List<Emotions> getEmotions() {
        return emotions;
    }

    public void setEmotions(List<Emotions> emotions) {
        this.emotions = emotions;
    }

    @Override
    public String toString() {
        return String.valueOf(getEmotions().size());
    }
}
