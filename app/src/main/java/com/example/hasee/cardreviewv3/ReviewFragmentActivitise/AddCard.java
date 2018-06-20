package com.example.hasee.cardreviewv3.ReviewFragmentActivitise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hasee.cardreviewv3.R;

public class AddCard extends AppCompatActivity implements View.OnClickListener{
    private ImageView back;
    private Button choosebag;//
//    public String[] groupString = {"人文社科", "自然科学", "计算机科学", "其他"};
//    public String[][] childString = {
//            {"语文", "哲学", "心理学", "英语"},
//            {"物理", "化学", "数学"},
//            {"语言学习", "开发模式", "移动开发", "后端学习", "考试认证"},
//            {"其他", "心情"}
//
//    };
//    private MyDialog myDialog;
//    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("244","22211133333");
        setContentView(R.layout.activity_add_card);
        Log.d("244","222111");
        init();
        Log.d("244","222555");
    }

    private void init() {
        choosebag = (Button) findViewById(R.id.btn_choosebag);
        back = (ImageView)findViewById(R.id.iv_back);
        choosebag.setOnClickListener(this);
//        myDialog = new MyDialog(this,R.layout.dialog_choosbag,
//                new int[]{R.id.elv_cardkind});
//        myDialog.setOnCenterItemClickListener((MyDialog.OnCenterItemClickListener) this);
//        final ExpandableListView expandableListView = myDialog.findViewById(R.id.elv_cardkind);
    }

    @Override
    public void onClick(View v) {
        Log.e("233","11111");
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_choosebag:
                Log.d("244","221");
                startActivity(new Intent(AddCard.this,DialogchoosebagActivity.class));
                break;

        }
    }

//    /**
//     * 点击选择卡包
//     */
//    private void Coosebag() {
//        MyDialog myDialog = new MyDialog(getBaseContext());
//        myDialog.setContentView(R.layout.dialog_choosbag);
//        Log.d("244","222");
//        final ExpandableListView expandableListView = myDialog.findViewById(R.id.elv_cardkind);
//        //设置分组的监听
//        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//                Toast.makeText(getApplicationContext(), groupString[groupPosition], Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//        //设置子项布局监听
//        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//                Toast.makeText(getApplicationContext(), childString[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
//                return true;
//
//            }
//        });
//        //控制他只能打开一个组
//        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                int count = new MyExtendableListViewAdapter().getGroupCount();
//                for (int i = 0; i < count; i++) {
//                    if (i != groupPosition) {
//                        expandableListView.collapseGroup(i);
//                    }
//                }
//            }
//        });
//        Log.d("244","333");
//        myDialog.show();
//        Log.d("244","666");
//    }

//    @Override
//    public void OnCenterItemClick(MyDialog dialog, View view) {
//        switch (view.getId()){
//            case R.id.elv_cardkind:
//                expandableListView.setAdapter(new MyExtendableListViewAdapter());
//                //设置分组的监听
//                expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//                    @Override
//                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//                        Toast.makeText(getApplicationContext(), groupString[groupPosition], Toast.LENGTH_SHORT).show();
//                        return false;
//                    }
//                });
//                //设置子项布局监听
//                expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//                    @Override
//                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//                        Toast.makeText(getApplicationContext(), childString[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
//                        return true;
//
//                    }
//                });
//                //控制他只能打开一个组
//                expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//                    @Override
//                    public void onGroupExpand(int groupPosition) {
//                        int count = new MyExtendableListViewAdapter().getGroupCount();
//                        for (int i = 0; i < count; i++) {
//                            if (i != groupPosition) {
//                                expandableListView.collapseGroup(i);
//                            }
//                        }
//                    }
//                });
//                default:
//                    break;
//        }


}




