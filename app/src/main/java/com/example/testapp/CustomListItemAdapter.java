package com.example.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class CustomListItemAdapter extends ArrayAdapter<JSONObject> {

    private LayoutInflater mLayoutInflater;

    public CustomListItemAdapter(Context context, List<JSONObject> objects) {
        super(context, 0, objects);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        // ListViewに表示する分のレイアウトが生成されていない場合レイアウトを作成する
        if (convertView == null) {
            // レイアウトファイルからViewを生成する
            view = mLayoutInflater.inflate(R.layout.custom_list_item, parent, false);
        } else {
            // レイアウトが存在する場合は再利用する
            view = convertView;
        }

        // リストアイテムに対応するデータを取得する
        JSONObject item = getItem(position);
        try {
            // 各Viewに表示する情報を設定
            TextView username = (TextView) view.findViewById(R.id.username);
            username.setText(item.getString("username"));
            TextView body = (TextView) view.findViewById(R.id.body);
            body.setText(item.getString("body"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return view;
    }

}