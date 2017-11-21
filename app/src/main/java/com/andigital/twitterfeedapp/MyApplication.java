package com.andigital.twitterfeedapp;

import android.app.Application;
import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;


/**
 * Created by pjeyamukar on 20/11/2017.
 */

public class MyApplication extends Application {

    private MyAppComponent myAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        myAppComponent = DaggerMyAppComponent.builder().myAppModule(new MyAppModule(this)).build();
    }

    public MyAppComponent getMyAppComponent() {
        return myAppComponent;
    }
}
