package com.example.hxb_retorfit_mvp.utils;


import android.content.Context;

import com.example.hxb_retorfit_mvp.constant.MyApplication;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8
 *  @描述 ：UIUtils
 */
public class UIUtils {


    public static Context getContext() {
        return MyApplication.getContext();
    }

    public static String getString(int id) {
        return getContext().getResources().getString(id);
    }
}
