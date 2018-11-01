package com.example.hasee.cardreviewv3.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hasee.cardreviewv3.Adapter.CardPackageAdapter;
import com.example.hasee.cardreviewv3.BagFragmentActivitise.AddBag;
import com.example.hasee.cardreviewv3.R;
import com.example.hasee.cardreviewv3.db.CardPackage;
import com.example.hasee.cardreviewv3.db.ResultBeanCarPackage;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hasee on 2018/4/10.
 * 卡包的
 */

public class bagFragment extends Fragment {
    private View view;
    private ImageView addbag;//添加卡包
    private ImageView update;//更新卡包数据

    private String token;//请求的时候的token

   private List<CardPackage> cardPackageList = new ArrayList<>();//卡包的数据
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
        SharedPreferences preferences = getActivity().getSharedPreferences("Token", Context.MODE_PRIVATE);
        token = preferences.getString("Token","");


        init();
        //findAllCardPackage();
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.re_BagAll);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        CardPackageAdapter adapter = new CardPackageAdapter(cardPackageList);
        recyclerView.setAdapter(adapter);
    }
    private void init(){
        for (int i = 0;i < 18;i++){
            CardPackage card = new CardPackage(i+"呜呜呜","http://att.bbs.duowan.com/forum/201611/07/1854591iuaxsub3bldtutq.png");
            cardPackageList.add(card);
        }
    }
    private void findAllCardPackage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://diamond.creatshare.com/package/find")
                            .addHeader("Authorization",token)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    Log.d("233",responseData);
                    ResultBeanCarPackage resultBeanCarPackage = new Gson().fromJson(responseData,ResultBeanCarPackage.class);
                    cardPackageList = resultBeanCarPackage.getData();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
