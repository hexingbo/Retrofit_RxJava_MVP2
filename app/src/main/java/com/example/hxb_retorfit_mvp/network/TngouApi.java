package com.example.hxb_retorfit_mvp.network;


import com.example.hxb_retorfit_mvp.mvp.Bean.BaseBean;
import com.example.hxb_retorfit_mvp.mvp.Bean.NewsDetailInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8
 *  @描述 ：TngouApi
 */
public interface TngouApi {


    @GET(ApiUrl.TAB_NEWS)
    Observable<BaseBean.TabNewsBean> getTabNews();


    @GET(ApiUrl.TAB_NAME)
    Observable<BaseBean.TabNameBean> getTabName();

    @GET(ApiUrl.NEWS_LIST)
    Observable<BaseBean.NewsListBean> getNewsList(@Query("id") int id, @Query("page") int page);


    @GET(ApiUrl.NEWS_SHOW)
    Observable<NewsDetailInfo> getNewsDetail(@Query("id") int id);


    @GET(ApiUrl.IMAGE_LIST)
    Observable<BaseBean.ImageListBean> getImageList(@Query("id") int id, @Query("page") int page);


    @GET(ApiUrl.IMAGE_NEW)
    Observable<BaseBean.ImageNewBean> getImageNews(@Query("id") int id, @Query("rows") int rows);


    @GET(ApiUrl.IMAGE_SHOW)
    Observable<BaseBean.ImageDetailBean> getImageDetail(@Query("id") int id);


}
