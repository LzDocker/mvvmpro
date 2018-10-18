package com.docker.mvvmpro;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.docker.mvvmpro.di.AppInjector;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by zhangxindang on 2018/9/17.
 */

public class DockerApp extends MultiDexApplication implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    private RefWatcher refWatcher;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    private static Context mContext;
    public static Context getContext(){
        return mContext;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
        AppInjector.init(this);
        mContext = getApplicationContext();
    }

    public static RefWatcher getRefWatcher(Context context) {
        DockerApp application = (DockerApp) context.getApplicationContext();
        return application.refWatcher;
    }

}
