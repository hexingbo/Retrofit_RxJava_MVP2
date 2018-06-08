package com.example.hxb_retorfit_mvp.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;


import com.example.hxb_retorfit_mvp.R;
import com.example.hxb_retorfit_mvp.adapter.TabNameAdapter;
import com.example.hxb_retorfit_mvp.mvp.Bean.TabNameInfo;
import com.example.hxb_retorfit_mvp.mvp.presenter.BasePresenter;
import com.example.hxb_retorfit_mvp.mvp.presenter.TabNamePresenterImpl;
import com.example.hxb_retorfit_mvp.mvp.view.BaseView;
import com.example.hxb_retorfit_mvp.widget.MVPLazyFragment;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:56
 *  @描述 ：ImageViewPagerFragment
 */
public class ImageViewPagerFragment extends MVPLazyFragment implements BaseView.TabNameView {


    @Bind(R.id.tab_layout)
    TabLayout tabLayout;

    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private TabNameAdapter tabNameAdapter;
    private List<TabNameInfo> data;

    public static ImageViewPagerFragment getInstance() {
        return new ImageViewPagerFragment();
    }

    @Override
    public void initActivityCreated() {


        BasePresenter.TabNamePresenter tabNamePresenter = new TabNamePresenterImpl(this);
        tabNamePresenter.requestNetWork();

        data = new LinkedList<>();
        tabNameAdapter = new TabNameAdapter(getChildFragmentManager(), data);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_viewpager;
    }


    @Override
    public void setData(List<TabNameInfo> datas) {
        if (!datas.isEmpty()) {
            data.addAll(datas);
            viewPager.setAdapter(tabNameAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    @Override
    public void netWorkError() {
        Toast(getString(R.string.network_error));
    }

}
