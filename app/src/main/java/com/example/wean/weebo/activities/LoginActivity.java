package com.example.wean.weebo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wean.weebo.R;
import com.example.wean.weebo.fragments.InfoFragment;

public class LoginActivity extends AppCompatActivity {

    private Button button;
    private static boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button= (Button) findViewById(R.id.lg_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, OAuthActivity.class);
                flag=intent.getBooleanExtra("flag",false);

                if (!flag){
                    startActivity(intent);
                    LoginActivity.this.finish();
                }else {
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    LoginActivity.this.finish();
                }
            }
        });
    }
}
