package com.example.administrator.androidtoolbar;

import android.app.Application;

/**
 * Created by Administrator on 2017/7/4 0004.
 */

public class APP extends Application{

    private static APP instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static APP getInstance(){
        return instance;
    }

}
