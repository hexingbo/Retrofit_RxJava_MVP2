package com.example.hxb_retorfit_mvp.mvp.presenter;


import com.example.hxb_retorfit_mvp.R;
import com.example.hxb_retorfit_mvp.mvp.view.BaseView;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8 17:00
 *  @描述 ：ToolBarItemPresenterImpl
 */
public class ToolBarItemPresenterImpl extends BasePresenterImpl<BaseView.ToolBarItemView>
        implements BasePresenter.ToolBarItemPresenter {

    public ToolBarItemPresenterImpl(BaseView.ToolBarItemView view) {
        super(view);
    }


    @Override
    public void switchId(int id) {
        switch (id) {
            case R.id.toolbar_item_share:
                view.switchShare();
                break;
        }
    }
}
