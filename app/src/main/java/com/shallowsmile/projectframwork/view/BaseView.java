package com.shallowsmile.projectframwork.view;

/**
 * 作者： x00090 on 2017/3/1.
 * 邮箱： 986740642@qq.com
 * 类描述：mvp模式中对应的 view 给Presenter提供接口调用
 */

public interface BaseView {
    void showAlertDialog(String message);
    void showLoadding(String message);
    void hideLoading(String message);
    void startView(Class c);
}
