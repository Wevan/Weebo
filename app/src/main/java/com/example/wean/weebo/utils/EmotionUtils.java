package com.example.wean.weebo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.wean.weebo.Inter.Constants;
import com.example.wean.weebo.R;
import com.example.wean.weebo.gson.EmotionList;
import com.example.wean.weebo.gson.Emotions;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Wean on 2017/8/6.
 */

public class EmotionUtils {
//    public static Map<String, String> emojiMap;
    private static List<Emotions> emotionsList;
    private static String test="meiyou";

    public static Map<String, Integer> emojiMap;
    static {
        emojiMap = new HashMap<String, Integer>();
        emojiMap.put("[微笑]", R.drawable.d_hehe);
        emojiMap.put("[呵呵]", R.drawable.d_hehe);
        emojiMap.put("[嘻嘻]", R.drawable.d_xixi);
        emojiMap.put("[哈哈]", R.drawable.d_haha);
        emojiMap.put("[爱你]", R.drawable.d_aini);
        emojiMap.put("[挖鼻屎]", R.drawable.d_wabishi);
        emojiMap.put("[吃惊]", R.drawable.d_chijing);
        emojiMap.put("[晕]", R.drawable.d_yun);
        emojiMap.put("[馋嘴]", R.drawable.d_chanzui);
        emojiMap.put("[抓狂]", R.drawable.d_zhuakuang);
        emojiMap.put("[哼]", R.drawable.d_heng);
        emojiMap.put("[可爱]", R.drawable.d_keai);
        emojiMap.put("[怒]", R.drawable.d_nu);
        emojiMap.put("[害羞]", R.drawable.d_haixiu);
        emojiMap.put("[笑cry]", R.drawable.d_xiaoku);
        emojiMap.put("[doge]", R.drawable.d_doge);
        emojiMap.put("[喵喵]", R.drawable.d_miao);
        emojiMap.put("[鼓掌]", R.drawable.d_guzhang);
        emojiMap.put("[哆啦A梦微笑]", R.drawable.dwei);
        emojiMap.put("[心]", R.drawable.heart);
        emojiMap.put("[来]", R.drawable.lai);
        emojiMap.put("[色]", R.drawable.se);
        emojiMap.put("[话筒]", R.drawable.huatong);


    }

    public static int getImgByName(String imgName) {
        Integer integer = emojiMap.get(imgName);
        return integer == null ? -1 : integer;
    }

//    public static List<Emotions> getEmotionsList(String access_token) {
//        OkHttpClient client = new OkHttpClient();
//        access_token = "https://api.weibo.com/2/emotions.json?access_token=" + access_token;
//        System.out.println("有没1" + access_token);
//        Request request = new Request.Builder()
//                .url(access_token)
//                .build();
//        Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                System.out.println("表情返回失败");
//            }
//
//            @Override
//            public void onResponse(Call call, final Response response) throws IOException {
//                final String responesText = response.body().string();
//                test=responesText;
//                Gson gson = new Gson();
//                EmotionList list = gson.fromJson(responesText, EmotionList.class);
//                System.out.println("到这里了"+list.toString());
//                emotionsList= list.getEmotions();
//            }
//        });
//        return emotionsList;
//    }
//
//
//    public static Bitmap getImgByName(String imgName, String access_token) {
//        getEmotionsList(access_token);
//        System.out.println("测试"+test);
//        Bitmap emoji = null;
//        System.out.println("名字是" + imgName + "," + emotionsList.size());
//        for (Emotions em :
//                emotionsList) {
//            if (em.getPhrase().equals(imgName)) {
//
//                try {
//                    URL url = new URL(em.getUrl());
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                    connection.setDoInput(true);
//                    connection.connect();
//                    InputStream input = connection.getInputStream();
//                    emoji = BitmapFactory.decodeStream(input);
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                break;
//            }
//        }
//        return emoji == null ? null : emoji;
//    }
}
