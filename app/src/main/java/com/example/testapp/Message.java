package com.example.testapp;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;


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

//    public Message(Map<String, String > message) {
//        this.username = message.containsKey("username") ? message.get("username") : null;
//        this.body = message.containsKey("body") ? message.get("body") : null;
//    }


    public String getUsername() {
        return this.username;
    }

    public String getBody() {
        return this.body;
    }

}
