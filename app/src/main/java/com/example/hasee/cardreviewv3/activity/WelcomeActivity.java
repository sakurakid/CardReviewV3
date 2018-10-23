package com.example.hasee.cardreviewv3.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.example.hasee.cardreviewv3.R;

import org.litepal.LitePal;

/**
 * 就是一个欢迎界面 每次打开app都要展示的啦啦啦
 */

public class WelcomeActivity extends AppCompatActivity {
    private static final int TIME = 5000;
    private static final int GO_MAIN = 100;//注册过的
    private static final int GO_GUIDE = 101;//第一次进来


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GO_MAIN:
                    goMain();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
        LitePal.getDatabase();//创建数据库
    }

    private void init(){
        SharedPreferences sf = getSharedPreferences("data",MODE_PRIVATE);//判断是否第一次进入
        boolean isFirstIn = sf.getBoolean("isFirstIn",true);
        SharedPreferences.Editor editor = sf.edit();
        if (isFirstIn){
            editor.putBoolean("isFirstIn",false);
            handler.sendEmptyMessageDelayed(GO_GUIDE,TIME);
        }else {
            handler.sendEmptyMessageDelayed(GO_MAIN,TIME);
        }
        editor.commit();
    }

    private void goMain(){
        Intent  intent = new Intent(WelcomeActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    private void goGuide(){
        Intent intent = new Intent(WelcomeActivity.this,GuideActivity.class);
        startActivity(intent);
        finish();
    }

}
