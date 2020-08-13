package com.haoyd.learn.common;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

public class ToastUtil {

    public static Context context;

    public static void show(String msg) {
        if (context == null || TextUtils.isEmpty(msg)) {
            return;
        }

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
