package com.shallowsmile.projectframwork.network.api;

import com.shallowsmile.projectframwork.ProApplication;
import com.shallowsmile.projectframwork.util.ConstData;
import com.shallowsmile.projectframwork.util.NetworkUtils;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者： x00090 on 2017/3/1.
 * 邮箱： 986740642@qq.com
 * 类描述：ApiManager
 */

public class ApiManager {
    //静态内部类实现单例模式
    private ApiManager(){}
    private ExampleApi exampleApi;
    private static class SingManage{
        private  static ApiManager apiManager=new ApiManager();
    }
    public static ApiManager getApiManager(){
        return  SingManage.apiManager;
    }
    //日志拦截器
    private  static  HttpLoggingInterceptor HTTP_LOG_INTERCEPTOR=new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    //缓存拦截器
    private static final Interceptor REWITE_CACHE_CONTROL_INTERCEPTOR=new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse=chain.proceed(chain.request());
            if(NetworkUtils.isNetWorkAvailabe(ProApplication.getAppContext())){
                //设置在线缓存 1分钟内可读取
                int maxAge = 60;
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            }else {
                //设置离线缓存 保存4周
                int maxStale = 60 * 60 * 24 * 28;
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    };

    private static File httpCacheDir=new File(ProApplication.getAppContext().getCacheDir(), ConstData.HTTP_CACHE_FILE);
    private static int  cacheSize=10*1024*1024; //缓存大小 10M
    private static Cache cache=new Cache(httpCacheDir,cacheSize);
    //okHttp3客户端
    private static OkHttpClient client=new OkHttpClient.Builder()
            .addNetworkInterceptor(REWITE_CACHE_CONTROL_INTERCEPTOR)
            .addInterceptor(REWITE_CACHE_CONTROL_INTERCEPTOR)
            .addInterceptor(HTTP_LOG_INTERCEPTOR)
            .cache(cache)
            .build();

    /**
     * 获取模板API接口
     * @return
     */
    public ExampleApi getExampleApi(){
        if(exampleApi==null){
            synchronized (ApiManager.class){
                if(exampleApi==null){
                    exampleApi=new Retrofit.Builder()
                            .baseUrl(ConstData.HTTP_BASE_URL)
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(client)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build().create(ExampleApi.class);
                }
            }
        }
        return exampleApi;
    }

}
