package com.example.hxb_retorfit_mvp.mvp.presenter;


import android.content.pm.PackageManager;
import android.widget.Toast;

import com.example.hxb_retorfit_mvp.R;
import com.example.hxb_retorfit_mvp.constant.Constant;
import com.example.hxb_retorfit_mvp.mvp.Bean.ImageDetailInfo;
import com.example.hxb_retorfit_mvp.mvp.model.BaseDataBridge;
import com.example.hxb_retorfit_mvp.mvp.model.BaseModel;
import com.example.hxb_retorfit_mvp.mvp.model.ImageDetailModelImpl;
import com.example.hxb_retorfit_mvp.mvp.view.BaseView;
import com.example.hxb_retorfit_mvp.utils.UIUtils;

import java.util.List;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/9
 *  @描述 ：ImageDetailPresenterImpl
 */
public class ImageDetailPresenterImpl extends BasePresenterImpl<BaseView.ImageDetailView>
        implements BasePresenter.ImageDetailPresenter, BaseDataBridge.ImageDetailData {

    private final BaseModel.ImageDetailModel imageDetailModel;

    public ImageDetailPresenterImpl(BaseView.ImageDetailView view) {
        super(view);
        this.imageDetailModel = new ImageDetailModelImpl();
    }


    @Override
    public void requestNetWork(int id) {
        imageDetailModel.netWorkDetail(id, this);
    }

    @Override
    public void competence(int requestCode, int[] grantResults) {
        if (requestCode == Constant.WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(UIUtils.getContext(), UIUtils.getString(R.string.competence_error), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void addData(List<ImageDetailInfo> imageDetailInfo) {
        view.setData(imageDetailInfo);
    }

    @Override
    public void error() {
        view.netWorkError();
    }
}
