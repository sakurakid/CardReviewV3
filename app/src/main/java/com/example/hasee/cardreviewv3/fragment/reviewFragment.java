package com.example.hasee.cardreviewv3.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hasee.cardreviewv3.R;
import com.example.hasee.cardreviewv3.ReviewFragmentActivitise.AddCard;

/**
 * Created by hasee on 2018/4/10.
 * 复习的
 */

public class reviewFragment extends Fragment {
    private View view;
    private ImageView addcard;//添加图片
    private ImageView cardgame;//卡片游戏

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.review_lead,container, false);
        initView(container);
        return view;
    }
    /**
     * 绑定
     */
    private void initView(ViewGroup c){
        addcard = (ImageView) view.findViewById(R.id.iv_review_title_add_card);
        cardgame = (ImageView) view.findViewById(R.id.iv_review_title_game);
        addcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddCard.class);
                startActivity(intent);
            }
        });
    }

}
