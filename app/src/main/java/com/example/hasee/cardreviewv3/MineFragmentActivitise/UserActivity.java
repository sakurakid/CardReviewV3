package com.example.hasee.cardreviewv3.MineFragmentActivitise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hasee.cardreviewv3.R;

public class UserActivity extends AppCompatActivity {
    private Button roselevel;//提交
    private ImageView back;//返回

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Log.d("233","111");

        back = (ImageView)findViewById(R.id.iv_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        roselevel = (Button)findViewById(R.id.btn_roselevel);

        roselevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //提交
                Toast.makeText(UserActivity.this, "帅气程序猿正在加班中", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}
