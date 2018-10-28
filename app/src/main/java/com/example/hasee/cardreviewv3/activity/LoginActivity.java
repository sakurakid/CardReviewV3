package com.example.hasee.cardreviewv3.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;

import com.example.hasee.cardreviewv3.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
    private Button register;//注册账号的
    private Button login;//登陆的
    private ImageView cleanPhone;    //清除电话号码
    private ImageView cleanCode;  //清除验证码
    private TextView Service;   //关于服务
    private TextView aboutUs;  //关于我们
    private ImageView QQLogin; //qq登陆
    private ImageView weChatLogin;//微信登陆
    //倒计时的东西

    public String phone;
    public String password;

    static String token;//登陆完了的Token



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

    }

    public void initView(){
        logo = (ImageView)findViewById(R.id.logo);
        phoneEdit = (EditText)findViewById(R.id.et_mobile);
        codeEdit = (EditText)findViewById(R.id.et_keypasscode);
        register = (Button)findViewById(R.id.btn_gotoregister);
        login = (Button)findViewById(R.id.btn_login);



        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //登陆的
            case R.id.btn_login:
                login();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                break;
                //注册的
            case R.id.btn_gotoregister:
                Intent intent1 = new Intent(LoginActivity.this,Register.class);
                startActivity(intent1);
                break;
        }

    }

    /**
     * 登陆的
     */
    private void login(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                phone = phoneEdit.getText().toString();
                password = codeEdit.getText().toString();

                Log.d("233","1"+phone);
                Log.d("233","1"+password);


                OkHttpClient client = new OkHttpClient();
                RequestBody requestBody = new FormBody.Builder()
                        .add("mobile", phone)
                        .add("password",password)
                        .build();
                Request request = new Request.Builder()
                        .url("http://diamond.creatshare.com/user/login")
                        .post(requestBody)
                        .build();


                Call call = client.newCall(request);
                try {
                    Response response = call.execute();
                    token = response.headers().get("Authorization");
                    //Token tokensave = new Token();
                    //存储Token
                    SharedPreferences.Editor editor = getSharedPreferences("Token",MODE_PRIVATE).edit();
                    editor.putString("Token",token);
                    editor.apply();
//                    tokensave.setToken(token);
//                    tokensave.save();
                    Log.d("233","token" + token);
                    Log.d("233", "1 "+response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

