package com.andigital.twitterfeedapp.service;

import com.andigital.twitterfeedapp.TwitterAPI;
import com.andigital.twitterfeedapp.model.Tweet;

import java.util.List;

import retrofit2.Call;

/**
 * Created by pjeyamukar on 20/11/2017.
 */

public class TweetServiceImpl implements TweetService {

    private final TwitterAPI twitterAPI;

    public TweetServiceImpl(TwitterAPI twitterAPI) {
        this.twitterAPI = twitterAPI;
    }

    @Override
    public Call<List<Tweet>> getTweets(String listId, int count) {

        Call<List<Tweet>> observable =  twitterAPI.getTweets(listId,"extended", 1, count);

        return observable;

    }
}
