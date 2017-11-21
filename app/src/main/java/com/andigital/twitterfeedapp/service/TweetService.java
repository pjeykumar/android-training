package com.andigital.twitterfeedapp.service;

import com.andigital.twitterfeedapp.model.Tweet;

import java.util.List;

import retrofit2.Call;

/**
 * Created by pjeyamukar on 20/11/2017.
 */

public interface TweetService {

    Call<List<Tweet>> getTweets(String listId, int count);
}
