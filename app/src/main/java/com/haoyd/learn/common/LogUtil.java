package com.haoyd.learn.common;

import android.content.Context;
import android.text.TextUtils;

import androidx.appcompat.app.AlertDialog;

public class LogUtil {

    private StringBuilder sb;
    private boolean isOpen = false;

    // 程序会默认记录当前页面名称
    private String curTag = "";

    private static LogUtil instance = new LogUtil();

    private LogUtil() {
        sb = new StringBuilder();
    }

    public static LogUtil getInstance() {
        return instance;
    }

    /**
     * 如果同一时间只是记录当前页面的日志，则不需要传入具体 tag
     * @param msg
     */
    public void add(String msg) {
        if (!isOpen || TextUtils.isEmpty(msg)) {
            return;
        }

        sb.append(curTag + " --> " + msg + "\n");
    }

    /**
     * 如果同一时间会有多个页面输出日志，则需要传入相应的 tag
     * @param tag
     * @param msg
     */
    public void add(String tag, String msg) {
        if (!isOpen || TextUtils.isEmpty(tag) || TextUtils.isEmpty(msg)) {
            return;
        }

        sb.append(tag + " --> " + msg + "\n");
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

    public void setCurTag(String curTag) {
        this.curTag = curTag;
    }

    public void showLog(Context context) {
        new AlertDialog.Builder(context)
                .setTitle("日志记录")
                .setMessage(getMsg())
                .setPositiveButton("确定", null)
                .show();
    }
}