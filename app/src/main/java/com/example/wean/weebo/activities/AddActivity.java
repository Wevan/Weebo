package com.example.wean.weebo.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dss886.emotioninputdetector.library.EmotionInputDetector;
import com.example.wean.weebo.R;

import com.example.wean.weebo.gson.Newone;
import com.google.gson.Gson;
import com.sqk.emojirelease.Emoji;
import com.sqk.emojirelease.EmojiUtil;
import com.sqk.emojirelease.FaceFragment;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AddActivity extends AppCompatActivity implements FaceFragment.OnEmojiClickListener, View.OnClickListener {

    TextView textView;
    EditText editText;
    String urlString;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        textView = (TextView) findViewById(R.id.textview);
        editText = (EditText) findViewById(R.id.edit_text);
        send= (Button) findViewById(R.id.send);
        FaceFragment faceFragment = FaceFragment.Instance();
        getSupportFragmentManager().beginTransaction().add(R.id.Container,faceFragment).commit();
        send.setOnClickListener(this);
    }


    private void displayTextView() {
        try {
            EmojiUtil.handlerEmojiText(textView, editText.getText().toString(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEmojiDelete() {
        String text = editText.getText().toString();
        System.out.println("发布微博"+text);
        if (text.isEmpty()) {
            return;
        }
        if ("]".equals(text.substring(text.length() - 1, text.length()))) {
            int index = text.lastIndexOf("[");
            if (index == -1) {
                int action = KeyEvent.ACTION_DOWN;
                int code = KeyEvent.KEYCODE_DEL;
                KeyEvent event = new KeyEvent(action, code);
                editText.onKeyDown(KeyEvent.KEYCODE_DEL, event);
                displayTextView();
                return;
            }
            editText.getText().delete(index, text.length());
            displayTextView();
            return;
        }
        int action = KeyEvent.ACTION_DOWN;
        int code = KeyEvent.KEYCODE_DEL;
        KeyEvent event = new KeyEvent(action, code);
        editText.onKeyDown(KeyEvent.KEYCODE_DEL, event);
        displayTextView();
    }

    @Override
    public void onEmojiClick(Emoji emoji) {
        if (emoji != null) {
            int index = editText.getSelectionStart();
            Editable editable = editText.getEditableText();
            if (index < 0) {
                editable.append(emoji.getContent());
            } else {
                editable.insert(index, emoji.getContent());
            }
        }
        System.out.println("文本内容"+editText.getText().toString());
        String content=editText.getText().toString()+"baidu.com";
        try {
            urlString = URLEncoder.encode(content, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        displayTextView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send:
                OkHttpClient client=new OkHttpClient();
                Intent intent=getIntent();
                String access_token = getIntent().getStringExtra("access_token");
                urlString=editText.getText().toString()+" https://www.baidu.com";
                System.out.println("Add活动里"+access_token+",,,"+urlString);

                FormBody formBody=new FormBody.Builder().add("access_token",access_token)
                        .add("status",urlString)
                        .build();
                Request request = new Request.Builder().url("https://api.weibo.com/2/statuses/share.json").post(formBody).build();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseData = response.body().string();
                        System.out.println("发布的返回"+responseData);
                        Gson gson = new Gson();
                        Newone newone=new Newone();
                        newone=gson.fromJson(responseData,Newone.class);

                    }
                });

        }
    }
}
