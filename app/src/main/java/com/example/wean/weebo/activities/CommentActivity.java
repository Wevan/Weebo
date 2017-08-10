package com.example.wean.weebo.activities;

import android.content.Intent;
import android.support.v4.util.LogWriter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.wean.weebo.R;
import com.example.wean.weebo.adapter.CommentAdapter;
import com.example.wean.weebo.gson.Comments;
import com.example.wean.weebo.gson.GetComts;
import com.example.wean.weebo.gson.Weibo;
import com.google.gson.Gson;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CommentActivity extends AppCompatActivity {

    List<Comments> list=new ArrayList<>();
    String access_token;
    String id;
    RecyclerView recyclerView;
    private CommentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Intent getIntent = getIntent();
        access_token = getIntent.getStringExtra("access_token");
        id = getIntent.getStringExtra("id");
        System.out.println("评论里get到了"+id+"和"+access_token);
        getComments();

        recyclerView= (RecyclerView) findViewById(R.id.comment_recycle);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CommentAdapter adapter=new CommentAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    public void getComments(){
        OkHttpClient client=new OkHttpClient();
        String addr="https://api.weibo.com/2/comments/show.json?access_token="+access_token+"&id="+id;
        System.out.println("地址是这个呐"+addr);
        Request request = new Request.Builder()
                .url(addr)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    final String responesText = response.body().string();

                    Gson gson = new Gson();
                    GetComts getComts = gson.fromJson(responesText, GetComts.class);

                    @Override
                    public void run() {
                        System.out.println("评论的返回数据"+responesText);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager);
                        List<Comments> list = getComts.getComments();
                        adapter = new CommentAdapter(list);
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        });
    }
}
