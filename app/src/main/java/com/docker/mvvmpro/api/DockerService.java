package com.docker.mvvmpro.api;

import android.arch.lifecycle.LiveData;

import com.docker.common.api.ApiResponse;
import com.docker.common.api.BaseResponse;
import com.docker.mvvmpro.vo.BannerVo;

import java.util.List;

import retrofit2.http.GET;

/**
 * Created by zhangxindang on 2018/9/6.
 */

public interface DockerService {

    public static final String SERVER_URL = "http://www.wanandroid.com";

    //查询全部省
    @GET("banner/json")
    LiveData<ApiResponse<BaseResponse<List<BannerVo>>>> getBanners();

}
