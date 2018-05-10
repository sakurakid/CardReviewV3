package com.example.hasee.cardreviewv3.SearchFragmentActivitise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hasee.cardreviewv3.R;

import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;

public class SearchViewActivity extends AppCompatActivity {
    private SearchView searchView;//搜索框

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        searchView = (SearchView)findViewById(R.id.search_view);
        //获得搜索的内容string
        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {

            }
        });
        //点击返回键的按钮
        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });
    }
}
