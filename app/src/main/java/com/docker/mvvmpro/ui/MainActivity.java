package com.docker.mvvmpro.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.docker.common.api.ApiResponse;
import com.docker.common.api.BaseResponse;
import com.docker.common.api.CommonCallback;
import com.docker.common.api.CommonObserver;
import com.docker.common.base.BaseActivity;
import com.docker.common.di.Injectable;
import com.docker.common.viewModel.dockerViewModelFactory;
import com.docker.mvvmpro.R;
import com.docker.mvvmpro.api.DockerService;
import com.docker.mvvmpro.databinding.ActivityMainBinding;
import com.docker.mvvmpro.viewmodel.mainViewmodel;
import com.docker.mvvmpro.vo.BannerVo;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<mainViewmodel,ActivityMainBinding> implements Injectable {

    @Inject
    dockerViewModelFactory factory;

    @Inject
    DockerService dockerService;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public mainViewmodel getViewModel() {
        return  ViewModelProviders.of(this, factory).get(mainViewmodel.class);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    public void click(View view){
        initData();
    }

    private void initData(){

        dockerService.getBanners().observe(this, new CommonObserver<List<BannerVo>>(new CommonCallback<List<BannerVo>>() {
            @Override
            public void onComplete(List<BannerVo> Result) {
                Log.d("comm", "onComplete: "+Result.get(0).getDesc());
            }

            @Override
            public void onBusinessError() {
                Log.d("comm", "onBusinessError: ");
            }

            @Override
            public void onNetworkError(ApiResponse apiResponse) {
                Log.d("comm", "onNetworkError: ");
            }

            @Override
            public void onComplete(BaseResponse<List<BannerVo>> baseResponse) {
                super.onComplete(baseResponse);
                Log.d("comm", "BaseResponse: "+baseResponse.getData());
            }
        }));
    }
}
