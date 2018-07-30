package com.android.androidarchitecture.model;

import android.os.Handler;

import com.android.androidarchitecture.callback.BaseCallback;

/**
 * FileName: MvpModel1
 * Author: YuXin
 * Date: 2018/7/19 15:52
 * Describe: ${Describe}
 */
public class MvpModel1 {

    public static void getNetData(final String param, final BaseCallback<String> callback) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                switch (param) {
                    case "normal":
                        callback.onSuccess("根据请求" + param + "的请求网络数据成功");
                        break;

                    case "failure":
                        callback.onFailure("请求失败：参数有误");
                        break;

                    case "error":
                        callback.onError();
                        break;
                }
                callback.onComplete();
            }
        }, 3000);
    }
}
