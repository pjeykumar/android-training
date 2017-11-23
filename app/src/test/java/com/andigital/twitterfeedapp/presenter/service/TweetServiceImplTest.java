package com.andigital.twitterfeedapp.presenter.service;

import com.andigital.twitterfeedapp.TwitterAPI;
import com.andigital.twitterfeedapp.model.Tweet;
import com.andigital.twitterfeedapp.service.TweetService;
import com.andigital.twitterfeedapp.service.TweetServiceImpl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by pjeyamukar on 21/11/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class TweetServiceImplTest {

    @Mock
    private TwitterAPI twitterAPIMock;

    @InjectMocks
    private TweetServiceImpl tweetServiceImplMock;


    @Test
    public void shouldReturnListofTweet_mock(){

        //Given
        Observable<List<Tweet>> tweets = getObservableTweetInstance();
        given(twitterAPIMock.get_Tweets(anyString(),anyString(),anyInt(),anyInt())).willReturn(tweets);

        //When
        Observable<List<Tweet>> tweet_lists = tweetServiceImplMock.getTweets("listId",1);

        //then
        assertThat(tweet_lists,instanceOf(Observable.class));
        verify(twitterAPIMock, atLeastOnce()).get_Tweets("listId","extended",1,1);
    }

    private Observable<List<Tweet>> getObservableTweetInstance(){
        return new Observable<List<Tweet>>() {
            @Override
            protected void subscribeActual(Observer<? super List<Tweet>> observer) {

            }
        };
    }

}
