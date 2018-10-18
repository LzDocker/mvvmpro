/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.docker.common.di;


import android.content.Context;
import com.docker.common.util.LiveDataCallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module(includes = {UIModule.class})
public class ApiModule {

    private static String TAG = "ApiModule";
    private Context mContext;

    public ApiModule(Context context) {
        mContext = context;
    }


//    @Provides
//    @Singleton
//    public CommonService provideCacheCommonService(Retrofit restAdapter, CacheDatabase cacheDatabase, AppExecutors appExecutors) {
//        CommonService commonService = restAdapter.create(CommonService.class);
//        InvocationHandler handler = new DynamicProxy(commonService, cacheDatabase, mContext, appExecutors);
//        return (CommonService) Proxy.newProxyInstance(handler.getClass().getClassLoader(), commonService
//                .getClass().getInterfaces(), handler);
//    }



//    @Provides
//    public CacheDatabase provideCacheDatabase() {
//        CacheDatabase db = Room.databaseBuilder(mContext,
//                CacheDatabase.class, "hivescm_cache").build();
//        return db;
//    }




//
//    @Singleton
//    @Provides
//    public ApiGeneratoryFactory provideApiGeneratoryFactory(CommonService commonService) {
//        return new ApiGeneratoryFactory(commonService);
//    }


    @Singleton
    @Provides
    public String provideBaseUrl() {
        return "http://www.wanandroid.com";
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(/*CommonParamsInterceptor commonParamsInterceptor*/) {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS);
//        builder.addInterceptor(commonParamsInterceptor);
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRestAdapter(OkHttpClient okHttpClient, String baseUrl) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .addConverterFactory(com.docker.common.api.converter.GsonConverterFactory.create());
        return builder.build();
    }
}
