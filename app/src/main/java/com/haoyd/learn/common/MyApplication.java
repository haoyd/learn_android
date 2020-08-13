package com.haoyd.learn.common;

import android.app.Application;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ToastUtil.context = this;
    }
}
