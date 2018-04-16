package com.example.hasee.cardreviewv3.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;

import com.example.hasee.cardreviewv3.R;

/**
 * 登陆主活动
 * 只要输入正确的电话号码---然后获取验证码----就注册成功----以后这个页面就不显示了
 * 将电话号码保存下了，发给后台
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView logo;//项目的图标
    private Scroller body;
    private EditText phoneEdit; //电话号码的
    private EditText codeEdit;//验证码输入
    private Button getidentifyingcode;//获取验证码
    private ImageView cleanPhone;    //清除电话号码
    private ImageView cleanCode;  //清除验证码
    private TextView Service;   //关于服务
    private TextView aboutUs;  //关于我们
    private ImageView QQLogin; //qq登陆
    private ImageView weChatLogin;//微信登陆

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onClick(View v) {

    }
}
