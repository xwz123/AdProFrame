package com.shallowsmile.projectframwork.viewimpl;

import android.app.Activity;
import android.os.Bundle;

import com.shallowsmile.projectframwork.presenter.BasePresenter;

/**
 * 作者： x00090 on 2017/3/2.
 * 邮箱： 986740642@qq.com
 * 类描述：
 */

public abstract  class BaseActivity <V,P extends BasePresenter<V>> extends Activity{
    public P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=initPresenter();
        presenter.attach((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detTach();
            presenter=null;
        }
    }

    public abstract P initPresenter();


}
