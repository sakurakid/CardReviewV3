package com.example.hasee.cardreviewv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationBar bottomNavigationBar;  //底部导航栏

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationBar = (BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.icon_review,"复习").setActiveColorResource(R.color.colorbar))
                           .addItem(new BottomNavigationItem(R.mipmap.icon_bag,"卡包").setActiveColorResource(R.color.colorbar))
                           .addItem(new BottomNavigationItem(R.mipmap.icon_search,"探索").setActiveColorResource(R.color.colorbar))
                           .addItem(new BottomNavigationItem(R.mipmap.icon_mine,"我的").setActiveColorResource(R.color.colorbar))
                           .setFirstSelectedPosition(0)
                           .initialise();
    }
}
