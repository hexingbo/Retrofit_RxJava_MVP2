package com.example.hxb_retorfit_mvp.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


import com.example.hxb_retorfit_mvp.fragment.ImageMainFragment;
import com.example.hxb_retorfit_mvp.mvp.Bean.TabNameInfo;
import com.example.hxb_retorfit_mvp.widget.BaseFragmentPagerAdapter;

import java.util.List;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/9
 *  @描述 ：TabNameAdapter
 */
public class TabNameAdapter extends BaseFragmentPagerAdapter<TabNameInfo> {


    public TabNameAdapter(FragmentManager fm, List<TabNameInfo> mDatas) {
        super(fm, mDatas);
    }

    @Override
    protected Fragment getFragmentItem(int position) {
        return ImageMainFragment.newInstance(position);
    }

    @Override
    protected CharSequence getTitle(TabNameInfo data) {
        return data.getName();
    }

}
