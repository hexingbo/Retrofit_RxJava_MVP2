package com.example.hxb_retorfit_mvp.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.hxb_retorfit_mvp.R;
import com.example.hxb_retorfit_mvp.fragment.AboutFragment;
import com.example.hxb_retorfit_mvp.fragment.ImageNewFragment;
import com.example.hxb_retorfit_mvp.fragment.ImageViewPagerFragment;
import com.example.hxb_retorfit_mvp.fragment.NewsViewPagerFragment;
import com.example.hxb_retorfit_mvp.mvp.presenter.BasePresenter;
import com.example.hxb_retorfit_mvp.mvp.presenter.MainViewPresenterImpl;
import com.example.hxb_retorfit_mvp.mvp.view.BaseView;
import com.example.hxb_retorfit_mvp.utils.AppManager;
import com.example.hxb_retorfit_mvp.utils.RxUtils;
import com.example.hxb_retorfit_mvp.utils.UIUtils;
import com.example.hxb_retorfit_mvp.widget.BaseActivity;

import butterknife.Bind;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/9
 *  @描述 ：MainActivity
 */
public class MainActivity extends BaseActivity implements BaseView.MainView, NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.toolBar)
    Toolbar toolBar;

    @Bind(R.id.navigation_view)
    NavigationView navigationView;

    @Bind(R.id.dl_layout)
    DrawerLayout drawerLayout;
    private BasePresenter.MainViewPresenter mainViewPresenter;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        toolBar.setTitle(UIUtils.getString(R.string.navigation_news));
        setSupportActionBar(toolBar);
        mainViewPresenter = new MainViewPresenterImpl(this);
        navigationView.setNavigationItemSelectedListener(this);
        switchNews();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void switchNews() {
        replaceFragment(NewsViewPagerFragment.getInstance());
    }

    @Override
    public void switchImageClassification() {
        replaceFragment(ImageViewPagerFragment.getInstance());
    }

    @Override
    public void switchNewImage() {
        replaceFragment(ImageNewFragment.getInstance());
    }

    @Override
    public void switchAbout() {
        replaceFragment(AboutFragment.getInstance());
    }

    void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        toolBar.setTitle(item.getTitle());
        mainViewPresenter.switchId(item.getItemId());
        drawerLayout.closeDrawers();
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), UIUtils.getString(R.string.exit_app), Toast.LENGTH_LONG).show();
                exitTime = System.currentTimeMillis();
            } else {
//                ActivityCollector.removeAllActivity();
                AppManager.exitApp();
                RxUtils.getInstance().clearSubscription();
                super.onBackPressed();
            }
        }

    }
}
