package com.example.hasee.cardreviewv3.ReviewFragmentActivitise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hasee.cardreviewv3.R;
import com.example.hasee.cardreviewv3.viewBase.MyDialog;
import com.example.hasee.cardreviewv3.viewBase.MyExtendableListViewAdapter;

public class AddCard extends AppCompatActivity {
    private ImageView back;
    private Button choosebag;//
    public String[] groupString = {"人文社科", "自然科学", "计算机科学", "其他"};
    public String[][] childString = {
            {"语文", "哲学", "心理学", "英语"},
            {"物理", "化学", "数学"},
            {"语言学习", "开发模式", "移动开发", "后端学习","考试认证"},
            {"其他","心情"}

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        back = (ImageView)findViewById(R.id.iv_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        init();
    }
    private void init(){
        choosebag = (Button)findViewById(R.id.btn_choosebag);
        choosebag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog myDialog = new MyDialog(getBaseContext());
                myDialog.setContentView(R.layout.dialog_choosbag);
                final ExpandableListView expandableListView = myDialog.findViewById(R.id.elv_cardkind);
                //设置分组的监听
                expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                        Toast.makeText(getApplicationContext(), groupString[groupPosition], Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                //设置子项布局监听
                expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                        Toast.makeText(getApplicationContext(), childString[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
                        return true;

                    }
                });
                //控制他只能打开一个组
                expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                    @Override
                    public void onGroupExpand(int groupPosition) {
                        int count = new MyExtendableListViewAdapter().getGroupCount();
                        for(int i = 0;i < count;i++){
                            if (i!=groupPosition){
                                expandableListView.collapseGroup(i);
                            }
                        }
                    }
                });

            }
        });
    }
}
