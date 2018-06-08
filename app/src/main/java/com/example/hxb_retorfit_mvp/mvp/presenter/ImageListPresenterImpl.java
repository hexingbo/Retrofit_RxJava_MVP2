package com.example.hxb_retorfit_mvp.mvp.presenter;


import com.example.hxb_retorfit_mvp.activity.ImageDetailActivity;
import com.example.hxb_retorfit_mvp.mvp.Bean.ImageListInfo;
import com.example.hxb_retorfit_mvp.mvp.model.BaseDataBridge;
import com.example.hxb_retorfit_mvp.mvp.model.BaseModel;
import com.example.hxb_retorfit_mvp.mvp.model.ImageListModelImpl;
import com.example.hxb_retorfit_mvp.mvp.view.BaseView;

import java.util.List;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 17:00
 *  @描述 ：ImageListPresenterImpl
 */
public class ImageListPresenterImpl extends BasePresenterImpl<BaseView.ImageListView>
        implements BasePresenter.ImageListPresenter, BaseDataBridge.ImageListData {

    private final BaseModel.ImageListModel imageListModel;

    public ImageListPresenterImpl(BaseView.ImageListView view) {
        super(view);
        this.imageListModel = new ImageListModelImpl();
    }

    @Override
    public void requestNetWork(int id, int page) {
        if (page == 1) {
            view.showProgress();
        } else {
            view.showFoot();
        }
        imageListModel.netWorkList(id, page, this);
    }


    @Override
    public void onClick(ImageListInfo info) {
        ImageDetailActivity.startIntent(info.getId(), info.getTitle());
    }


    @Override
    public void addData(List<ImageListInfo> imageListInfo) {
        view.setData(imageListInfo);
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
