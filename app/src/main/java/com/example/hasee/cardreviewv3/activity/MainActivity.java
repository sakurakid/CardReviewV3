package com.example.hasee.cardreviewv3.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.hasee.cardreviewv3.R;
import com.example.hasee.cardreviewv3.fragment.bagFragment;
import com.example.hasee.cardreviewv3.fragment.mineFragment;
import com.example.hasee.cardreviewv3.fragment.reviewFragment;
import com.example.hasee.cardreviewv3.fragment.searchFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private BottomNavigationBar bottomNavigationBar;  //底部导航栏
    private ArrayList<Fragment> fragmentList = new ArrayList<>();  //活动的数组
    private FragmentManager manager;
    int curFragment=-1;
    //233


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        manager = getSupportFragmentManager();
        initFragments();
        Log.d("233","111");
        initbottomView();
    }
    private void initFragments(){
        fragmentList.add(new reviewFragment());
        fragmentList.add(new bagFragment());
        fragmentList.add(new searchFragment());
        fragmentList.add(new mineFragment());
    }
    private void initbottomView(){
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.icon_review, "复习").setActiveColorResource(R.color.colorbar))
                .addItem(new BottomNavigationItem(R.mipmap.icon_bag, "卡包").setActiveColorResource(R.color.colorbar))
                .addItem(new BottomNavigationItem(R.mipmap.icon_search, "探索").setActiveColorResource(R.color.colorbar))
                .addItem(new BottomNavigationItem(R.mipmap.icon_mine, "我的").setActiveColorResource(R.color.colorbar))
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switchTab(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
        switchTab(0);

    }
    private void switchTab(int position){
        Fragment fragment = manager.findFragmentByTag("" + position);
        FragmentTransaction beginTransaction = manager.beginTransaction();
        if(fragment==null){
            if(manager.findFragmentByTag("" + curFragment)!=null){
                beginTransaction.hide(fragmentList.get(curFragment));
            }
            beginTransaction.add(R.id.layout,fragmentList.get(position),""+position)
                    .show(fragmentList.get(position))
                    .commit();

        }else if(curFragment!=position){
            beginTransaction.hide(fragmentList.get(curFragment))
                    .show(fragmentList.get(position))
                    .commit();
        }
        curFragment=position;
    }





}
