package com.example.hxb_retorfit_mvp.mvp.view;


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
 *  @时间 ：2018/6/9
 *  @描述 ：BaseView
 */
public interface BaseView<T> {


    void setData(List<T> datas);

    void netWorkError();

    /**
     * 需要刷新的继承此View
     *
     * @param <T>
     */
    interface OnRefreshView<T> extends BaseView<T> {
        void hideProgress();

        void showProgress();

        void showFoot();

        void hideFoot();
    }

    interface ImageDetailView extends BaseView<ImageDetailInfo> {
    }

    interface ImageListView extends OnRefreshView<ImageListInfo> {
    }

    interface ImageNewView extends BaseView<ImageNewInfo> {
        void hideProgress();

        void showProgress();

        void offKeyBoard();
    }

    interface NewsListView extends OnRefreshView<NewsListInfo> {
    }

    interface NewsDetailView {
        void setData(NewsDetailInfo datas);

        void netWorkError();

        void hideProgress();

        void showProgress();
    }

    interface TabNameView extends BaseView<TabNameInfo> {
    }

    interface TabNewsView extends BaseView<TabNewsInfo> {
    }

    interface MainView {
        void switchNews();

        void switchImageClassification();

        void switchNewImage();

        void switchAbout();
    }

    interface ToolBarItemView {
        void switchShare();
    }
}
