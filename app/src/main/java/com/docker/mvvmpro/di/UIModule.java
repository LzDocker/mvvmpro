package com.docker.mvvmpro.di;


import com.docker.mvvmpro.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by zhangshaofang on 2017/8/23.
 */
@Module
public abstract class UIModule {

    @ContributesAndroidInjector
    abstract MainActivity providerMainActivity();
//
//    @ContributesAndroidInjector(modules = FragmentModule.class)
//    abstract LogisticsInformationActivity provideLogisticsInformationActivity();
}
