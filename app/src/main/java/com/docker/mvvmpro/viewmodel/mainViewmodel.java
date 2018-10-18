package com.docker.mvvmpro.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.Transformations;
import android.util.Log;
import android.widget.ListView;

import com.docker.common.api.ApiResponse;
import com.docker.common.api.BaseResponse;
import com.docker.common.base.BaseViewModel;
import com.docker.mvvmpro.api.DockerService;
import com.docker.mvvmpro.vo.BannerVo;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by zhangxindang on 2018/9/6.
 */

public class mainViewmodel extends BaseViewModel {

 @Inject
 DockerService service;

 @Inject
 public mainViewmodel(){

 }

 @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
 public void onCreate(){
  Log.d("sss", "onCreate: -----");


 }






}
