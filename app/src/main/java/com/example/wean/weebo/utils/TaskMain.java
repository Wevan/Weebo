package com.example.wean.weebo.utils;

import com.example.wean.weebo.gson.Emotions;

import java.util.List;

/**
 * Created by Wean on 2017/8/7.
 */

public class TaskMain {
    private static final String URL = "https://api.weibo.com/2/emotions.json?access_token=2.00vIfl4Ckfii3Ee2e47afc7axUu3oD";
    private static String mJsonInfo;

    public static void main(String[] args) {
        HelpUtils helpUtils = new HelpUtils();
        // 获取Json数据
        mJsonInfo = helpUtils.getHttpString(URL);
        // 将Json数据反序列化成java对象
        List<Emotions> beans = helpUtils.changeJsonToList(mJsonInfo);
        //循环遍历下载图片
        for (int i = 0; i < beans.size(); i++) {
            helpUtils.makeImage(beans.get(i), "C:/Users/Wean/Desktop/pic/");
        }

    }
}

