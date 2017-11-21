package com.andigital.twitterfeedapp.presenter;

import com.andigital.twitterfeedapp.view.TwitterListMVPView;

/**
 * Created by pjeyamukar on 20/11/2017.
 */

public interface TweetPresenter {

    void getTweetList();
    void setMVPView(TwitterListMVPView twitterListMVPView);
}
