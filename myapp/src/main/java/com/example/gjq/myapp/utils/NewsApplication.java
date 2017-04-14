package com.example.gjq.myapp.utils;

import android.app.Application;
import android.support.compat.BuildConfig;
import android.util.Log;

import org.xutils.x;

/**
 * Created by guojiqing on 2017/4/7.
 */

public class NewsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);  // 注册xutlts框架
        x.Ext.setDebug(BuildConfig.DEBUG); // 开启debug模式,
        Log.i("crc",this.getClass() + "---> onCreate");
    }
}
