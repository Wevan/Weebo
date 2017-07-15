package com.example.wean.weebo.activities;


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


public class MainActivity extends AppCompatActivity{

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
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
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.tb, fragment)
                .commit();
    }
}