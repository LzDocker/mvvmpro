package com.docker.common.api;

/**
 * Created by zhangxindang on 2018/9/6.
 */

public abstract class CommonCallback<T> {

    public CommonCallback() {}


    public void onComplete(BaseResponse<T> baseResponse) {}
    public void onComplete() {}
    public abstract void onComplete(T Result);

    public abstract void onBusinessError();

    public abstract void onNetworkError(ApiResponse apiResponse);
}
