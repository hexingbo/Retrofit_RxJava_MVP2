package com.example.hxb_retorfit_mvp.mvp.model;


import com.example.hxb_retorfit_mvp.mvp.Bean.BaseBean;
import com.example.hxb_retorfit_mvp.network.NetWorkRequest;
import com.example.hxb_retorfit_mvp.network.NetWorkSubscriber;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:58
 *  @描述 ：ImageListModelImpl
 */
public class ImageListModelImpl implements BaseModel.ImageListModel {

    @Override
    public void netWorkList(int id, final int page, final BaseDataBridge.ImageListData imageListData) {

        NetWorkRequest.imageList(id, page, new NetWorkSubscriber<BaseBean.ImageListBean>() {
            @Override
            public void onError(Throwable e) {
                imageListData.error();
            }


            @Override
            public void onNext(BaseBean.ImageListBean imageListBean) {
                imageListData.addData(imageListBean.getInfo());
            }
        });
    }


}
