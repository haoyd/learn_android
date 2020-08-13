package com.haoyd.learn.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.haoyd.learn.R;

public class MsgShowActivity extends BaseActivity {

    private TextView textView;

    private String msg = "";

    public static void start(Context context, String msg) {
        Intent intent = new Intent(context, MsgShowActivity.class);
        intent.putExtra("pageTitle", "信息展示");
        intent.putExtra("msg", TextUtils.isEmpty(msg) ? "" : msg);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_show);

        textView = findViewById(R.id.tv_msg_show);
        msg = getIntent().getStringExtra("msg");
        textView.setText(TextUtils.isEmpty(msg) ? "未获取到信息" : msg);
    }
}
