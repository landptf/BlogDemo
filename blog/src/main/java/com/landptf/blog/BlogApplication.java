package com.landptf.blog;

import android.app.Application;
import android.content.Context;

/**
 * Created by liyulong on 2017/3/11.
 */
public class BlogApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
