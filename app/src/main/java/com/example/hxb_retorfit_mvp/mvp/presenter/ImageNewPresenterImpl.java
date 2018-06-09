package com.example.hxb_retorfit_mvp.mvp.presenter;


import android.text.TextUtils;
import android.widget.Toast;

import com.example.hxb_retorfit_mvp.R;
import com.example.hxb_retorfit_mvp.activity.ImageDetailActivity;
import com.example.hxb_retorfit_mvp.mvp.Bean.ImageNewInfo;
import com.example.hxb_retorfit_mvp.mvp.model.BaseDataBridge;
import com.example.hxb_retorfit_mvp.mvp.model.BaseModel;
import com.example.hxb_retorfit_mvp.mvp.model.ImageNewModelImpl;
import com.example.hxb_retorfit_mvp.mvp.view.BaseView;
import com.example.hxb_retorfit_mvp.utils.UIUtils;

import java.util.List;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/9
 *  @描述 ：ImageNewPresenterImpl
 */
public class ImageNewPresenterImpl extends BasePresenterImpl<BaseView.ImageNewView>
        implements BasePresenter.ImageNewPresenter, BaseDataBridge.ImageNewData {

    private final BaseModel.ImageNewModel imageNewModel;


    public ImageNewPresenterImpl(BaseView.ImageNewView view) {
        super(view);
        this.imageNewModel = new ImageNewModelImpl();
    }


    @Override
    public void requestNetWork(String id, String rows) {

        if (TextUtils.isEmpty(id)) {
            view.hideProgress();
            Toast.makeText(UIUtils.getContext(), UIUtils.getString(R.string.image_new_id), Toast.LENGTH_LONG).show();
        } else {
            if (TextUtils.isEmpty(rows)) {
                rows = "20";
            }
            view.offKeyBoard();
            view.showProgress();
            imageNewModel.netWorkNew(Integer.valueOf(id), Integer.valueOf(rows), this);
        }
    }

    @Override
    public void onClick(ImageNewInfo info) {
        ImageDetailActivity.startIntent(info.getId(), info.getTitle());
    }

    @Override
    public void addData(List<ImageNewInfo> imageNewInfo) {
        view.setData(imageNewInfo);
        view.hideProgress();
    }

    @Override
    public void error() {
        view.hideProgress();
        view.netWorkError();
    }
}
