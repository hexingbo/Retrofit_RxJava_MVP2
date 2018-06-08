package com.example.hxb_retorfit_mvp.network;

import rx.Subscriber;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8
 *  @描述 ：NetWorkSubscriber
 */
public class NetWorkSubscriber<T> extends Subscriber<T> {


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
    }

    @Override
    public void onNext(T t) {
    }


}
