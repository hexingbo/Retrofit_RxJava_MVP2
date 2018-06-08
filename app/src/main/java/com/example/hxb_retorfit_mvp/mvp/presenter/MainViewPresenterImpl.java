package com.example.hxb_retorfit_mvp.mvp.presenter;


import com.example.hxb_retorfit_mvp.R;
import com.example.hxb_retorfit_mvp.mvp.view.BaseView;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 17:00
 *  @描述 ：MainViewPresenterImpl
 */
public class MainViewPresenterImpl extends BasePresenterImpl<BaseView.MainView>
        implements BasePresenter.MainViewPresenter {


    public MainViewPresenterImpl(BaseView.MainView view) {
        super(view);
    }

    @Override
    public void switchId(int id) {
        switch (id) {
            case R.id.navigation_item_news:
                view.switchNews();
                break;
            case R.id.navigation_item_image_classification:
                view.switchImageClassification();
                break;
            case R.id.navigation_item_new_image:
                view.switchNewImage();
                break;
            case R.id.navigation_about:
                view.switchAbout();
                break;
        }
    }
}
