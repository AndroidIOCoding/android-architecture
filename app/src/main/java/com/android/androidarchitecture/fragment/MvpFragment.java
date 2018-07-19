package com.android.androidarchitecture.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.androidarchitecture.R;

/**
 * FileName: MvpFragment
 * Author: YuXin
 * Date: 2018/7/19 18:50
 * Describe: ${Describe}
 */
public class MvpFragment extends BaseFragment {


    @Override
    public int getContentViewId() {
        return 0;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_normal_mvp, container, false);
        initView();
        return view;
    }

    private void initView() {

    }
}
