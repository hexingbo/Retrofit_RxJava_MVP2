package com.example.hxb_retorfit_mvp.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.hxb_retorfit_mvp.utils.LogUtils;
import com.example.hxb_retorfit_mvp.utils.RxUtils;

import butterknife.ButterKnife;

/**
 * Created by 贺兴波 on 2018/6/8.
 */

public  abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        LogUtils.i("BaseActivity", getClass().getSimpleName());
        ButterKnife.bind(this);
    }

    protected void Toast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxUtils.getInstance().unSubscription();
    }
}
