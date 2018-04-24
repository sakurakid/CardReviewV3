package com.example.hasee.cardreviewv3.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hasee.cardreviewv3.R;

/**
 * Created by hasee on 2018/4/10.
 * 我的碎片
 * 哇哇哇
 */

public class mineFragment extends Fragment {
    private View view;
    LinearLayout users,weekTask,memoryWay,gameInformation,feedBack;
    TextView name;//用户名字
    TextView level;//用户等级
    ImageView photo;//用户头像
    String url;
    int mount,num,count;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine,container, false);
    }

    /**
     * 绑定
     * @param c
     */
    private void initView(ViewGroup c){
       users = (LinearLayout)view.findViewById(R.id.ll_mine_ueser);
       weekTask = (LinearLayout)view.findViewById(R.id.ll_mine_weektask);
       memoryWay = (LinearLayout)view.findViewById(R.id.ll_mine_memoryway);
       gameInformation = (LinearLayout)view.findViewById(R.id.ll_mine_game);
       feedBack = (LinearLayout)view.findViewById(R.id.ll_mine_feedback);
       name = (TextView)view.findViewById(R.id.tv_mine_name);
       level = (TextView)view.findViewById(R.id.tv_level);
       photo = (ImageView)view.findViewById(R.id.iv_mine_photo);

    }
}
