package com.andigital.twitterfeedapp;

import com.andigital.twitterfeedapp.presenter.TweetPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pjeyamukar on 20/11/2017.
 */

@Singleton
@Component(modules = {MyAppModule.class,TwitterModule.class, ApiModule.class})
public interface MyAppComponent {
    void inject(MainActivity target);
}
