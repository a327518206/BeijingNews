package com.example.beijingnews.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 缓存数据和读取
 * Created by Administrator on 2017/6/30.
 */

public class CatchUtils {
    /**
     * 读取缓存结果
     * @param context
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("xiaoluogo",Context.MODE_PRIVATE);
        return sp.getBoolean(key,false);
    }
}
