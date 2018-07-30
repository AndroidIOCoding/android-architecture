package com.android.androidarchitecture.model;

import com.android.androidarchitecture.callback.BaseCallback;

import java.util.Map;

/**
 * FileName: BaseModel
 * Author: YuXin
 * Date: 2018/7/30 16:56
 * Describe: ${Describe}
 */
public abstract class BaseModel<T> {

    /**
     * 数据请求参数
     */
    protected String[] mParams;

    /**
     * 设置数据请求参数
     *
     * @param args 参数数组
     */
    public BaseModel params(String... args) {
        mParams = args;
        return this;
    }

    /**
     * 添加cCallback并执行数据请求
     * <p>
     * 具体的数据请求由子类实现
     */
    public abstract void execute(BaseCallback<T> callback);

    /**
     * 执行Get网络请求，此类看需求由自己选择写与不写
     */
    protected void requestGetAPI(String url, BaseCallback<T> callback) {

        // 这里学具体的网络请求
    }

    /**
     * 执行Post网络请求，此类看需求由自己选择写与不写
     */
    protected void requestPostAPI(String url, Map params, BaseCallback<T> callback) {

        // 这里写具体的网络请求
    }
}
