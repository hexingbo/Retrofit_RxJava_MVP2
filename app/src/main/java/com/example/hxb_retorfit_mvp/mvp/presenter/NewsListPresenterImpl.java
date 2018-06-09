package com.example.hxb_retorfit_mvp.mvp.presenter;


import com.example.hxb_retorfit_mvp.activity.NewsDetailActivity;
import com.example.hxb_retorfit_mvp.mvp.Bean.NewsListInfo;
import com.example.hxb_retorfit_mvp.mvp.model.BaseDataBridge;
import com.example.hxb_retorfit_mvp.mvp.model.BaseModel;
import com.example.hxb_retorfit_mvp.mvp.model.NewsListModelImpl;
import com.example.hxb_retorfit_mvp.mvp.view.BaseView;

import java.util.List;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/9
 *  @描述 ：NewsListPresenterImpl
 */
public class NewsListPresenterImpl extends BasePresenterImpl<BaseView.NewsListView>
        implements BasePresenter.NewsListPresenter, BaseDataBridge.NewsListData {

    private final BaseModel.NewsListModel newsListModel;

    public NewsListPresenterImpl(BaseView.NewsListView view) {
        super(view);
        this.newsListModel = new NewsListModelImpl();
    }


    @Override
    public void requestNetWork(int id, int page) {
        if (page == 1) {
            view.showProgress();
        } else {
            view.showFoot();
        }
        newsListModel.netWorkNewList(id, page, this);
    }

    @Override
    public void onClick(NewsListInfo info) {
        NewsDetailActivity.startIntent(info.getId());
    }


    @Override
    public void addData(List<NewsListInfo> tngou) {
        view.setData(tngou);
        view.hideFoot();
        view.hideProgress();
    }

    @Override
    public void error() {
        view.hideFoot();
        view.hideProgress();
        view.netWorkError();
    }
}
