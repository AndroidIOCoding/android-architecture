package com.android.androidarchitecture.fragment;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.androidarchitecture.activity.BaseFragmentActivity;
import com.android.androidarchitecture.view.BaseView;

/**
 * FileName: BaseFragment
 * Author: YuXin
 * Date: 2018/7/19 16:59
 * Describe: ${Describe}
 */
public abstract class BaseFragment extends Fragment implements BaseView {

    public abstract int getContentViewId();

    protected Context mContext;
    protected View mRootView;

    protected abstract void initAllMembersView(Bundle savedInstanceState);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentViewId(), container, false);
        this.mContext = getActivity();
        initAllMembersView(savedInstanceState);
        return mRootView;
    }

    @Override
    public void showLoading() {
        checkActivityAttached();
        ((BaseFragmentActivity) mContext).showLoading();
    }

    @Override
    public void hideLoading() {
        checkActivityAttached();
        ((BaseFragmentActivity) mContext).hideLoading();
    }

    @Override
    public void showToast(String msg) {
        checkActivityAttached();
        ((BaseFragmentActivity) mContext).showToast(msg);
    }

    @Override
    public void showErr() {
        ((BaseFragmentActivity) mContext).showErr();
    }

    protected boolean isAttachedContext() {
        return getActivity() != null;
    }

    public void checkActivityAttached() {
        if (getActivity() == null) {
            throw new ActivityNotAttachedException();
        }
    }

    public static class ActivityNotAttachedException extends RuntimeException {
        public ActivityNotAttachedException() {
            super("Fragment has disconnected from Activity!");
        }
    }
}
