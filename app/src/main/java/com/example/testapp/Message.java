package com.example.testapp;


import org.json.JSONException;
import org.json.JSONObject;


public class Message {
    private String username;
    private String body;

    public Message(String username, String body) {
        this.username = username;
        this.body = body;
    }

    public Message(JSONObject jsonObject) {

        try {
            this.username = jsonObject.getString("username");
            this.body = jsonObject.getString("body");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return this.username;
    }

    public String getBody() {
        return this.body;
    }

}
