package com.example.comida;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class RXCakeApplication extends Application {

    private static RXCakeApplication instance;
    private static Context appContext;

    public static  RXCakeApplication getInstance() {return instance; }

    public static Context getAppContext() { return appContext; }

    public void setAppContext(Context mAppContext) { this.appContext = mAppContext; }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        this.setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
