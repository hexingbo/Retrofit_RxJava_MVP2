package com.example.hxb_retorfit_mvp.adapter;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.hxb_retorfit_mvp.R;
import com.example.hxb_retorfit_mvp.mvp.Bean.ImageDetailInfo;
import com.example.hxb_retorfit_mvp.network.ApiUrl;
import com.example.hxb_retorfit_mvp.utils.ImageLoaderUtils;
import com.example.hxb_retorfit_mvp.utils.RxUtils;
import com.example.hxb_retorfit_mvp.utils.SaveImageUtils;
import com.example.hxb_retorfit_mvp.utils.UIUtils;
import com.example.hxb_retorfit_mvp.widget.BasePagerAdapter;

import java.util.List;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:54
 *  @描述 ：ImageDetailAdapter
 */
public class ImageDetailAdapter extends BasePagerAdapter<ImageDetailInfo> implements View.OnLongClickListener {


    public ImageDetailAdapter(List<ImageDetailInfo> datas) {
        super(datas);
    }

    @Override
    protected Object instantiate(final ViewGroup container, final int position, ImageDetailInfo data) {
        final ImageView imageView = new ImageView(container.getContext());
        ImageLoaderUtils.display(imageView, TextUtils.concat(ApiUrl.IMAGER_URL, data.getSrc()));
        container.addView(imageView);
        imageView.setOnLongClickListener(this);
        return imageView;
    }

    @Override
    public boolean onLongClick(final View v) {
        new AlertDialog
                .Builder(v.getContext())
                .setMessage(UIUtils.getString(R.string.imageview_message))
                .setPositiveButton(UIUtils.getString(R.string.dialog_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        v.setDrawingCacheEnabled(true);
                        RxUtils.getInstance().unSubscription();
                        SaveImageUtils.imageSave((ImageView) v, System.currentTimeMillis());
                    }
                }).create().show();
        return true;
    }
}
