package com.example.hxb_retorfit_mvp.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;


import com.example.hxb_retorfit_mvp.R;
import com.example.hxb_retorfit_mvp.adapter.TabNewsAdapter;
import com.example.hxb_retorfit_mvp.mvp.Bean.TabNewsInfo;
import com.example.hxb_retorfit_mvp.mvp.presenter.BasePresenter;
import com.example.hxb_retorfit_mvp.mvp.presenter.TabNewsPresenterImpl;
import com.example.hxb_retorfit_mvp.mvp.view.BaseView;
import com.example.hxb_retorfit_mvp.widget.MVPLazyFragment;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/9
 *  @描述 ：NewsViewPagerFragment
 */
public class NewsViewPagerFragment extends MVPLazyFragment implements BaseView.TabNewsView {


    @Bind(R.id.tab_layout)
    TabLayout tabLayout;

    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private List<TabNewsInfo> data;
    private TabNewsAdapter tabNewsAdapter;

    public static NewsViewPagerFragment getInstance() {
        return new NewsViewPagerFragment();
    }

    @Override
    protected void initActivityCreated() {

        BasePresenter.TabNewsPresenter tabNewsPresenter = new TabNewsPresenterImpl(this);
        tabNewsPresenter.requestNetWork();

        data = new LinkedList<>();
        tabNewsAdapter = new TabNewsAdapter(getChildFragmentManager(), data);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_viewpager;
    }

    @Override
    public void setData(List<TabNewsInfo> datas) {
        if (!datas.isEmpty()) {
            data.addAll(datas);
            viewPager.setAdapter(tabNewsAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    @Override
    public void netWorkError() {
        Toast(getString(R.string.network_error));
    }

}
