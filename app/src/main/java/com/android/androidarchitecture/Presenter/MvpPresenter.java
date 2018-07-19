package com.android.androidarchitecture.Presenter;

import com.android.androidarchitecture.Callback.MvpCallback;
import com.android.androidarchitecture.Model.MvpModel;
import com.android.androidarchitecture.View.MvpView;

/**
 * FileName: MvpPresenter
 * Author: YuXin
 * Date: 2018/7/19 13:02
 * Describe: ${Describe}
 */
public class MvpPresenter {

    /**
     * View接口
     */
    private MvpView mView;

    public MvpPresenter(MvpView view) {
        this.mView = view;
    }

    public void getData(String param) {
        /*
         * 显示正在加载进度条
         */
        mView.showLoading();
        /*
         * 调用Model请求数据
         */
        MvpModel.getNetData(param, new MvpCallback() {
            @Override
            public void onSuccess(String data) {
                /*
                 * 调用View接口，显示数据
                 */
                mView.showData(data);
            }

            @Override
            public void onFailure(String msg) {
                /*
                 * 调用View接口，提示失败信息
                 */
                mView.showFailureMessage(msg);
            }

            @Override
            public void onError() {
                /*
                 * 调用View接口，提示请求异常
                 */
                mView.showErrorMessage();
            }

            @Override
            public void onComplete() {
                /*
                 * 隐藏正在加载进度条
                 */
                mView.hideLoading();
            }
        });
    }
}
