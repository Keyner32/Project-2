package com.example.gabekeyner.project_2;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by GabeKeyner on 9/6/2016.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.InitializerBuilder initializerBuilder =
                Stetho.newInitializerBuilder(this);

        initializerBuilder.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this)
        );
        Stetho.Initializer initializer = initializerBuilder.build();

        Stetho.initialize(initializer);
    }
}
