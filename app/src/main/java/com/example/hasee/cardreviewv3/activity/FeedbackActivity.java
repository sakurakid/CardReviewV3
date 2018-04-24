package com.example.hasee.cardreviewv3.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hasee.cardreviewv3.R;

/**
 * 意见反馈的活动
 * 把用户给的反馈信息发给服务器，然后界面有变化
 */

public class FeedbackActivity extends AppCompatActivity {
    private static String os;//意见内容
    private EditText feedbackView;
    private Button set;//提交
    private ImageView back;//返回

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        back = (ImageView)findViewById(R.id.iv_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        feedbackView = (EditText)findViewById(R.id.feedbackview);
        os = feedbackView.getText().toString();//获取内容

        set = (Button)findViewById(R.id.btn_feedback);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //提交
                Toast.makeText(FeedbackActivity.this, "功能正在维护中", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}
