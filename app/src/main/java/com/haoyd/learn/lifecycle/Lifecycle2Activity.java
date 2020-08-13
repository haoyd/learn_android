package com.haoyd.learn.lifecycle;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;

import com.haoyd.learn.R;
import com.haoyd.learn.common.BaseActivity;
import com.haoyd.learn.common.LogUtil;

public class Lifecycle2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle2);
        LogUtil.getInstance().add(tag, "onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.getInstance().add(tag, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.getInstance().add(tag, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.getInstance().add(tag, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.getInstance().add(tag, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.getInstance().add(tag, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.getInstance().add(tag, "onDestroy");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        LogUtil.getInstance().add(tag, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtil.getInstance().add(tag, "onRestoreInstanceState");
    }
}
