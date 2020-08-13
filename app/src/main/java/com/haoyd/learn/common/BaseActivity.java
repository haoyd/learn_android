package com.haoyd.learn.common;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.haoyd.learn.R;

public class BaseActivity extends AppCompatActivity {

    protected String tag = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tag = getClass().getSimpleName();

        processIntent();
        setView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 考虑到跳转到下一个页面再跳回来后依然需要更新当前 tag，需要在该生命周期更新当前 tag
        LogUtil.getInstance().setCurTag(tag);
    }

    private void processIntent() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }

        String pageTitle = intent.getStringExtra("pageTitle");
        if (TextUtils.isEmpty(pageTitle)) {
            return;
        }

        setTitle(pageTitle);
    }

    private void setView() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.base_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.m1:
                LogUtil.getInstance().setOpen(true);
                break;
            case R.id.m2:
                LogUtil.getInstance().setOpen(false);
                break;
            case R.id.m3:
                LogUtil.getInstance().showDialog(this);
                break;
            case R.id.m4:
                LogUtil.getInstance().clear();
                ToastUtil.show("清除成功");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
