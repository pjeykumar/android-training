package com.andigital.twitterfeedapp;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pjeyamukar on 20/11/2017.
 */

@Module
public class MyAppModule {

    private final Application application;

    public MyAppModule(Application application){
        this.application=application;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return application;
    }
}
