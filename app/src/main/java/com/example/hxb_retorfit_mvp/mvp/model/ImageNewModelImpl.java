package com.example.hxb_retorfit_mvp.mvp.model;


import com.example.hxb_retorfit_mvp.mvp.Bean.BaseBean;
import com.example.hxb_retorfit_mvp.network.NetWorkRequest;
import com.example.hxb_retorfit_mvp.network.NetWorkSubscriber;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:58
 *  @描述 ：ImageNewModelImpl
 */
public class ImageNewModelImpl implements BaseModel.ImageNewModel {


    @Override
    public void netWorkNew(int id, int rows, final BaseDataBridge.ImageNewData imageNewData) {

        NetWorkRequest.imageNew(id, rows, new NetWorkSubscriber<BaseBean.ImageNewBean>() {
            @Override
            public void onError(Throwable e) {
                imageNewData.error();
            }


            @Override
            public void onNext(BaseBean.ImageNewBean imageNewBean) {
                imageNewData.addData(imageNewBean.getInfo());
            }
        });
    }


}
