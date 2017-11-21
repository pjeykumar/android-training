package com.andigital.twitterfeedapp;

import android.content.Context;

import com.andigital.twitterfeedapp.presenter.TweetPresenter;
import com.andigital.twitterfeedapp.presenter.TweetPresenterImpl;
import com.andigital.twitterfeedapp.rxJava.ObservableConfigurer;
import com.andigital.twitterfeedapp.service.TweetService;
import com.andigital.twitterfeedapp.service.TweetServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pjeyamukar on 20/11/2017.
 */
@Module
public class TwitterModule  {

    @Provides
    @Singleton
    public TweetService provideTweetService(TwitterAPI twitterAPI){
        return new TweetServiceImpl(twitterAPI);
    }

    @Provides
    @Singleton
    public TweetPresenter provideTweetPresenter(TweetService tweetService, ObservableConfigurer observableConfigurer){
      return new TweetPresenterImpl(tweetService, observableConfigurer);
    }
}
