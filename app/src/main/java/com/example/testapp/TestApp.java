package com.example.testapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

public class TestApp extends Application {
    private final String APPLICATION_ID = "$PARSE_APP_ID";
    private final String SECRET_KEY = "$PARSE_CLIENT_KEY\"";


    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, APPLICATION_ID, SECRET_KEY);
        ParseInstallation.getCurrentInstallation().saveInBackground();


    }
}