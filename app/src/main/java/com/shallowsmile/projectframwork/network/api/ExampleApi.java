package com.shallowsmile.projectframwork.network.api;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;



/**
 * 作者： x00090 on 2017/3/1.
 * 邮箱： 986740642@qq.com
 * 类描述：retrofitApi接口定义模板
 */

public interface ExampleApi {
    /**
     * get请求
     * @param id
     * @return
     */
    @GET("http://c.m.163.com/nc/article/headline/T1348647909107/{id}-20.html")
    Observable<Object> getNews(@Path("id") int id);

    /**
     * post  提交表单数据
     * @param first
     * @param last
     * @return
     */
    @FormUrlEncoded
    @POST("user/edit")
    Observable<Object> updateUser(@Field("first_name") String first, @Field("last_name") String last);
}
