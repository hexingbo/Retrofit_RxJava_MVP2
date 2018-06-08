package com.example.hxb_retorfit_mvp.adapter;

import android.text.TextUtils;
import android.text.format.DateUtils;


import com.example.hxb_retorfit_mvp.R;
import com.example.hxb_retorfit_mvp.mvp.Bean.NewsListInfo;
import com.example.hxb_retorfit_mvp.network.ApiUrl;
import com.example.hxb_retorfit_mvp.utils.ImageLoaderUtils;
import com.example.hxb_retorfit_mvp.utils.UIUtils;
import com.example.hxb_retorfit_mvp.widget.LoadMoreAdapter;
import com.example.hxb_retorfit_mvp.widget.ViewHolder;

import java.util.List;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:54
 *  @描述 ：NewsListAdapter
 */
public class NewsListAdapter extends LoadMoreAdapter<NewsListInfo> {


    public NewsListAdapter(List<NewsListInfo> datas) {
        super(datas);
    }

    @Override
    protected void onBind(ViewHolder holder, int position, NewsListInfo data) {
        holder.setTextView(R.id.tv_time,
                TextUtils.concat(UIUtils.getString(R.string.news_time),
                        DateUtils.formatDateTime(holder.getContext(),
                                data.getTime(), DateUtils.FORMAT_SHOW_YEAR))
        );
        holder.setTextView(R.id.tv_title, data.getTitle());
        holder.setTextView(R.id.tv_url, data.getFromurl());
        ImageLoaderUtils.display(holder.getImageView(R.id.image), TextUtils.concat(ApiUrl.IMAGER_URL, data.getImg()));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.news_list_item;
    }

}