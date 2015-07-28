package com.example.testapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.parse.ParsePushBroadcastReceiver;

import org.json.JSONException;
import org.json.JSONObject;

public class CustomReceiver extends ParsePushBroadcastReceiver {
    MainActivity mainActivity = MainActivity.instance();

    //Pushを受け取った時
    @Override
    protected void onPushReceive(Context context, Intent intent) {
        Log.d("CostomReceiver", "onPushReceive");

        if (mainActivity != null) {

            //jsonデータを取り出す
            try {
                Bundle extra = intent.getExtras();
                String data = extra.getString("com.parse.Data");
                JSONObject jsonObject = new JSONObject(data);

                JSONObject sendMessage = jsonObject.getJSONObject("sendMessage");
                Message receiveMessage = new Message(sendMessage);
                mainActivity.addMessage(receiveMessage);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}