package com.example.hasee.cardreviewv3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hasee.cardreviewv3.R;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Headers;
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
    public String s; //Session


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    public void initView() {
        register = (Button) findViewById(R.id.btn_register);
        getCode = (Button) findViewById(R.id.get_identifyingcode);

        et_phone = (EditText) findViewById(R.id.et_phone);
        et_password_old = (EditText) findViewById(R.id.et_password_old);
        et_password_new = (EditText) findViewById(R.id.et_password_new);
        et_code = (EditText) findViewById(R.id.et_code);


        register.setOnClickListener(this);
        getCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                register();
                Intent intent = new Intent(Register.this, LoginActivity.class);
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
    private void getcode() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                iphoneNumber = et_phone.getText().toString();
                OkHttpClient client = new OkHttpClient();
                RequestBody requestBody = new FormBody.Builder()
                        .add("mobile", iphoneNumber)
                        .build();
                Request request = new Request.Builder()
                        .url("http://diamond.creatshare.com/user/getcode")
                        .post(requestBody)
                        .build();


                Call call = client.newCall(request);
                try {
                    Response response = call.execute();
                    Log.d("233", response.body().string());

                    //获取Session操作
                    Headers headers = response.headers();
                    Log.d("233", "header " + headers);
                    List<String> cookies = headers.values("Set-Cookie");
                    String session = cookies.get(0);
                    s = session.substring(0, session.indexOf(";"));

                    //获取请求返回的值
//                    String returncode = parseJSON(response.body().string());
//                    Log.d("233", "returncode  " + returncode);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();


    }


    /**
     * 注册
     */
    private void register() {
        password_older = et_password_old.getText().toString();
        password_new = et_password_new.getText().toString();
        code = et_code.getText().toString();

        Log.d("233", "Session " + s);
        Log.d("233", "2 " + iphoneNumber);
        Log.d("233", "2 " + password_older);
        Log.d("233", "2 " + password_new);
        Log.d("233", "2 " + code);

        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();

                RequestBody requestBody = new FormBody.Builder()
                        .add("mobile", iphoneNumber)
                        .add("code", code)
                        .add("password", password_older)
                        .add("passwordConfirm", password_new)
                        .build();
                Request request = new Request.Builder()
                        .url("http://diamond.creatshare.com/user/register")
                        .post(requestBody)
                        .addHeader("cookie", s)
                        .build();

                Call call = client.newCall(request);
                try {
                    Response response = call.execute();
                    Log.d("233", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }

//    /**
//     * 解析返回返回值
//     *
//     * @param jsonData
//     */
//    public String parseJSON(String jsonData) {
//        String codes = null;
//        try {
//            JSONObject jsonObject = new JSONObject(jsonData);
//            codes = jsonObject.getString("code");
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//.
//        return codes;
//    }




}



