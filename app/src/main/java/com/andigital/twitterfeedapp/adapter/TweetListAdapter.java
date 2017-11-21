package com.andigital.twitterfeedapp.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andigital.twitterfeedapp.MyApplication;
import com.andigital.twitterfeedapp.R;
import com.andigital.twitterfeedapp.model.ImageUri;
import com.andigital.twitterfeedapp.model.Tweet;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pjeyamukar on 20/11/2017.
 */

public class TweetListAdapter extends RecyclerView.Adapter<TweetListAdapter.TweetViewHolder> {


    private List<Tweet> tweetList;

    public TweetListAdapter() {
        this.tweetList= new ArrayList<>();
    }

    @Override
    public TweetListAdapter.TweetViewHolder onCreateViewHolder(ViewGroup viewGroup, int count) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.twitterlist, viewGroup, false);
        TweetViewHolder tweetViewHolder = new TweetViewHolder(view);
        tweetViewHolder.setData(tweetList.get(count));
        return  tweetViewHolder;
    }

    @Override
    public void onBindViewHolder(TweetListAdapter.TweetViewHolder tweetViewHolder, int position) {
        tweetViewHolder.setData(tweetList.get(position));
    }

    @Override
    public int getItemCount() {
        return tweetList.size();
    }

    public void addTweets(List<Tweet> tweets) {
        tweetList.addAll(tweets);
        notifyDataSetChanged();
    }

    public static class TweetViewHolder extends RecyclerView.ViewHolder
    {

//       @BindView(R.id.tweet_date)
       TextView tweetDate;

//        @BindView(R.id.tweet_body)
        TextView tweetBody;

        SimpleDraweeView twitterIcon;

        TweetViewHolder(View itemView) {
            super(itemView);
            tweetBody = itemView.findViewById(R.id.tweet_date);
            tweetDate = itemView.findViewById(R.id.tweet_body);
            Uri imageUri = Uri.parse("https://i.imgur.com/tGbaZCY.jpg");
            twitterIcon = itemView.findViewById(R.id.tweet_body_image);
            twitterIcon.setImageURI(imageUri);
            //ButterKnife.bind(this. itemView);
        }

        public void setData(Tweet data) {
            tweetDate.setText(data.createdAt());
            tweetBody.setText(data.body());
            twitterIcon.setImageURI(String.valueOf(data.getImageUri()));

        }
    }
}