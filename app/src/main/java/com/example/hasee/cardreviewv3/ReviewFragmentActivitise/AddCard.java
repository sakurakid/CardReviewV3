package com.example.hasee.cardreviewv3.ReviewFragmentActivitise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.hasee.cardreviewv3.R;
import com.example.hasee.cardreviewv3.viewBase.MyDialog;

public class AddCard extends AppCompatActivity implements View.OnClickListener,MyDialog.OnCenterItemClickListener{
    private ImageView back;
    private ImageView ok;//完成
    private Button choosebag;//选择卡包的按钮
    private MyDialog dialog;//选择卡片dialog
    private Button choosecardkind;//选择卡片类型的按钮
    private LinearLayout linearLayout;//动态加载的布局
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("244","22211133333");
        setContentView(R.layout.activity_add_card);
        Log.d("244","222111");
        init();
        Log.d("244","222555");
    }

    private void init() {
        choosebag = (Button) findViewById(R.id.btn_choosebag);
        back = (ImageView)findViewById(R.id.iv_back1);
        ok = (ImageView)findViewById(R.id.iv_save);
        choosecardkind = (Button)findViewById(R.id.btn_choosecardkind);
        choosebag.setOnClickListener(this);
        choosecardkind.setOnClickListener(this);
        inflater = LayoutInflater.from(this);
        linearLayout = (LinearLayout) findViewById(R.id.ll_addView);
        dialog = new MyDialog(this,R.layout.dialog_cardkind,new int[]{R.id.dia_common,R.id.dia_choice,R.id.dia_pack});
        dialog.setOnCenterItemClickListener((MyDialog.OnCenterItemClickListener) this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //完成的
            }
        });
    }

    @Override
    public void onClick(View v) {
        Log.e("233","11111");
        switch (v.getId()) {
            case R.id.iv_back1:
                finish();
                break;
            case R.id.btn_choosebag:
                Log.d("244","221");
                startActivity(new Intent(AddCard.this,DialogchoosebagActivity.class));
                break;
            case R.id.btn_choosecardkind:
                dialog.show();
                break;



        }
    }

    /**
     * 选择不同的卡片类型
     * @param dialog
     * @param view
     */
    @Override
    public void OnCenterItemClick(MyDialog dialog, View view) {
        switch (view.getId()){
            case R.id.dia_common://普通卡片类型
                choosecardkind.setText("普通卡片");
                LinearLayout linearLayout2 = (LinearLayout)inflater.inflate(R.layout.item_commomcard,null);
                linearLayout.addView(linearLayout2);
                break;
            case R.id.dia_pack:
                //填空卡片
                choosecardkind.setText("填空卡片");
                break;
            case R.id.dia_choice:
                //选择卡片
                choosecardkind.setText("选择卡片");
                break;

        }

    }
}




