package com.example.hxb_retorfit_mvp.mvp.presenter;


import com.example.hxb_retorfit_mvp.mvp.Bean.TabNewsInfo;
import com.example.hxb_retorfit_mvp.mvp.model.BaseDataBridge;
import com.example.hxb_retorfit_mvp.mvp.model.BaseModel;
import com.example.hxb_retorfit_mvp.mvp.model.TabNewsModelImpl;
import com.example.hxb_retorfit_mvp.mvp.view.BaseView;

import java.util.List;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/9
 *  @描述 ：TabNewsPresenterImpl
 */
public class TabNewsPresenterImpl extends BasePresenterImpl<BaseView.TabNewsView>
        implements BasePresenter.TabNewsPresenter, BaseDataBridge.TabNewsData {


    private final BaseModel.TabNewsModel tabNewsModel;

    public TabNewsPresenterImpl(BaseView.TabNewsView view) {
        super(view);
        this.tabNewsModel = new TabNewsModelImpl();
    }


    @Override
    public void requestNetWork() {
        tabNewsModel.netWork(this);
    }

    @Override
    public void addData(List<TabNewsInfo> newsInfo) {
        view.setData(newsInfo);
    }

    @Override
    public void error() {
        view.netWorkError();
    }
}
