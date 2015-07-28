package com.example.testapp;


public class EventBus {
    public static final int PUSH_OPEN = 0;
    public static final int PUSH_RECIEVE = 1;
    private int action;

    public void setAction(int action) {
        this.action = action;
    }
    public int getAction() {
        return this.action;
    }
}
