package com.android.androidarchitecture;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.android.androidarchitecture.Presenter.MvpPresenter;
import com.android.androidarchitecture.Presenter.Presenter;
import com.android.androidarchitecture.View.MvpView;

/**
 * FileName: MvpActivity
 * Author: YuXin
 * Date: 2018/07/19 13:28
 * Describe:
 */
public class MvpActivity extends AppCompatActivity implements View.OnClickListener, MvpView {

    private MvpPresenter mPresenter;
    private ProgressDialog mProgressDialog;
    private AutoCompleteTextView mTextLabel;
    private Presenter mPresenter1;

    public static void goMvpActivity(Context context) {
        Intent intent = new Intent(context, MvpActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

//        mPresenter = new MvpPresenter(this);

        mPresenter1 = new Presenter();
        mPresenter1.attachView(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_success:
                mPresenter1.getData("normal");
                break;

            case R.id.button_failure:
                mPresenter1.getData("failure");
                break;

            case R.id.button_error:
                mPresenter1.getData("error");
                break;

            default:
                break;
        }
    }

    @Override
    public void showLoading() {
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showData(String data) {
        mTextLabel.setText(data);
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        mTextLabel.setText(msg);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "网络请求数据出现异常", Toast.LENGTH_SHORT).show();
        mTextLabel.setText("网络请求数据出现异常");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter1.detachView();
    }
}
