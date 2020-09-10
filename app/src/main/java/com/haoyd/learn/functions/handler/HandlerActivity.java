package com.haoyd.learn.functions.handler;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.haoyd.learn.R;
import com.haoyd.learn.common.BaseActivity;

public class HandlerActivity extends BaseActivity {

    private ProgressBar progressBar;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        progressBar = findViewById(R.id.pb_handler);
        editText = findViewById(R.id.et_handler);
    }

    public void requestOnMainThread(View view) throws InterruptedException {
        doLongTimeOperation();
    }

    public void requestOnChildThread(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doLongTimeOperation();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 执行耗时操作
     */
    private void doLongTimeOperation() throws InterruptedException {
        progressBar.setVisibility(View.VISIBLE);

        Thread.sleep(getOperationTime());

        progressBar.setVisibility(View.GONE);
    }

    /**
     * 获取用户输入的执行时间
     * @return
     */
    private int getOperationTime() {
        String timeStr = editText.getText().toString();

        if (TextUtils.isEmpty(timeStr)) {
            return 1000;
        }

        return Integer.parseInt(timeStr) * 1000;
    }
}
