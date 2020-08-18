package com.haoyd.learn.fragmentlifecycle;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.haoyd.learn.R;
import com.haoyd.learn.common.BaseActivity;
import com.haoyd.learn.common.MsgShowActivity;

public class LifecycleFragmentActivity extends BaseActivity {

    private View container;

    private LifecycleFragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_fragment);

        container = findViewById(R.id.fl_lifecyle_fragment);
    }

    public void createFragment(View view) {
        fragment = new LifecycleFragment();
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fl_lifecyle_fragment, fragment);
        transaction.commit();
    }

    public void showFragment(View view) {
        container.setVisibility(View.VISIBLE);
    }

    public void hideFragment(View view) {
        container.setVisibility(View.INVISIBLE);
    }

    public void jump(View view) {
        MsgShowActivity.start(this, "test");
    }
}
