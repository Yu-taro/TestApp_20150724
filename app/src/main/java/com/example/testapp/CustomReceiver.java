package com.example.testapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.parse.ParsePushBroadcastReceiver;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CustomReceiver extends ParsePushBroadcastReceiver {
    MainActivity mainActivity = MainActivity.instance();

    //Pushを受け取った時
    @Override
    protected void onPushReceive(Context context, Intent intent) {
        Log.d("CostomReceiver", "onPushReceive");

        if (mainActivity != null) {
            Map<String, Object> map = new HashMap<String, Object>();

            //jsonデータを取り出す
            try {
                Bundle extra = intent.getExtras();
                String data = extra.getString("com.parse.Data");
                JSONObject jsonObject = new JSONObject(data);

                JSONObject sendMessage = jsonObject.getJSONObject("sendMessage");
                map.put("sendMessage", new Message(sendMessage));
                Message receiveMessage = (Message) map.get("sendMessage");
                mainActivity.addMessage(receiveMessage);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}