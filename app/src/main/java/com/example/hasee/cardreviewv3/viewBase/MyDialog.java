package com.example.hasee.cardreviewv3.viewBase;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.example.hasee.cardreviewv3.R;

/**
 * 自己写的dialog的类
 */
public class MyDialog extends Dialog {
    public MyDialog(Context context){
        this(context, R.style.dialogTheme);
    }

    public MyDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //提前设置Dialog的一些样式
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams p = dialogWindow.getAttributes();
//        p.x = 100;
//        p.y = 100;
        p.gravity = Gravity.CENTER_HORIZONTAL;
        dialogWindow.setAttributes(p);
    }
}

