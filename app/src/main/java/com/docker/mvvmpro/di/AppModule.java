package com.docker.mvvmpro.di;

import android.content.Context;


import com.docker.mvvmpro.api.DockerService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by zhangxindang on 2018/9/6.
 */
@Module
public class AppModule {

    private Context mContext;

    public AppModule(Context context) {
        this.mContext = context;
    }

//    @Provides
//    public String provideBaseUrl() {
//        return DockerService.SERVER_URL;
//    }

    @Provides
    @Singleton
    public DockerService provideDockerService(Retrofit restAdapter) {
        return restAdapter.create(DockerService.class);
    }

}
