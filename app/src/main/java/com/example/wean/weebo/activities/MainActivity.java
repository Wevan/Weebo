package com.example.wean.weebo.activities;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        changeFragment(new InfoFragment());
        sendcode();
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

    private void sendcode() {


    }
}
