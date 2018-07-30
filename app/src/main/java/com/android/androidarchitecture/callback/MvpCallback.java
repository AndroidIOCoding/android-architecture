package com.android.androidarchitecture.callback;

/**
 * FileName: MvpCallback
 * Author: YuXin
 * Date: 2018/7/19 11:39
 * Describe: ${Describe}
 */
public interface MvpCallback {

    /**
     * 数据请求成功
     *
     * @param data 请求到的数据
     */
    void onSuccess(String data);

    /**
     * 使用网络API接口请求方式时，虽然已经请求成功但是由于{@code msg}的原因无法正常返回数据。
     *
     * @param msg 请求失败信息
     */
    void onFailure(String msg);

    /**
     * 请求失败，指在网络API接口请求方式时，出现无法联网、缺少权限、内存泄漏等原因导致的无法连接请求到数据
     */
    void onError();

    /**
     * 当请求完数结束时，无论请求结果时成功、失败还是抛出异常都会执行此方法给用户处理
     * 通常做网络请求时可以在此时隐藏"正在加载"的等待控件
     */
    void onComplete();
}
