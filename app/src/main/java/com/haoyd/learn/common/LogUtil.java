package com.haoyd.learn.common;

import android.content.Context;
import android.text.TextUtils;

import androidx.appcompat.app.AlertDialog;

public class LogUtil {

    private StringBuilder sb;
    private boolean isOpen = false;

    private static LogUtil instance = new LogUtil();

    private LogUtil() {
        sb = new StringBuilder();
    }

    public static LogUtil getInstance() {
        return instance;
    }

    public void add(String msg) {
        if (!isOpen || TextUtils.isEmpty(msg)) {
            return;
        }

        sb.append(msg + "\n");
    }

    public String getMsg() {
        if (sb.length() == 0) {
            return "未获取到日志信息";
        }

        return sb.toString();
    }

    public void clear() {
        if (sb.length() == 0) {
            return;
        }

        sb.delete(0, sb.length());
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void showDialog(Context context) {
        new AlertDialog.Builder(context)
                .setTitle("日志记录")
                .setMessage(getMsg())
                .setPositiveButton("确定", null)
                .show();
    }
}