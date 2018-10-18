package com.docker.daggermoudle.di.common;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangxindang on 2018/9/26.
 */

@Module
public class ContextMoudle {

    private final Context context;

    public ContextMoudle(Context context){this.context = context.getApplicationContext();}

    @Provides
    @Singleton
    @AppScope
    public Context providerContext(){return context;}


}
