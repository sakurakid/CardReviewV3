package com.example.hasee.cardreviewv3.MineFragmentActivitise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hasee.cardreviewv3.R;

public class MinescoreActivity extends AppCompatActivity {
    private ImageView back;
    private View invitefriends;
    private View exchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minescore);
        back = (ImageView)findViewById(R.id.iv_back);
        invitefriends = (LinearLayout)findViewById(R.id.ll_mine_score_invitefriends);
        exchange = (LinearLayout)findViewById(R.id.ll_mine_score_exchange);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        invitefriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MinescoreActivity.this, "帅帅程序猿正在开发中", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MinescoreActivity.this, "帅帅程序猿正在开发中", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
