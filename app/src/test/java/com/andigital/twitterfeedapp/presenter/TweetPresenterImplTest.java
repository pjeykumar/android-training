package com.andigital.twitterfeedapp.presenter;

import com.andigital.twitterfeedapp.model.Tweet;
import com.andigital.twitterfeedapp.rxJava.ObservableConfigurer;
import com.andigital.twitterfeedapp.service.TweetService;
import com.andigital.twitterfeedapp.view.TwitterListMVPView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DefaultObserver;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by pjeyamukar on 21/11/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class TweetPresenterImplTest {

    @Mock
    private TweetService tweetServiceMock;

    @Mock
    private ObservableConfigurer observableConfigurerMock;

    @Mock
    private TwitterListMVPView mvpViewTestMock;

    @InjectMocks
    private TweetPresenterImpl tweetPresenterMock;

    private  final String LIST_ID = "listId";
    private  final int COUNT = 5;


    @Test
    public void getTweetlistTest(){
        //given
        Observable<List<Tweet>> observableTweetList = getObservableTweetInstance();
        given(tweetServiceMock.getTweets(anyString(),anyInt())).willReturn(observableTweetList);
        when(observableConfigurerMock.configureObservable(observableTweetList)).thenReturn(observableTweetList);
        when(mvpViewTestMock.getListId()).thenReturn(LIST_ID);
        when(mvpViewTestMock.getTweetCount()).thenReturn(COUNT);

        //when
        tweetPresenterMock.getTweetList();

        //then
        assertEquals(mvpViewTestMock.getListId(),LIST_ID);
        assertEquals(mvpViewTestMock.getTweetCount(),5);
        //verify(tweetServiceMock, atLeastOnce()).getTweets(LIST_ID,COUNT);
        //verify(observableConfigurerMock).configureObservable(observableTweetList);


    }

    private Observable<List<Tweet>> getObservableTweetInstance(){
        return new Observable<List<Tweet>>() {
            @Override
            protected void subscribeActual(Observer<? super List<Tweet>> observer) {

            }
        };
    }

}
