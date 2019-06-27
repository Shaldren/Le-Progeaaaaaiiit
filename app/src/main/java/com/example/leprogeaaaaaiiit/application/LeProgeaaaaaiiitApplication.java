package com.example.leprogeaaaaaiiit.application;

import android.app.Application;
import android.content.Context;

public class LeProgeaaaaaiiitApplication extends Application {

    private static Context appContext;

    public final static String CONFIGURATION_PREF = "configuration";
    public final static String INTENT_CLIENT = "client";
    public final static String INTENT_VEHICULE = "vehicule";

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();

        /* If you has other classes that need context object to initialize when application is created,
         you can use the appContext here to process. */
    }

    public static Context getAppContext() {
        return appContext;
    }
}
