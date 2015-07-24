package com.example.testapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private CustomListItemAdapter customListItemAdapter;
    private static MainActivity instance;

    public static MainActivity instance() {
        return instance;
    }

    //Activityの始まりにinstanceを入れる
    @Override
    protected void onResume() {
        super.onResume();
        this.instance = this;
    }

    //Activityの終わりにinstanceをnullにする
    @Override
    protected void onStop() {
        super.onStop();
        this.instance = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListViewに表示するデータを作成する
        List<JSONObject> list = new ArrayList<JSONObject>();
            JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username","username");
            jsonObject.put("body","body");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        list.add(jsonObject);


        ListView listView = (ListView) findViewById(R.id.ListView);
        customListItemAdapter = new CustomListItemAdapter(this, list);

        listView.setAdapter(customListItemAdapter);
    }

    public CustomListItemAdapter getMessageAdapter() {
        return this.customListItemAdapter;
    }

    //Receiverから呼ばれ、メッセージをViewに追加する
    public void addMessage(JSONObject message) {
        getMessageAdapter().add(message);
        getMessageAdapter().notifyDataSetChanged();
    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
