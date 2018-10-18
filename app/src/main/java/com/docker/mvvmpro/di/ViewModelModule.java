package com.docker.mvvmpro.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.docker.common.di.ViewModelKey;
import com.docker.common.viewModel.dockerViewModelFactory;
import com.docker.mvvmpro.viewmodel.mainViewmodel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by zhangxindang on 2018/9/6.
 */
@Module
public abstract class ViewModelModule {


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(dockerViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(mainViewmodel.class)
    abstract ViewModel MainViewModel(mainViewmodel model);

}
