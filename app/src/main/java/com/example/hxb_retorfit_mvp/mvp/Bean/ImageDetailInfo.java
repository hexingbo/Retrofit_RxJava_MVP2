package com.example.hxb_retorfit_mvp.mvp.Bean;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:56
 *  @描述 ：ImageDetailInfo
 */
public class ImageDetailInfo {


    private int id;
    private int gallery; //图片库
    private String src; //图片地址


    public int getGallery() {
        return gallery;
    }

    public void setGallery(int gallery) {
        this.gallery = gallery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

}