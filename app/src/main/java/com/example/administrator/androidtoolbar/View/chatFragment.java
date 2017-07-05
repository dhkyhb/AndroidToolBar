package com.example.administrator.androidtoolbar.View;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.androidtoolbar.R;
import com.example.administrator.androidtoolbar.adapter.chatAdapter;
import com.example.administrator.androidtoolbar.bean.UserItemMsg;
import com.example.administrator.androidtoolbar.module.chatRecyclerItemCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class chatFragment extends Fragment {

    private Context context;
    private RecyclerView mChatRecycler;
    private List<UserItemMsg> userItemMsgList;
    private chatAdapter mAdapter;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_chat, container, false);
        init();

        return view;

    }

    private void init() {
        context = getContext();
        mChatRecycler = (RecyclerView) view.findViewById(R.id.chat_fragment);

        userItemMsgList = new ArrayList<>();
        loadData();
        mAdapter = new chatAdapter(context, userItemMsgList);
        ItemTouchHelper.Callback mCallback = new chatRecyclerItemCallback(userItemMsgList, mAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mCallback);
        itemTouchHelper.attachToRecyclerView(mChatRecycler);
        mChatRecycler.setLayoutManager(new LinearLayoutManager(context));
        mChatRecycler.setItemAnimator(new DefaultItemAnimator());
        mChatRecycler.setAdapter(mAdapter);
    }

    private void loadData() {

        for (int i = 0; i < 20; i++){
            UserItemMsg userItemMsg = new UserItemMsg();
            userItemMsg.setIvIcon(R.drawable.avastertony);
            userItemMsg.setTvName("Tony Stark");
            userItemMsg.setTvSignature("You know who i am");
            userItemMsgList.add(userItemMsg);
        }
    }
}
