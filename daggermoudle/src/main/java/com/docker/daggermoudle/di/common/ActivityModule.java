package com.docker.daggermoudle.di.common;

import android.app.Activity;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangxindang on 2018/9/26.
 */

@Module
public class ActivityModule {


    private final Activity context;
    public ActivityModule(Activity context){this.context=context;}

    @Provides
    @AppScope
    @Named("Activity_context")
    public Context context(){return context;}
}
