package com.example.hxb_retorfit_mvp.adapter;

import com.example.hxb_retorfit_mvp.R;
import com.example.hxb_retorfit_mvp.widget.LoadMoreAdapter;
import com.example.hxb_retorfit_mvp.widget.ViewHolder;

import java.util.List;

/**
 * @作者 ：贺兴波
 * @时间 ：2018/6/8 16:48
 * @描述 ：AboutAdapter
 */
public class AboutAdapter extends LoadMoreAdapter<String> {

    public AboutAdapter(List<String> datas) {
        super(datas);
    }

    @Override
    protected void onBind(ViewHolder holder, int position, String data) {
        holder.setTextView(R.id.tv_about, data);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.about_item;
    }
}
