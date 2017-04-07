package com.example.gjq.myapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by guojiqing on 2017/4/5.
 */

public class SharedPreUtils {
    private final static String config = "news";

    //设置Boolean值
    public static void setBoolean(Context ctx, String key, Boolean value) {
        SharedPreferences ref = ctx.getSharedPreferences(config, Context.MODE_PRIVATE);
        ref.edit().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(Context ctx, String key, Boolean defValue) {
        SharedPreferences ref = ctx.getSharedPreferences(config, Context.MODE_PRIVATE);
        return ref.getBoolean(key, defValue);
    }
}
