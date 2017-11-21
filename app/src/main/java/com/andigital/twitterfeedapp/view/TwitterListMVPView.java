package com.andigital.twitterfeedapp.view;

import com.andigital.twitterfeedapp.model.Tweet;

import java.util.List;

/**
 * Created by pjeyamukar on 20/11/2017.
 */

public interface TwitterListMVPView {

    String getListId();
    int getTweetCount();
    void onTweetsLoaded(List<Tweet> tweets);
    void onTweetsLoadError(Throwable throwable);
    void onTweetLoadComplete();
   // void showTwitterImage();
}
