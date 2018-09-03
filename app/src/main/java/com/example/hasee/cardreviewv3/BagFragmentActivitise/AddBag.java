package com.example.hasee.cardreviewv3.BagFragmentActivitise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.hasee.cardreviewv3.R;

/**
 * 创建卡包的
 */
public class AddBag extends AppCompatActivity implements View.OnClickListener{
    private ImageView back;//返回的按钮
    private ImageView ok;//完成


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bag);
        init();
    }

    /**
     * 绑定
     */

    private void init(){
        back = (ImageView)findViewById(R.id.iv_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;

        }

    }
}
