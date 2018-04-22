package com.example.hasee.cardreviewv3.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hasee.cardreviewv3.R;

/**
 * 引导界面
 * 就是第一次打开app时候然后才会出现的
 */

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
    }
}
