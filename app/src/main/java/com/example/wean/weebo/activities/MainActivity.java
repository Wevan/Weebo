package com.example.wean.weebo.activities;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.BottomNavigationView;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.wean.weebo.R;
import com.example.wean.weebo.fragments.AddFragment;
import com.example.wean.weebo.fragments.FindFragment;
import com.example.wean.weebo.fragments.InfoFragment;
import com.example.wean.weebo.fragments.MsgFragment;
import com.example.wean.weebo.fragments.UserFragment;
import com.example.wean.weebo.utils.BottomNavigationViewHelper;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    final int UP = 0;
    final int DOWN = 1;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureDetector = new GestureDetector(this, new MyOnGestureListener());
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
                        changeFragment(new AddFragment());
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
        System.out.println("在Main里："+ access_token);
        Bundle args = new Bundle();
        args.putString("access_token", access_token);
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.tb, fragment)
                .commit();
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private class MyOnGestureListener extends GestureDetector.SimpleOnGestureListener {
        //e1 : 按下的事件,保存有按下的坐标
        //e2 : 抬起的事件,保存有抬起的坐标
        //velocityX : velocity 速度    在x轴上移动的速率
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            //得到按下的x坐标
            float startX = e1.getRawX();
            //得到抬起的x坐标
            float endX = e2.getRawX();
            //得到按下的Y坐标
            float startY = e1.getRawY();
            //得到抬起的y坐标
            float endY = e2.getRawY();
            //判断是否是斜滑
//            if ((Math.abs(startY - endY)) > 150) {
//                //Toast.makeText(getApplicationContext(), "你小子又乱滑了,别闹了....", Toast.LENGTH_SHORT).show();
//                return false;
//            }
            //下一步
            if ((startY - endY) > 20) {
                Toast.makeText(getApplicationContext(),"上上",Toast.LENGTH_SHORT).show();
            }
            //上一步
            if ((endY - startY) > 20) {
                Toast.makeText(getApplicationContext(),"下",Toast.LENGTH_SHORT).show();
            }
            //true if the event is consumed, else false
            //true : 事件执行     false:拦截事件,事件不执行
            return true;
        }

    }


//    private GestureDetector.OnGestureListener onGestureListener =
//            new GestureDetector.SimpleOnGestureListener() {
//                @Override
//                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
//                                       float velocityY) {
//                    float x = e2.getX() - e1.getX();
//                    float y = e2.getY() - e1.getY();
//
//                    if (y > 0) {
//                        doResult(UP);
//                    } else if (y < 0) {
//                        doResult(DOWN);
//                    }
//                    return true;
//                }
//            };
//    public void doResult(int action) {
//
//        switch (action) {
//            case UP:
//                System.out.println("go right");
//                Toast.makeText(MainActivity.this,"上",Toast.LENGTH_SHORT).show();
//                break;
//
//            case DOWN:
//                System.out.println("go left");
//                Toast.makeText(MainActivity.this,"下",Toast.LENGTH_SHORT).show();
//
//                break;
//
//        }
//    }
}
