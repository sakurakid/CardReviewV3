package com.example.hasee.cardreviewv3.ReviewFragmentActivitise;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.hasee.cardreviewv3.R;
import com.example.hasee.cardreviewv3.viewBase.MyExtendableListViewAdapter;

import static com.example.hasee.cardreviewv3.R.id;
import static com.example.hasee.cardreviewv3.R.layout;

/**
 * 选择卡包的dialog的活动
 */
public class DialogchoosebagActivity extends Activity {
    private ExpandableListView expandableListView;

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
        setFinishOnTouchOutside(true);
        setContentView(layout.activity_dialogchoosebag);

        expandableListView = (ExpandableListView)findViewById(id.elv_cardkind);
        expandableListView.setAdapter(new MyExtendableListViewAdapter());
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

                LayoutInflater factorys = LayoutInflater.from(DialogchoosebagActivity.this);
                final View buttonEntryView = factorys.inflate(layout.activity_add_card, null);
                Button b = (Button) buttonEntryView.findViewById(R.id.btn_choosebag);

                String s = childString[groupPosition][childPosition];
                b.setText(s);
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
}

