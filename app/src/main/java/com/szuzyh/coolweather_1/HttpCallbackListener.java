package com.szuzyh.coolweather_1;

/**
 * Created by 27721_000 on 2016/3/20.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);

}
