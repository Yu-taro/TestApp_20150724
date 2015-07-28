package com.example.testapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

public class TestApp extends Application {
    private final String APPLICATION_ID = "TQodYeroaXQOhBVHPaPy0C5WflrAJwlwTBD1wOZK";
    private final String SECRET_KEY = "Dst27A2baIAE0ISwy6u0yXvEm2z8oxOAFaHTDJBt";

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, APPLICATION_ID, SECRET_KEY);
        ParseInstallation.getCurrentInstallation().saveInBackground();


    }
}