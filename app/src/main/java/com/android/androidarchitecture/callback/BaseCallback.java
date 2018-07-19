package com.android.androidarchitecture.callback;

/**
 * FileName: BaseCallback
 * Author: YuXin
 * Date: 2018/7/19 15:22
 * Describe: 带泛型的callback
 */
public interface BaseCallback<T> {

    void onSuccess(T data);

    void onFailure(String msg);

    void onError();

    void onComplete();
}
