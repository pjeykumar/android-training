package com.andigital.twitterfeedapp;

import com.andigital.twitterfeedapp.rxJava.AndroidObservableConfigurer;
import com.andigital.twitterfeedapp.rxJava.ObservableConfigurer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sverma on 08/06/2017.
 */

@Module
public class RxModule {

    @Provides @Singleton
    public ObservableConfigurer provideObservableConfigurer() {
        return new AndroidObservableConfigurer();
    }

}
