package com.haoyd.learn.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.haoyd.learn.R;
import com.haoyd.learn.common.BaseActivity;
import com.haoyd.learn.common.LogUtil;

public class Lifecycle1Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle1);
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

    public void jump(View view) {
        Intent intent = new Intent(this, Lifecycle2Activity.class);
        intent.putExtra("pageTitle", "Activity 生命周期-页面2");
        startActivity(intent);
    }

    public void showAlert(View view) {
        new AlertDialog.Builder(this)
                .setTitle("弹窗")
                .setMessage("测试弹窗改变生命周期")
                .setPositiveButton("确定", null)
                .setCancelable(false)
                .show();
    }

    public void showDialogActivity(View view) {
        startActivity(new Intent(this, LifecycleDialogActivity.class));
    }

    public void clickHome(View view) {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // android提示如果是服务里调用，必须加入new task标识
        i.addCategory(Intent.CATEGORY_HOME);
        startActivity(i);
    }
}
