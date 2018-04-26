package com.example.hasee.cardreviewv3.MineFragmentActivitise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hasee.cardreviewv3.R;

/**
 * mine里面的游戏情况
 * game和积分
 */

public class MinegameActivity extends AppCompatActivity {
    private ImageView back;
    private View game;
    private View score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minegame);
        back = (ImageView)findViewById(R.id.iv_back);
        game = (LinearLayout)findViewById(R.id.ll_game_dati);
        score = (LinearLayout)findViewById(R.id.ll_mine_score);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MinegameActivity.this, "功能正在维护中", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MinegameActivity.this,MinescoreActivity.class));
            }
        });
    }



}
