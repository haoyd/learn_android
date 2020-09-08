package com.haoyd.learn.functions.fragmentlifecycle;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.haoyd.learn.R;
import com.haoyd.learn.common.LogUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class LifecycleFragment extends Fragment {

    public static final String TAG = "LifecycleFragment";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtil.getInstance().add(TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.getInstance().add(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtil.getInstance().add(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_lifecycle, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.getInstance().add(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.getInstance().add(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.getInstance().add(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.getInstance().add(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.getInstance().add(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.getInstance().add(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.getInstance().add(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.getInstance().add(TAG, "onDetach");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        LogUtil.getInstance().add(TAG, "onHiddenChanged");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        LogUtil.getInstance().add(TAG, "setUserVisibleHint");
    }
}
