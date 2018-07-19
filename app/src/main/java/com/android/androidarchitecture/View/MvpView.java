package com.android.androidarchitecture.View;

/**
 * FileName: MvpView
 * Author: YuXin
 * Date: 2018/7/19 11:56
 * Describe: ${Describe}
 */
public interface MvpView {

    /**
     * 显示正在加载进度框
     */
    void showLoading();

    /**
     * 隐藏正在加载进度框
     */
    void hideLoading();

    /**
     * 当数据请求成功后，调用此接口显示数据
     *
     * @param data 数据源
     */
    void showData(String data);

    /**
     * 数据请求失败后，调用此接口提示
     *
     * @param msg 失败原因
     */
    void showFailureMessage(String msg);

    /**
     * 数据请求异常，调用次接口
     */
    void showErrorMessage();
}