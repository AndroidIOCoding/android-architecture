package com.android.androidarchitecture.presenter;

import com.android.androidarchitecture.view.BaseView;

/**
 * FileName: BasePresenter
 * Author: YuXin
 * Date: 2018/7/19 15:29
 * Describe: ${Describe}
 */
public class BasePresenter<V extends BaseView> {

    private V mvpView;

    public void attachedView(V mvpView) {
        this.mvpView = mvpView;
    }

    public void detachView() {
        this.mvpView = null;
    }

    public boolean isViewAttached() {
        return mvpView != null;
    }

    public V getView() {
        return mvpView;
    }
}
