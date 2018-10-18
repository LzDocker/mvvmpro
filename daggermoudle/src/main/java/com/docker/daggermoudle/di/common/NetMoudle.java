package com.docker.daggermoudle.di.common;

import android.content.Context;

import java.io.File;
import java.util.Timer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by zhangxindang on 2018/9/26.
 */

@Module(includes = ContextMoudle.class)
public class NetMoudle {


    @Provides
    @AppScope
    @Singleton
    public HttpLoggingInterceptor providerLoggerInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @Provides
    @AppScope
    @Singleton
    public Cache providerCache(File cacheFile){
          return new Cache(cacheFile,1024*1024*1024);
    }


    @Provides
    @AppScope
    @Singleton
    public File providerCacheFile(@AppContext Context context){
        return new File(context.getCacheDir(),"docker_cache");
    }


    @Provides
    @AppScope
    @Singleton
    public OkHttpClient providerOkhttpClient(HttpLoggingInterceptor interceptor, Cache cache){
       return new OkHttpClient.Builder()
               .addInterceptor(interceptor)
               .cache(cache)
               .build();
    }


}
