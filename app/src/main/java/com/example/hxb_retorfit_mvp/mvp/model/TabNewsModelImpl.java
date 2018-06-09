package com.example.hxb_retorfit_mvp.mvp.model;


import com.example.hxb_retorfit_mvp.mvp.Bean.BaseBean;
import com.example.hxb_retorfit_mvp.network.NetWorkRequest;
import com.example.hxb_retorfit_mvp.network.NetWorkSubscriber;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/9
 *  @描述 ：TabNewsModelImpl
 */
public class TabNewsModelImpl implements BaseModel.TabNewsModel {


    @Override
    public void netWork(final BaseDataBridge.TabNewsData tabNewsData) {

        NetWorkRequest.tabNews(new NetWorkSubscriber<BaseBean.TabNewsBean>() {
            @Override
            public void onError(Throwable e) {
                tabNewsData.error();
            }


            @Override
            public void onNext(BaseBean.TabNewsBean tabNewsBean) {
                tabNewsData.addData(tabNewsBean.getInfo());
            }
        });


    }
}
