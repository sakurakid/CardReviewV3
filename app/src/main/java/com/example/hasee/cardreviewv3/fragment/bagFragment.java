package com.example.hasee.cardreviewv3.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hasee.cardreviewv3.BagFragmentActivitise.AddBag;
import com.example.hasee.cardreviewv3.R;

/**
 * Created by hasee on 2018/4/10.
 * 卡包的
 */

public class bagFragment extends Fragment {
    private View view;
    private ImageView addbag;//添加卡包
    private ImageView update;//更新卡包数据
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bag,container, false);
        initView(container);
        return view;
    }
    /**
     * 绑定
     */
    private void initView(ViewGroup c){
        addbag = (ImageView) view.findViewById(R.id.iv_add_bag);
        update = (ImageView) view.findViewById(R.id.iv_upload_bag);

        addbag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddBag.class);
                startActivity(intent);
            }
        });
    }
}
