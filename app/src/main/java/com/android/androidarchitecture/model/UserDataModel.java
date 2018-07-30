package com.android.androidarchitecture.model;

import android.os.Handler;

import com.android.androidarchitecture.callback.BaseCallback;

/**
 * FileName: UserDataModel
 * Author: YuXin
 * Date: 2018/7/30 17:07
 * Describe: ${Describe}
 */
public class UserDataModel extends BaseModel<String> {
    @Override
    public void execute(final BaseCallback<String> callback) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (mParams[0]) {
                    case "normal":
                        callback.onSuccess("根据参数" + mParams[0] + "的请求数据成功");
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
