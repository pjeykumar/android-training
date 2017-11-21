package com.andigital.twitterfeedapp.service;

import com.andigital.twitterfeedapp.TwitterAPI;
import com.andigital.twitterfeedapp.model.Tweet;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by pjeyamukar on 20/11/2017.
 */

public class TweetServiceImpl implements TweetService {

    private final TwitterAPI twitterAPI;

    public TweetServiceImpl(TwitterAPI twitterAPI) {
        this.twitterAPI = twitterAPI;
    }

    @Override
    public Observable<List<Tweet>> getTweets(String listId, int count) {

        Observable<List<Tweet>> observable =  twitterAPI.getTweets(listId,"extended", 1, count);

        return observable;

    }
}
