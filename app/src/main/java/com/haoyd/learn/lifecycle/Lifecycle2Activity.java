package com.haoyd.learn.lifecycle;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;

import com.haoyd.learn.R;
import com.haoyd.learn.common.BaseActivity;
import com.haoyd.learn.common.LogUtil;

public class Lifecycle2Activity extends BaseActivity {

    private static final String TAG = "Lifecycle2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle2);
        LogUtil.getInstance().add(TAG + " --> onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.getInstance().add(TAG + " --> onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.getInstance().add(TAG + " --> onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.getInstance().add(TAG + " --> onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.getInstance().add(TAG + " --> onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.getInstance().add(TAG + " --> onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.getInstance().add(TAG + " --> onDestroy");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        LogUtil.getInstance().add(TAG + " --> onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtil.getInstance().add(TAG + " --> onRestoreInstanceState");
    }
}
