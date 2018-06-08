package com.example.hxb_retorfit_mvp.utils;


import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hxb_retorfit_mvp.R;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8
 *  @描述 ：ImageLoaderUtils  图片加载工具
 */
public class ImageLoaderUtils {

    public static void display(@NonNull ImageView imageView, @NonNull String url, int placeholder, int error) {
        Glide.with(imageView.getContext()).load(url).placeholder(placeholder)
                .error(error).crossFade().into(imageView);
    }

    public static void display(@NonNull ImageView imageView, @NonNull Object url) {
        Glide.with(imageView.getContext()).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher).crossFade().into(imageView);
    }
}
