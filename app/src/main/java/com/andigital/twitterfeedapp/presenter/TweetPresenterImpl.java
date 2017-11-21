package com.andigital.twitterfeedapp.presenter;

import com.andigital.twitterfeedapp.model.Tweet;
import com.andigital.twitterfeedapp.rxJava.ObservableConfigurer;
import com.andigital.twitterfeedapp.service.TweetService;
import com.andigital.twitterfeedapp.view.TwitterListMVPView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.observers.DefaultObserver;

/**
 * Created by pjeyamukar on 20/11/2017.
 */

public class TweetPresenterImpl implements TweetPresenter {

    private final TweetService tweetService;

    private ObservableConfigurer observableConfigurer;

    private  TwitterListMVPView mvpView;
    public TweetPresenterImpl(TweetService tweetService, ObservableConfigurer observableConfigurer) {
        this.tweetService = tweetService;
        this.observableConfigurer = observableConfigurer;
    }

    @Override
    public void getTweetList() {

        if (mvpView == null) {
            return;
        }
        Observable<List<Tweet>> tweetListObs = tweetService.getTweets(
                mvpView.getListId(), mvpView.getTweetCount());

        observableConfigurer.configureObservable(tweetListObs).subscribe(getTweetListObserver());
    }

    private Observer<List<Tweet>> getTweetListObserver() {
        DefaultObserver observer = new DefaultObserver() {
            @Override
            public void onNext(Object value) {
                mvpView.onTweetsLoaded((List<Tweet>) value);
            }

            @Override
            public void onError(Throwable e) {
                mvpView.onTweetsLoadError(e);
            }

            @Override
            public void onComplete() {

            }
        };
        return observer;
    }

    @Override
    public void setMVPView(TwitterListMVPView twitterListMVPView) {
        this.mvpView = twitterListMVPView;
    }
}
