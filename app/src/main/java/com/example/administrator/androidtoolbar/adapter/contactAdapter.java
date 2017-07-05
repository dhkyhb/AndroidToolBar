package com.example.administrator.androidtoolbar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.androidtoolbar.R;
import com.example.administrator.androidtoolbar.bean.UserItemMsg;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class contactAdapter extends BaseAdapter {

    private Context context;
    private List<UserItemMsg> userItemMsgList;
    private LayoutInflater inflater;

    public contactAdapter(Context context, List<UserItemMsg> userItemMsgList) {
        this.context = context;
        this.userItemMsgList = userItemMsgList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return userItemMsgList.size();
    }

    @Override
    public Object getItem(int position) {
        return userItemMsgList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.chat_recycler, null);
            viewholder = new Viewholder();
            viewholder.ivAvatar = (ImageView) convertView.findViewById(R.id.iv_chat_icon);
            viewholder.tvName = (TextView) convertView.findViewById(R.id.tv_chat_name);
            viewholder.tvInfo = (TextView) convertView.findViewById(R.id.tv_chat_signature);
            convertView.setTag(viewholder);
        }else{
            viewholder = (Viewholder) convertView.getTag();
        }

        viewholder.ivAvatar.setImageResource(userItemMsgList.get(position).getIvIcon());
        viewholder.tvName.setText(userItemMsgList.get(position).getTvName());
        viewholder.tvInfo.setText(userItemMsgList.get(position).getTvSignature());
        return convertView;
    }


    static class Viewholder{

       ImageView ivAvatar;
       TextView tvName;
       TextView tvInfo;

    }

}
