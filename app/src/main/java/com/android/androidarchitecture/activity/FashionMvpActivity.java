package com.android.androidarchitecture.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.AutoCompleteTextView;

import com.android.androidarchitecture.R;
import com.android.androidarchitecture.presenter.FashionMvpPresenter;
import com.android.androidarchitecture.view.MvpView1;

/**
 * FileName: FashionMvpActivity
 * Author: YuXin
 * Date: 2018/7/30 17:32
 * Describe: ${Describe}
 */
public class FashionMvpActivity extends BaseActivity implements View.OnClickListener, MvpView1 {

    private ProgressDialog mProgressDialog;
    private AutoCompleteTextView mTextLabel;
    private FashionMvpPresenter mFashionMvpPresenter;

    public static void goFashionMvpActivity(Context context) {
        Intent intent = new Intent(context, FashionMvpActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        initView();
        init();
    }

    private void initView() {
        mTextLabel = findViewById(R.id.text_label);
        AppCompatButton button_success = findViewById(R.id.button_success);
        AppCompatButton button_failure = findViewById(R.id.button_failure);
        AppCompatButton button_error = findViewById(R.id.button_error);
        button_success.setOnClickListener(this);
        button_failure.setOnClickListener(this);
        button_error.setOnClickListener(this);
    }

    private void init() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("正在加载数据");

        mFashionMvpPresenter = new FashionMvpPresenter();
        mFashionMvpPresenter.attachedView(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_success:
                mFashionMvpPresenter.getData("normal");
                break;

            case R.id.button_failure:
                mFashionMvpPresenter.getData("failure");
                break;

            case R.id.button_error:
                mFashionMvpPresenter.getData("error");
                break;

            default:
                break;
        }
    }

    @Override
    public void showData(String data) {
        mTextLabel.setText(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFashionMvpPresenter.detachView();
    }
}
