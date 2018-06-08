package com.example.hxb_retorfit_mvp.mvp.model;


import com.example.hxb_retorfit_mvp.mvp.Bean.BaseBean;
import com.example.hxb_retorfit_mvp.network.NetWorkRequest;
import com.example.hxb_retorfit_mvp.network.NetWorkSubscriber;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:58
 *  @描述 ：TabNameModelImpl
 */
public class TabNameModelImpl implements BaseModel.TabNameModel {


    @Override
    public void netWork(final BaseDataBridge.TabNameData tabNameData) {
        NetWorkRequest.tabName(new NetWorkSubscriber<BaseBean.TabNameBean>() {
            @Override
            public void onError(Throwable e) {
                tabNameData.error();
            }


            @Override
            public void onNext(BaseBean.TabNameBean tabNameBean) {
                tabNameData.addData(tabNameBean.getInfo());
            }
        });
    }


}
