package com.example.hasee.cardreviewv3.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hasee.cardreviewv3.R;

/**
 * Created by hasee on 2018/4/10.
 * 复习的
 */

public class reviewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.review_lead,container, false);
    }

}
