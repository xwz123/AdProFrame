package com.shallowsmile.projectframwork.presenter;

/**
 * 作者： x00090 on 2017/3/1.
 * 邮箱： 986740642@qq.com
 * 类描述：presenter抽象基类
 */

public abstract class BasePresenter <T>{
    public T view;

    public abstract void initAbout();
    public abstract void bindData();
    public void attach(T view){this.view=view;}
    //这里要释放对象的引用防止内存溢出 因为View代表的是一个Activity或者是fragment
    public void detTach(){view=null;}
}
