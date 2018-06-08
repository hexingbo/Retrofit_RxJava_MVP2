package com.example.hxb_retorfit_mvp.mvp.model;


import com.example.hxb_retorfit_mvp.mvp.Bean.ImageDetailInfo;
import com.example.hxb_retorfit_mvp.mvp.Bean.ImageListInfo;
import com.example.hxb_retorfit_mvp.mvp.Bean.ImageNewInfo;
import com.example.hxb_retorfit_mvp.mvp.Bean.NewsDetailInfo;
import com.example.hxb_retorfit_mvp.mvp.Bean.NewsListInfo;
import com.example.hxb_retorfit_mvp.mvp.Bean.TabNameInfo;
import com.example.hxb_retorfit_mvp.mvp.Bean.TabNewsInfo;

import java.util.List;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:56
 *  @描述 ：BaseDataBridge
 */
public interface BaseDataBridge<T> {

    void addData(List<T> datas);

    void error();


    interface ImageDetailData extends BaseDataBridge<ImageDetailInfo> {
    }

    interface ImageListData extends BaseDataBridge<ImageListInfo> {
    }

    interface ImageNewData extends BaseDataBridge<ImageNewInfo> {
    }

    interface NewsListData extends BaseDataBridge<NewsListInfo> {
    }

    interface NewsDetailData {
        void addData(NewsDetailInfo datas);

        void error();
    }

    interface TabNewsData extends BaseDataBridge<TabNewsInfo> {
    }

    interface TabNameData extends BaseDataBridge<TabNameInfo> {
    }
}
