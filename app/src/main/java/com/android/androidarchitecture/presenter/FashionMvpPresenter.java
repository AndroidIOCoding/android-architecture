package com.android.androidarchitecture.presenter;

import com.android.androidarchitecture.callback.BaseCallback;
import com.android.androidarchitecture.model.DataModel;
import com.android.androidarchitecture.model.Token;
import com.android.androidarchitecture.view.MvpView1;

/**
 * FileName: FashionMvpPresenter
 * Author: YuXin
 * Date: 2018/7/30 17:38
 * Describe: ${Describe}
 */
public class FashionMvpPresenter extends BasePresenter<MvpView1> {

    public void getData(String params) {

        if (!isViewAttached()) {
            return;
        }

        getView().showLoading();

        DataModel
                //设置请求标识的token
                .request(Token.API_USER_DATA)
                //添加请求参数，没有则不添加
                .params(params)
                .execute(new BaseCallback<String>() {
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
