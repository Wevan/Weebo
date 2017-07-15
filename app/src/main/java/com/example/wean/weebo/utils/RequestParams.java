package com.example.wean.weebo.utils;

import java.util.Map;

/**
 * Created by Wean on 2017/7/13.
 */

public class RequestParams {

    public String  put(String key,String rep){
        String url="https://api.weibo.com/oauth2/authorize?client_id="+key+"&response_type=code&redirect_uri="+rep;
        return url;
    }
    public String get(String key,String secret,String rep,String code){
        String url="https://api.weibo.com/oauth2/access_token?client_id="+key+"&client_secret="+secret+"&grant_type=authorization_code&redirect_uri="+rep+"&code="+code;
        return url;
    }

}
