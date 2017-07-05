package com.example.administrator.androidtoolbar.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.androidtoolbar.R;
import com.example.administrator.androidtoolbar.Utils.TLog;
import com.example.administrator.androidtoolbar.adapter.contactAdapter;
import com.example.administrator.androidtoolbar.bean.UserItemMsg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class contactFragment extends Fragment {

    public UserItemMsg userItemMsg;
    private List<UserItemMsg> userItemMsgList;
    private List<UserItemMsg> groupsItemMsgList;
    private ListView list_groups;
    private ListView list_contacts;
    private contactAdapter userAdapter;
    private contactAdapter groupAdapter;
    private PicAndTextBtn pat_groups;
    private PicAndTextBtn pat_contacts;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_contace, container, false);
        init();
        setAdapter();
        setListeners();

        return view;

    }

    private void setListeners() {
        TLog.p("setListener");
        pat_groups.setOnClickListener(new PicAndTextBtn.PicAndTextBtnListener() {
            @Override
            public void onClick(View v) {
                TLog.p("onclick");
                if (list_groups.getVisibility() == View.GONE) {
                    list_groups.setVisibility(View.VISIBLE);
                    TLog.p("list_groups visible");
                } else {
                    list_groups.setVisibility(View.GONE);
                    TLog.p("list_groups gone");
                }
            }
        });

        pat_contacts.setOnClickListener(new PicAndTextBtn.PicAndTextBtnListener() {
            @Override
            public void onClick(View v) {
                TLog.p("onclick");
                if (list_contacts.getVisibility() == View.GONE) {
                    list_contacts.setVisibility(View.VISIBLE);
                    TLog.p("ll_contacts visible");
                } else {
                    list_contacts.setVisibility(View.GONE);
                    TLog.p("ll_contacts gone");
                }
            }
        });

    }

    private void init() {

        list_groups = (ListView) view.findViewById(R.id.contacts_group_list);
        list_contacts = (ListView) view.findViewById(R.id.contacts_contacts_list);
        pat_groups = (PicAndTextBtn) view.findViewById(R.id.PAT_contact_groups);
        pat_contacts = (PicAndTextBtn) view.findViewById(R.id.PAT_contact_friends);
        userItemMsgList = loadUserdatas();
        groupsItemMsgList = loadGroupdatas();
    }

    private void setAdapter() {

        userAdapter = new contactAdapter(getContext(), userItemMsgList);
        groupAdapter = new contactAdapter(getContext(), groupsItemMsgList);
        list_contacts.setAdapter(userAdapter);
        list_groups.setAdapter(groupAdapter);

    }

    private List<UserItemMsg> loadGroupdatas() {
        if (groupsItemMsgList == null) {
            groupsItemMsgList = new ArrayList<>();
        }
        for (int i = 0; i < 12; i++) {
            UserItemMsg groupItemMsg = new UserItemMsg();
            groupItemMsg.setTvName("Groups " + i);
            groupItemMsg.setTvSignature("Groups info " + i);
            groupItemMsg.setIvIcon(R.drawable.avasterwe);
            groupsItemMsgList.add(groupItemMsg);
        }

        return groupsItemMsgList;
    }

    private List<UserItemMsg> loadUserdatas() {
        if (userItemMsgList == null) {
            userItemMsgList = new ArrayList<>();
        }
        for (int i = 0; i < 20; i++) {
            UserItemMsg userItemMsg = new UserItemMsg();
            userItemMsg.setTvName("Friend " + i);
            userItemMsg.setTvSignature("Friend info " + i);
            userItemMsg.setIvIcon(R.drawable.avasterwe);
            userItemMsgList.add(userItemMsg);
        }

        return userItemMsgList;
    }
}
