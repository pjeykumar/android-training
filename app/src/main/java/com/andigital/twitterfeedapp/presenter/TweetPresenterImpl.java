package com.andigital.twitterfeedapp.presenter;

import com.andigital.twitterfeedapp.model.Tweet;
import com.andigital.twitterfeedapp.service.TweetService;
import com.andigital.twitterfeedapp.view.TwitterListMVPView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pjeyamukar on 20/11/2017.
 */

public class TweetPresenterImpl implements TweetPresenter {

    private final TweetService tweetService;

    private  TwitterListMVPView mvpView;
    public TweetPresenterImpl(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @Override
    public void getTweetList() {

        Call<List<Tweet>> tweetListCall = tweetService.getTweets(mvpView.getListId(), mvpView.getTweetCount());
        tweetListCall.enqueue(new Callback<List<Tweet>>() {
            @Override
            public void onResponse(Call<List<Tweet>> call, Response<List<Tweet>> response) {
                mvpView.onTweetsLoaded(response.body());
            }

            @Override
            public void onFailure(Call<List<Tweet>> call, Throwable t) {
                mvpView.onTweetsLoadError(t);
            }
        });
    }

    @Override
    public void setMVPView(TwitterListMVPView twitterListMVPView) {
        this.mvpView = twitterListMVPView;
    }
}
