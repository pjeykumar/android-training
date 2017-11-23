package com.andigital.twitterfeedapp;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.andigital.twitterfeedapp.adapter.TweetListAdapter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by pjeyamukar on 21/11/2017.
 */
@MediumTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule  = new  ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureRecyclerViewIsPresent() throws Exception {
        MainActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.tweetlist);
        assertThat(viewById,notNullValue());
        assertThat(viewById, instanceOf(RecyclerView.class));
        RecyclerView recyclerView = (RecyclerView) viewById;
        TweetListAdapter adapter = (TweetListAdapter) recyclerView.getAdapter();
        assertThat(adapter, instanceOf(TweetListAdapter.class));

    }

    @Test
    public void tweetsLoadedSuccessfully() throws URISyntaxException {
        String dummy_data = getJsonAsString("twitter_dummy_response.json");
        rule.launchActivity(Intent.getIntent(dummy_data));
        onView(withId(R.id.tweetlist)).check(matches(isDisplayed()));
    }

    private String getJsonAsString(String fileName) {
        StringBuilder buffer = new StringBuilder();
        InputStream is;
        try {
            is = InstrumentationRegistry.getContext().getAssets().
                    open(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String str;
            while ((str = reader.readLine())!=null) {
                buffer.append(str);
            }
            reader.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
