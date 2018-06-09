package com.example.hxb_retorfit_mvp.mvp.presenter;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/9
 *  @描述 ：BasePresenterImpl
 */
public class BasePresenterImpl<T> {

    T view;

    public BasePresenterImpl(T view) {
        this.view = view;
    }

}
