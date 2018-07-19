package com.android.androidarchitecture;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.AutoCompleteTextView;

import com.android.androidarchitecture.Presenter.MvpPresneter1;
import com.android.androidarchitecture.View.MvpView1;

public class NormalMvpActivity extends BaseActivity implements View.OnClickListener, MvpView1 {

    private AutoCompleteTextView mTextView;
    private MvpPresneter1 mMvpPresneter;

    public static void goNormalMvpActivity(Context context) {
        Intent intent = new Intent(context, NormalMvpActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        initView();
    }

    private void initView() {
        mTextView = findViewById(R.id.text_label);
        AppCompatButton button_success = findViewById(R.id.button_success);
        AppCompatButton button_failure = findViewById(R.id.button_failure);
        AppCompatButton button_error = findViewById(R.id.button_error);
        button_success.setOnClickListener(this);
        button_failure.setOnClickListener(this);
        button_error.setOnClickListener(this);

        mMvpPresneter = new MvpPresneter1();
        mMvpPresneter.attachedVIew(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_success:
                mMvpPresneter.getData("normal");
                break;

            case R.id.button_failure:
                mMvpPresneter.getData("failure");
                break;

            case R.id.button_error:
                mMvpPresneter.getData("error");
                break;

            default:
                break;
        }
    }

    @Override
    public void showData(String data) {
        mTextView.setText(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMvpPresneter.detachView();
    }
}
