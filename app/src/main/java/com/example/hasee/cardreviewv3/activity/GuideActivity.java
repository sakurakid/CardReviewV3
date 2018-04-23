package com.example.hasee.cardreviewv3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hasee.cardreviewv3.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导界面
 * 就是第一次打开app时候然后才会出现的
 */

public class GuideActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerAdapter mAdapter;//需要的适配器
    private List<View> mViews =new ArrayList<>();//放在一起的页面
    private Button bt_home;//最后的跳转按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initview();
    }

    private void initview(){
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        LayoutInflater inflater = LayoutInflater.from(this);
        View guideOne = inflater.inflate(R.layout.guidance01,null);
        View guideTwo = inflater.inflate(R.layout.guidance02,null);
        View guideThree = inflater.inflate(R.layout.guidance03,null);
        View guideFour = inflater.inflate(R.layout.guidance04,null);

        mViews.add(guideOne);
        mViews.add(guideTwo);
        mViews.add(guideThree);
        mViews.add(guideFour);

        mAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view=mViews.get(position);//初始化适配器，将view加到container中
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                View view=mViews.get(position);
                container.removeView(view);//将view从container中移除
            }


            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

        };

        viewPager.setAdapter(mAdapter);

        bt_home = (Button)guideFour.findViewById(R.id.but_tologin);
        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
