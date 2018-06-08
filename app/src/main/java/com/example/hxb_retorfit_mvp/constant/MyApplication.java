package com.example.hxb_retorfit_mvp.constant;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.example.hxb_retorfit_mvp.utils.AppManager;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:55
 *  @描述 ：MyApplication
 */
public class MyApplication extends Application {


    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        AppManager.getInstance().init(this);
    }
}
