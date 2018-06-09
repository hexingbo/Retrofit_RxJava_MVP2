package com.example.hxb_retorfit_mvp.mvp.presenter;


import com.example.hxb_retorfit_mvp.mvp.Bean.NewsDetailInfo;
import com.example.hxb_retorfit_mvp.mvp.model.BaseDataBridge;
import com.example.hxb_retorfit_mvp.mvp.model.BaseModel;
import com.example.hxb_retorfit_mvp.mvp.model.NewsDetailModelImpl;
import com.example.hxb_retorfit_mvp.mvp.view.BaseView;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/9
 *  @描述 ：NewsDetailPresenterImpl
 */
public class NewsDetailPresenterImpl extends BasePresenterImpl<BaseView.NewsDetailView>
        implements BasePresenter.NewsDetailPresenter, BaseDataBridge.NewsDetailData {

    private final BaseModel.NewsDetailModel newsDetailModel;

    public NewsDetailPresenterImpl(BaseView.NewsDetailView view) {
        super(view);
        newsDetailModel = new NewsDetailModelImpl();
    }

    @Override
    public void requestNetWork(int id) {
        view.showProgress();
        newsDetailModel.netWorkNewsDetail(id, this);
    }

    @Override
    public void addData(NewsDetailInfo datas) {
        view.setData(datas);
        view.hideProgress();
    }


    @Override
    public void error() {
        view.hideProgress();
        view.netWorkError();
    }
}
