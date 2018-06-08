package com.example.hxb_retorfit_mvp.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.hxb_retorfit_mvp.R;
import com.example.hxb_retorfit_mvp.mvp.Bean.NewsDetailInfo;
import com.example.hxb_retorfit_mvp.mvp.presenter.BasePresenter;
import com.example.hxb_retorfit_mvp.mvp.presenter.NewsDetailPresenterImpl;
import com.example.hxb_retorfit_mvp.mvp.presenter.ToolBarItemPresenterImpl;
import com.example.hxb_retorfit_mvp.mvp.view.BaseView;
import com.example.hxb_retorfit_mvp.network.ApiUrl;
import com.example.hxb_retorfit_mvp.utils.ActivityUtils;
import com.example.hxb_retorfit_mvp.utils.ImageLoaderUtils;
import com.example.hxb_retorfit_mvp.utils.UIUtils;
import com.example.hxb_retorfit_mvp.widget.BaseActivity;

import butterknife.Bind;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 16:50
 *  @描述 ：NewsDetailActivity
 */
public class NewsDetailActivity extends BaseActivity
        implements BaseView.NewsDetailView, BaseView.ToolBarItemView {


    @Bind(R.id.image)
    ImageView image;

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    @Bind(R.id.content)
    TextView content;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private int id;
    private String message;
    private BasePresenter.ToolBarItemPresenter toolBarItemPresenter;


    public static void startIntent(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        ActivityUtils.startActivity(NewsDetailActivity.class, bundle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getBundle();
        init();
    }

    private void init() {
        BasePresenter.NewsDetailPresenter newsDetailPresenter = new NewsDetailPresenterImpl(this);
        toolBarItemPresenter = new ToolBarItemPresenterImpl(this);
        newsDetailPresenter.requestNetWork(id);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                toolBarItemPresenter.switchId(item.getItemId());
                return true;
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();
        if (null != bundle && !bundle.isEmpty()) {
            id = bundle.getInt("id");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setData(NewsDetailInfo datas) {
        ImageLoaderUtils.display(image, ApiUrl.IMAGER_URL + datas.getImg());
        content.setText(Html.fromHtml(datas.getMessage()));
        collapsingToolbar.setTitle(datas.getTitle());
        message = String.valueOf(Html.fromHtml(datas.getMessage()));
    }

    @Override
    public void switchShare() {
        ActivityUtils.share(this, message);
    }

    @Override
    public void netWorkError() {
        Toast(UIUtils.getString(R.string.network_error));
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_detail;
    }
}
