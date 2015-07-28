package com.example.testapp;


public class CustomEvent {

    private Message message;

    public CustomEvent (Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return this.message;
    }

}
