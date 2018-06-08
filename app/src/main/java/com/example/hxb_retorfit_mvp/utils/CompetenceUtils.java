package com.example.hxb_retorfit_mvp.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.example.hxb_retorfit_mvp.constant.Constant;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8
 *  @描述 ：CompetenceUtils 权限检测
 */
public class CompetenceUtils {

    /**
     * 读写内存的权限检测
     * @param activity
     */
    public static void storage(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, Constant.WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
        }
    }

}
