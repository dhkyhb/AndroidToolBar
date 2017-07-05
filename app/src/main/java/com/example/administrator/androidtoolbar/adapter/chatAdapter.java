package com.example.administrator.androidtoolbar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.androidtoolbar.R;
import com.example.administrator.androidtoolbar.Utils.TLog;
import com.example.administrator.androidtoolbar.bean.UserItemMsg;

import java.util.List;

/**
 * Created by Administrator on 2017/7/4 0004.
 */

public class chatAdapter extends RecyclerView.Adapter<chatAdapter.chatViewHolder> {

    private Context context;
    private List<UserItemMsg> userItemMsgList;

    public chatAdapter(Context context, List<UserItemMsg> userItemMsgList){
        this.context = context;
        this.userItemMsgList = userItemMsgList;
    }

    @Override
    public chatAdapter.chatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        chatViewHolder holder = new chatViewHolder(LayoutInflater.from(context).inflate(R.layout.chat_recycler, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(chatAdapter.chatViewHolder holder, int position) {
        holder.ivIcon.setImageResource(userItemMsgList.get(position).getIvIcon());
        holder.tvName.setText(userItemMsgList.get(position).getTvName());
        holder.tvSignature.setText(userItemMsgList.get(position).getTvSignature());
    }

    @Override
    public int getItemCount() {
        return (userItemMsgList == null ? 0 : userItemMsgList.size());
    }

    class chatViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivIcon;
        private TextView tvName;
        private TextView tvSignature;

         chatViewHolder(View itemView) {
            super(itemView);

            ivIcon = (ImageView) itemView.findViewById(R.id.iv_chat_icon);
            tvName = (TextView) itemView.findViewById(R.id.tv_chat_name);
            tvSignature = (TextView) itemView.findViewById(R.id.tv_chat_signature);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TLog.showToast(tvName.getText().toString());
                }
            });

        }
    }

}
