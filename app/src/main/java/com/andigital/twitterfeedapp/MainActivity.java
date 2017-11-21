package com.andigital.twitterfeedapp;

import android.net.Uri;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.andigital.twitterfeedapp.adapter.TweetListAdapter;
import com.andigital.twitterfeedapp.model.Tweet;
import com.andigital.twitterfeedapp.presenter.TweetPresenter;
import com.andigital.twitterfeedapp.view.TwitterListMVPView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;


import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements TwitterListMVPView {

    @Inject
    TweetPresenter tweetPresenter;

    @BindView(R.id.tweetlist)
    RecyclerView tweetlist;

    private TweetListAdapter tweetListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication)getApplication()).getMyAppComponent().inject(this);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tweetlist.setLayoutManager(new LinearLayoutManager(this));
        tweetPresenter.setMVPView(this);
        tweetListAdapter = new TweetListAdapter();
        tweetlist.setAdapter(tweetListAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tweetPresenter.getTweetList();
    }

    @Override
    public String getListId() {
        return getString(R.string.twitter_list_id);
    }

    @Override
    public int getTweetCount() {
        return 10;
    }

    @Override
    public void onTweetsLoaded(List<Tweet> tweets) {
        Log.d("MainActivity", tweets.size() + "tweets loaded");
        tweetListAdapter.addTweets(tweets);

    }

    @Override
    public void onTweetsLoadError(Throwable throwable) {

    }

    @Override
    public void onTweetLoadComplete() {

    }
}
