package com.example.hasee.cardreviewv3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hasee.cardreviewv3.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 用户注册的活动
 */
public class Register extends AppCompatActivity implements View.OnClickListener {
    public Button register;//注册
    public Button getCode;//获取验证码
    public EditText et_phone;//输入的电话
    public EditText et_password_old;//第一次的密码
    public EditText et_password_new;//第二次的密码
    public EditText et_code;//验证码的

    public String iphoneNumber;//电话号码
    public String password_older;//密码旧
    public String password_new;//密码新
    public String code;//验证码



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    public void initView(){
        register = (Button)findViewById(R.id.btn_register);
        getCode = (Button)findViewById(R.id.get_identifyingcode);

        et_phone = (EditText)findViewById(R.id.et_phone);
        et_password_old = (EditText)findViewById(R.id.et_password_old);
        et_password_new = (EditText)findViewById(R.id.et_password_new);
        et_code = (EditText)findViewById(R.id.et_code);


        register.setOnClickListener(this);
        getCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                Intent intent = new Intent(Register.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.get_identifyingcode:
                getcode();
                break;
        }

    }

    /**
     * 获取验证码的
     */
    private void getcode(){
        iphoneNumber = et_phone.getText().toString();
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("mobile",iphoneNumber)
                .build();
        Request request = new Request.Builder()
                .url("http://diamond.creatshare.com/user/getcode")
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(Register.this,"获取验证码失败",Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("233",response.toString());
                Toast.makeText(Register.this,"获取验证码",Toast.LENGTH_SHORT).show();

            }
        });

    }

    /**
     * 注册
     */
    private void register(){

    }
}
