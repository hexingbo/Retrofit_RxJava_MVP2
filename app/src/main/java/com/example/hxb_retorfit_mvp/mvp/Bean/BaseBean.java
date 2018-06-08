package com.example.hxb_retorfit_mvp.mvp.Bean;

import java.util.List;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:56
 *  @描述 ：BaseBean
 */
public class BaseBean<T> {

    private List<T> tngou;


    public List<T> getInfo() {
        return tngou;
    }

    public void setInfo(List<T> tngou) {
        this.tngou = tngou;
    }


    public class TabNewsBean extends BaseBean<TabNewsInfo> {
    }

    public class TabNameBean extends BaseBean<TabNameInfo> {
    }

    public class ImageListBean extends BaseBean<ImageListInfo> {
    }

    public class ImageNewBean extends BaseBean<ImageNewInfo> {
    }

    public class NewsListBean extends BaseBean<NewsListInfo> {
    }

    public class ImageDetailBean {
        private List<ImageDetailInfo> list;

        public List<ImageDetailInfo> getList() {
            return list;
        }

        public void setList(List<ImageDetailInfo> list) {
            this.list = list;
        }

    }

}
