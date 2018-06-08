package com.example.hxb_retorfit_mvp.mvp.model;


import com.example.hxb_retorfit_mvp.mvp.Bean.BaseBean;
import com.example.hxb_retorfit_mvp.network.NetWorkRequest;
import com.example.hxb_retorfit_mvp.network.NetWorkSubscriber;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:58
 *  @描述 ：ImageDetailModelImpl
 */
public class ImageDetailModelImpl implements BaseModel.ImageDetailModel {


    @Override
    public void netWorkDetail(int id, final BaseDataBridge.ImageDetailData imageDetailData) {

        NetWorkRequest.imageDetail(id, new NetWorkSubscriber<BaseBean.ImageDetailBean>() {

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                imageDetailData.error();
            }


            @Override
            public void onNext(BaseBean.ImageDetailBean imageDetailBean) {
                super.onNext(imageDetailBean);
                imageDetailData.addData(imageDetailBean.getList());
            }
        });
    }


}
