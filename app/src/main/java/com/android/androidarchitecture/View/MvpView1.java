package com.android.androidarchitecture.View;

/**
 * FileName: MvpView1
 * Author: YuXin
 * Date: 2018/7/19 15:42
 * Describe: ${Describe}
 */
public interface MvpView1 extends BaseView {

    /**
     * 当数据请求成功后，调用此接口显示数据
     *
     * @param data 数据源
     */
    void showData(String data);
}
