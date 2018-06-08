package com.example.hxb_retorfit_mvp.mvp.Bean;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:56
 *  @描述 ：ImageListInfo
 */
public class ImageListInfo {

    private int id;
    private int galleryclass;//          图片分类
    private String title;//          标题
    private String img;//          图库封面
    private int count;//          访问数
    private int rcount;//           回复数
    private int fcount;//          收藏数
    private int size;//      图片多少张

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGalleryclass() {
        return galleryclass;
    }

    public void setGalleryclass(int galleryclass) {
        this.galleryclass = galleryclass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
