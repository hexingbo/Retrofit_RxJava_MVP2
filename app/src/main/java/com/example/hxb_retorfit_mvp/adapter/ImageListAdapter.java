package com.example.hxb_retorfit_mvp.adapter;


import android.text.TextUtils;


import com.example.hxb_retorfit_mvp.R;
import com.example.hxb_retorfit_mvp.mvp.Bean.ImageListInfo;
import com.example.hxb_retorfit_mvp.network.ApiUrl;
import com.example.hxb_retorfit_mvp.utils.ImageLoaderUtils;
import com.example.hxb_retorfit_mvp.utils.UIUtils;
import com.example.hxb_retorfit_mvp.widget.LoadMoreAdapter;
import com.example.hxb_retorfit_mvp.widget.ViewHolder;

import java.util.List;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/9
 *  @描述 ：ImageListAdapter
 */
public class ImageListAdapter extends LoadMoreAdapter<ImageListInfo> {


    public ImageListAdapter(List<ImageListInfo> datas) {
        super(datas);
    }

    @Override
    protected void onBind(ViewHolder holder, int position, ImageListInfo data) {
        holder.setTextView(R.id.tv_title, data.getTitle());
        holder.setTextView(R.id.tv_size, TextUtils.concat(Integer.toString(data.getSize()), UIUtils.getString(R.string.list_adapter_number)));
        holder.setTextView(R.id.tv_count, TextUtils.concat(UIUtils.getString(R.string.list_adapter_views), Integer.toString(data.getCount())));
        ImageLoaderUtils.display(holder.getImageView(R.id.image), TextUtils.concat(ApiUrl.IMAGER_URL, data.getImg()));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.image_list_item;
    }
}
