package com.android.androidarchitecture.Presenter;

import com.android.androidarchitecture.Callback.MvpCallback;
import com.android.androidarchitecture.Model.MvpModel;
import com.android.androidarchitecture.View.MvpView;

/**
 * FileName: Presenter
 * Author: YuXin
 * Date: 2018/7/19 14:59
 * Describe: ${Describe}
 */
public class Presenter {

    private MvpView mView;

    /**
     * 构造方法中不再需要View参数
     */
    public Presenter() {

    }

    /**
     * 绑定View,一般在初始化中调用该方法
     *
     * @param mvpView View
     */
    public void attachView(MvpView mvpView) {
        this.mView = mvpView;
    }

    /**
     * 解绑View,一般在onDestroy中调用
     */
    public void detachView() {
        this.mView = null;
    }

    /**
     * 是否与View绑定，建立连接
     * <p>
     * 每次调用业务请求的时候，都要出先调用方法检查是否与View建立连接
     *
     * @return 返回是否绑定View
     */
    private boolean isViewAttached() {
        return mView != null;
    }

    public void getData(String param) {

        mView.showLoading();

        MvpModel.getNetData(param, new MvpCallback() {
            @Override
            public void onSuccess(String data) {
                if (isViewAttached()) {
                    mView.showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()) {
                    mView.showFailureMessage(msg);
                }
            }

            @Override
            public void onError() {
                if (isViewAttached()) {
                    mView.showErrorMessage();
                }
            }

            @Override
            public void onComplete() {
                if (isViewAttached()) {
                    mView.hideLoading();
                }
            }
        });
    }
}
