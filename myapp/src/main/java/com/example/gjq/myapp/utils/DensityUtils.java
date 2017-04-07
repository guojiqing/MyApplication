package com.example.gjq.myapp.utils;

import android.content.Context;

/**
 * Created by guojiqing on 2017/3/25.
 */

public class DensityUtils {


    // dpi转px
    public static int dpi2px(Context ctx, int dpi) {
        return (int) (ctx.getResources().getDisplayMetrics().density * dpi);
    }

    public static int px2dpi(Context ctx, int px) {
        return (int) (px / ctx.getResources().getDisplayMetrics().density);
    }
}
