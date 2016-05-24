package com.tripint.intersight.app;

import android.app.Application;

import cn.smssdk.SMSSDK;

/**
 * Created by Eric on 16/5/17.
 */
public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        SMSSDK.initSDK(this,"您的 appkey","您的 appsecret");
    }
}
