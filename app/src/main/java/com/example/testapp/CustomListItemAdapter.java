package com.example.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListItemAdapter extends ArrayAdapter<Message> {

    private LayoutInflater mLayoutInflater;

    static class ViewHolder {
        TextView usernameTextView;
        TextView bodyTextView;
    }

    public CustomListItemAdapter(Context context, List<Message> objects) {
        super(context, 0, objects);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.custom_list_item, parent, false);
            holder = new ViewHolder();
            holder.usernameTextView = (TextView) convertView.findViewById(R.id.username);
            holder.bodyTextView = (TextView) convertView.findViewById(R.id.body);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // リストアイテムに対応するデータを取得する
        Message item = getItem(position);
        // 各Viewに表示する情報を設定
        holder.usernameTextView.setText(item.getUsername());
        holder.bodyTextView.setText(item.getBody());

        return convertView;
    }

}