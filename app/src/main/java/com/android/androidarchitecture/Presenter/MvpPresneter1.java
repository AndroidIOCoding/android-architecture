package com.android.androidarchitecture.Presenter;

import com.android.androidarchitecture.Callback.BaseCallback;
import com.android.androidarchitecture.Model.MvpModel1;
import com.android.androidarchitecture.View.MvpView1;

/**
 * FileName: MvpPresneter1
 * Author: YuXin
 * Date: 2018/7/19 15:45
 * Describe: ${Describe}
 */
public class MvpPresneter1 extends BasePresenter<MvpView1> {

    public void getData(String params) {

        if (!isViewAttached()) {
            // 如果没有View引用就不加载数据
            return;
        }

        getView().showLoading();
        MvpModel1.getNetData(params, new BaseCallback<String>() {
            @Override
            public void onSuccess(String data) {
                if (isViewAttached()) {
                    getView().showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()) {
                    getView().showToast(msg);
                }
            }

            @Override
            public void onError() {
                if (isViewAttached()) {
                    getView().showErr();
                }
            }

            @Override
            public void onComplete() {
                if (isViewAttached()) {
                    getView().hideLoading();
                }
            }
        });
    }
}
