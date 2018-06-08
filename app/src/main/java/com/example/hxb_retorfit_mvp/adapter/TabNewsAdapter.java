package com.example.hxb_retorfit_mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


import com.example.hxb_retorfit_mvp.fragment.NewsMainFragment;
import com.example.hxb_retorfit_mvp.mvp.Bean.TabNewsInfo;
import com.example.hxb_retorfit_mvp.widget.BaseFragmentPagerAdapter;

import java.util.List;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:54
 *  @描述 ：TabNewsAdapter
 */
public class TabNewsAdapter extends BaseFragmentPagerAdapter<TabNewsInfo> {


    public TabNewsAdapter(FragmentManager fm, List<TabNewsInfo> mDatas) {
        super(fm, mDatas);
    }

    @Override
    protected Fragment getFragmentItem(int position) {
        return NewsMainFragment.newInstance(position);
    }

    @Override
    protected CharSequence getTitle(TabNewsInfo data) {
        return data.getName();
    }
}

