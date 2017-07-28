package com.example.administrator.androidtoolbar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.androidtoolbar.R;
import com.example.administrator.androidtoolbar.bean.MomentMsg;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28 0028.
 */

public class AdapterMoment extends RecyclerView.Adapter<AdapterMoment.ViewHolder>{

    private Context context;
    private List<MomentMsg> msgList;
    private LayoutInflater inflater;

    public AdapterMoment(Context context, List<MomentMsg> msgList) {
        this.context = context;
        this.msgList = msgList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public AdapterMoment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_moment, parent, false));
    }

    @Override
    public void onBindViewHolder(AdapterMoment.ViewHolder holder, int position) {
        holder.tvusername.setText(msgList.get(position).getUserName());
        holder.tvMoment.setText(msgList.get(position).getMoment());
        holder.ivIcon.setImageResource(msgList.get(position).getIconId());
        holder.ivLikes.setImageResource(msgList.get(position).getLike());
    }

    @Override
    public int getItemCount() {
        return (msgList == null ? 0 : msgList.size());
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvusername;
        private TextView tvMoment;
        private ImageView ivIcon;
        private ImageView ivLikes;

        public ViewHolder(View itemView) {
            super(itemView);
            tvusername = (TextView) itemView.findViewById(R.id.tv_moment_content_username);
            tvMoment = (TextView) itemView.findViewById(R.id.tv_moment_content);
            ivIcon = (ImageView) itemView.findViewById(R.id.iv_moment_content_avatar);
            ivLikes = (ImageView) itemView.findViewById(R.id.iv_good);
        }
    }

}
