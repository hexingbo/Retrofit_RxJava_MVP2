package com.example.hxb_retorfit_mvp.mvp.presenter;


import com.example.hxb_retorfit_mvp.mvp.Bean.ImageListInfo;
import com.example.hxb_retorfit_mvp.mvp.Bean.ImageNewInfo;
import com.example.hxb_retorfit_mvp.mvp.Bean.NewsListInfo;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:58
 *  @描述 ：BasePresenter
 */
public interface BasePresenter {


    interface ImageDetailPresenter {
        void requestNetWork(int id);

        void competence(int requestCode, int[] grantResults);
    }

    interface ImageListPresenter {
        void requestNetWork(int id, int page);

        void onClick(ImageListInfo info);
    }

    interface ImageNewPresenter {
        void requestNetWork(String id, String rows);

        void onClick(ImageNewInfo info);
    }

    interface MainViewPresenter {
        void switchId(int id);
    }

    interface ToolBarItemPresenter {
        void switchId(int id);
    }


    interface NewsListPresenter {
        void requestNetWork(int id, int page);

        void onClick(NewsListInfo info);
    }

    interface NewsDetailPresenter {
        void requestNetWork(int id);
    }

    interface TabNamePresenter {
        void requestNetWork();
    }

    interface TabNewsPresenter {
        void requestNetWork();
    }

}
