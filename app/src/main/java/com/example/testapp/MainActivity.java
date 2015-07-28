package com.example.testapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;


public class MainActivity extends ActionBarActivity {

    private CustomListItemAdapter customListItemAdapter;

    //Activityの始まりにinstanceを入れる
    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    //Activityの終わりにinstanceをnullにする
    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListViewに表示するデータを作成する
        List<Message> list = new ArrayList<>();
        Message message = new Message("username","body");
        list.add(message);

        ListView listView = (ListView) findViewById(R.id.ListView);
        customListItemAdapter = new CustomListItemAdapter(this, list);

        listView.setAdapter(customListItemAdapter);
    }

    public CustomListItemAdapter getMessageAdapter() {
        return this.customListItemAdapter;
    }

    //Receiverから呼ばれ、メッセージをViewに追加する
    public void addMessage(Message message) {
        getMessageAdapter().add(message);
        getMessageAdapter().notifyDataSetChanged();

    }

    public void onEvent (CustomEvent customEvent){
        addMessage(customEvent.getMessage());
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
