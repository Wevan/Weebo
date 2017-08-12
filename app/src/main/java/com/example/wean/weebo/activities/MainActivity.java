package com.example.wean.weebo.activities;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.MotionEvent;

import com.example.wean.weebo.R;
import com.example.wean.weebo.fragments.AddFragment;
import com.example.wean.weebo.fragments.FindFragment;
import com.example.wean.weebo.fragments.InfoFragment;
import com.example.wean.weebo.fragments.MsgFragment;
import com.example.wean.weebo.fragments.UserFragment;
import com.example.wean.weebo.utils.BottomNavigationViewHelper;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static BottomNavigationView bottomNavigationView;
    private ArrayList<MyOnTouchListener> onTouchListeners = new ArrayList<MyOnTouchListener>(10);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        changeFragment(new InfoFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.host:
                        changeFragment(new InfoFragment());
                        break;
                    case R.id.msg:
                        changeFragment(new MsgFragment());
                        break;
                    case R.id.add:
                        startActivity(new Intent(MainActivity.this,AddActivity.class));
                        break;
                    case R.id.search:
                        changeFragment(new FindFragment());
                        break;
                    case R.id.me:
                        changeFragment(new UserFragment());
                        break;
                    default:
                        changeFragment(new InfoFragment());
                }
                return true;
            }
        });
    }

    private void changeFragment(Fragment fragment) {
        String access_token = getIntent().getStringExtra("access_token");
        String uid=getIntent().getStringExtra("uid");
        System.out.println("在Main里：" + access_token);
        Bundle args = new Bundle();
        args.putString("access_token", access_token);
        args.putString("uid",uid);
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.tb, fragment)
                .commit();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        for (MyOnTouchListener listener : onTouchListeners) {
            listener.onTouch(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void registerMyOnTouchListener(MyOnTouchListener myOnTouchListener) {
        onTouchListeners.add(myOnTouchListener);
    }

    public void unregisterMyOnTouchListener(MyOnTouchListener myOnTouchListener) {
        onTouchListeners.remove(myOnTouchListener);
    }

    public interface MyOnTouchListener {
        public boolean onTouch(MotionEvent ev);

        void send(BottomNavigationView view);
    }

    public static class Data {
        public MyOnTouchListener listener;

        public Data(MyOnTouchListener mListener) {
            this.listener = mListener;
        }

        public void sends() {
            listener.send(bottomNavigationView);//开始发送数据
        }
    }


}
