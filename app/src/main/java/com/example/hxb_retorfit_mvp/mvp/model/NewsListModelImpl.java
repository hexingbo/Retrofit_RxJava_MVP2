package com.example.hxb_retorfit_mvp.mvp.model;


import com.example.hxb_retorfit_mvp.mvp.Bean.BaseBean;
import com.example.hxb_retorfit_mvp.network.NetWorkRequest;
import com.example.hxb_retorfit_mvp.network.NetWorkSubscriber;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:58
 *  @描述 ：NewsListModelImpl
 */
public class NewsListModelImpl implements BaseModel.NewsListModel {


    @Override
    public void netWorkNewList(int id, int page, final BaseDataBridge.NewsListData newsListData) {

        NetWorkRequest.newsList(id, page, new NetWorkSubscriber<BaseBean.NewsListBean>() {

            @Override
            public void onError(Throwable e) {
                newsListData.error();
            }


            @Override
            public void onNext(BaseBean.NewsListBean newsListBean) {
                newsListData.addData(newsListBean.getInfo());
            }
        });
    }


}
