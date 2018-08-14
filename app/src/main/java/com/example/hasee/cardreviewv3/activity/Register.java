package com.example.hasee.cardreviewv3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hasee.cardreviewv3.R;

/**
 * 用户注册的活动
 */
public class Register extends AppCompatActivity implements View.OnClickListener {
    public Button register;//注册
    public Button getCode;//获取验证码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    public void initView(){
        register = (Button)findViewById(R.id.btn_register);
        getCode = (Button)findViewById(R.id.get_identifyingcode);


        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                Intent intent = new Intent(Register.this,MainActivity.class);
                startActivity(intent);
                break;
        }

    }
}
