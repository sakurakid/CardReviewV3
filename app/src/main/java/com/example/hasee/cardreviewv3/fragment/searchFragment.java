package com.example.hasee.cardreviewv3.fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hasee.cardreviewv3.R;
import com.ryane.banner.AdPageInfo;
import com.ryane.banner.AdPlayBanner;
import com.ryane.banner.transformer.FadeInFadeOutTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2018/4/10.
 */

public class searchFragment extends Fragment {
    private View view;
    private AdPlayBanner mAdPlayBanner;//轮播图控件
    List<AdPageInfo> mDatas = new ArrayList<>();//轮播图的加载的东西
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search,container, false);
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getActivity().getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        initView(container);
        return view;
    }
    /**
     * 绑定
     * @param c
     */
    private void initView(ViewGroup c){
        mAdPlayBanner = (AdPlayBanner)view.findViewById(R.id.iv_banner);
        makeBanner();
    }

    /**
     * 处理轮播图的函数
     */
    private void makeBanner(){
        AdPageInfo info1 = new AdPageInfo("图片1","http://pic1.win4000.com/wallpaper/c/51593661a65fa.jpg","链接三",4);
        AdPageInfo info2 = new AdPageInfo("图片2","http://kto-chto-gde.ru/wp-content/uploads/2017/01/mobile-wallpaper.jpg","链接二",1);
        AdPageInfo info3 = new AdPageInfo("图片3","http://www.qnong.com.cn/uploadfile/2016/0823/20160823075841234.jpg","链接一",2);
        AdPageInfo info4 = new AdPageInfo("图片4","http://maoup.com.tw/wp-content/uploads/2015/04/10245682123_095f60b432_o.jpg","链接四",3);
        mDatas.add(info1);
        mDatas.add(info2);
        mDatas.add(info3);
        mDatas.add(info4);



        mAdPlayBanner.setInfoList(mDatas)//设置轮播图片信息
                .setImageLoadType(AdPlayBanner.ImageLoaderType.PICASSO)//设置图片加载规则
                .setImageViewScaleType(AdPlayBanner.ScaleType.FIT_XY)//设置图片裁剪规则
                .setIndicatorType(AdPlayBanner.IndicatorType.POINT_INDICATOR)//设置导航器为点点
                .setPageTransformer(new FadeInFadeOutTransformer())//设置翻页动画
                .setAutoPlay(true)//自动轮播
                .setCanScroll(true)//手动
                .setInterval(5000)//轮播间隔
                .setOnPageClickListener(new AdPlayBanner.OnPageClickListener() {
                    @Override
                    public void onPageClick(AdPageInfo info, int position) {
                        switch (position){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;

                        }
                    }
                })
                .setUp();
    }
}
