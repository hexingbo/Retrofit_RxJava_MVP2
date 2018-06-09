package com.example.hxb_retorfit_mvp.mvp.presenter;


import com.example.hxb_retorfit_mvp.mvp.Bean.TabNameInfo;
import com.example.hxb_retorfit_mvp.mvp.model.BaseDataBridge;
import com.example.hxb_retorfit_mvp.mvp.model.BaseModel;
import com.example.hxb_retorfit_mvp.mvp.model.TabNameModelImpl;
import com.example.hxb_retorfit_mvp.mvp.view.BaseView;

import java.util.List;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/9
 *  @描述 ：TabNamePresenterImpl
 */
public class TabNamePresenterImpl extends BasePresenterImpl<BaseView.TabNameView>
        implements BasePresenter.TabNamePresenter, BaseDataBridge.TabNameData {

    private final BaseModel.TabNameModel tabNameModel;

    public TabNamePresenterImpl(BaseView.TabNameView view) {
        super(view);
        this.tabNameModel = new TabNameModelImpl();
    }


    @Override
    public void requestNetWork() {
        tabNameModel.netWork(this);
    }

    @Override
    public void addData(List<TabNameInfo> tabNameInfo) {
        view.setData(tabNameInfo);
    }

    @Override
    public void error() {
        view.netWorkError();
    }
}
