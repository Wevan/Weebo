package com.example.wean.weebo;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.wean.weebo.fragments.AddFragment;
import com.example.wean.weebo.fragments.FindFragment;
import com.example.wean.weebo.fragments.InfoFragment;
import com.example.wean.weebo.fragments.MsgFragment;
import com.example.wean.weebo.fragments.UserFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener,MsgFragment.OnFragmentInteractionListener,AddFragment.OnFragmentInteractionListener {

    private BottomNavigationBar bottomNavigationBar;
    int lastSelectedPosition = 0;
    private AddFragment addFragment;
    private FindFragment findFragment;
    private InfoFragment infoFragment;
    private MsgFragment msgFragment;
    private UserFragment userFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.host, "Home"))
                .addItem(new BottomNavigationItem(R.drawable.msg, "msg"))
                .addItem(new BottomNavigationItem(R.drawable.tab_home_add, "add"))
                .addItem(new BottomNavigationItem(R.drawable.search,"find"))
                .addItem(new BottomNavigationItem(R.drawable.account,"me"))
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);


    }

    @Override
    public void onTabSelected(int position) {
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (infoFragment == null) {
                    infoFragment = InfoFragment.newInstance("InfoFragment","InfoFragment");
                }
                transaction.replace(R.id.tb, infoFragment);
                break;
            case 1:
                if (msgFragment == null) {
//                            msgFragment = MsgFragment.newInstance("MsgFragment","MsgFragment");
                    msgFragment=new MsgFragment();
                    transaction.add(R.id.tb, msgFragment);
                }else{
                    transaction.show(msgFragment);
                }
                break;
            case 2:
                if (addFragment == null) {
//                            addFragment = AddFragment.newInstance("Third Fragment","");
                    addFragment=new AddFragment();

                    transaction.replace(R.id.tb, addFragment);
                }else {
                    transaction.show(addFragment);
                }
                break;
            case 3:
                if (findFragment == null) {
                    findFragment = FindFragment.newInstance("Forth Fragment","");
                }
                transaction.replace(R.id.tb, findFragment);
                break;
            default:
                if (userFragment == null) {
                    userFragment = UserFragment.newInstance("First Fragment","");
                }
                transaction.replace(R.id.tb, userFragment);
                break;
        }
        transaction.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
