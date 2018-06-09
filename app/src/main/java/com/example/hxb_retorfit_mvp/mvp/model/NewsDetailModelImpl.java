package com.example.hxb_retorfit_mvp.mvp.model;


import com.example.hxb_retorfit_mvp.mvp.Bean.NewsDetailInfo;
import com.example.hxb_retorfit_mvp.network.NetWorkRequest;
import com.example.hxb_retorfit_mvp.network.NetWorkSubscriber;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/9
 *  @描述 ：NewsDetailModelImpl
 */
public class NewsDetailModelImpl implements BaseModel.NewsDetailModel {

    @Override
    public void netWorkNewsDetail(int id, final BaseDataBridge.NewsDetailData newsDetailData) {

        NetWorkRequest.newsDetail(id, new NetWorkSubscriber<NewsDetailInfo>() {
            @Override
            public void onError(Throwable e) {
                super.onError(e);
                newsDetailData.error();
            }

            @Override
            public void onNext(NewsDetailInfo newsDetailInfo) {
                super.onNext(newsDetailInfo);
                newsDetailData.addData(newsDetailInfo);
            }
        });


    }
}
