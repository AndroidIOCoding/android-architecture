package com.android.androidarchitecture.view;

import android.content.Context;

/**
 * FileName: BaseView
 * Author: YuXin
 * Date: 2018/7/19 15:26
 * Describe: ${Describe}
 */
public interface BaseView {

    void showLoading();

    void hideLoading();

    void showToast(String msg);

    void showErr();

    Context getContext();
}
