package com.example.wean.weebo.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wean.weebo.Inter.Constants;
import com.example.wean.weebo.R;
import com.example.wean.weebo.gson.Statuses;
import com.example.wean.weebo.utils.RequestParams;
import com.google.gson.Gson;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.framed.Header;

public class OAuthActivity extends AppCompatActivity {

    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oauth);
        //获取只能被本程序读写的SharedPreferences对象
        preferences = getSharedPreferences("OAuth2.0", Context.MODE_PRIVATE);
        //WebView加载回调页
        final WebView webView = (WebView) findViewById(R.id.webView);
        //管理WebView
        WebSettings webSettings = webView.getSettings();
        //启用JavaScript调用功能
        webSettings.setJavaScriptEnabled(true);
        //启用缩放网页功能
        webSettings.setSupportZoom(true);
        //获取焦点
        webView.requestFocus();
        RequestParams params = new RequestParams();
        String url1 = params.put(Constants.APP_KEY, Constants.REDIRECT_URL);
        webView.loadUrl(url1);
        //WebViewClient主要帮助WebView处理各种通知、请求事件
        webView.setWebViewClient(
                new WebViewClient() {
                    @Override
                    public void onPageStarted(WebView view, String url, Bitmap favicon) {
                        super.onPageStarted(view, url, favicon);
                        System.out.println("kaishi");
                        if (url.startsWith(Constants.REDIRECT_URL)) {
                            String code = url.split("=")[1];
                            System.out.println("code is " + code);
                            requestmsg(code);
                        }
                    }
                });

    }

    public void requestmsg(final String code) {
        new Thread(new Runnable() {
            Statuses statuses = new Statuses();

            @Override
            public void run() {
                try {
                    FormBody formBody=new FormBody.Builder().add("client_id",Constants.APP_KEY)
                            .add("client_secret",Constants.APP_SECRET)
                            .add("grant_type","authorization_code")
                            .add("code",code)
                            .add("redirect_uri",Constants.REDIRECT_URL)
                            .build();
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url("https://api.weibo.com/oauth2/access_token").post(formBody).build();
                    Call call = client.newCall(request);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Toast.makeText(OAuthActivity.this, "error", Toast.LENGTH_SHORT).show();
                            System.out.println("错误信息"+e.getMessage());
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if (response.isSuccessful()) {
                                System.out.println("成功！");
                                Log.d("日志", "response.code()==" + response.code());
                                Log.d("日志", "response.message()==" + response.message());
                                Log.d("日志", "res==" + response.body().string());
                                String responseData = response.body().string();
                                Gson gson = new Gson();
                                statuses = gson.fromJson(responseData, Statuses.class);
                            } else {
                                System.out.println("失败");
                            }
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 使用SharedPreferences保存的OAthu的client_id和client_secret和access_token等重要信息
     */
    private void saveData(JSONObject object) {
        try {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("access_token", object.getString("access_token"));
            editor.putString("remind_in", object.getString("remind_in"));
            editor.putString("expires_in", object.getString("expires_in"));
            editor.putString("uid", object.getString("uid"));
//            editor.putString("client_id", Constants.CLIENT_ID);
            editor.putString("redirect_uri", Constants.REDIRECT_URL);
            editor.putString("client_secret", Constants.APP_SECRET);
            editor.apply();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
