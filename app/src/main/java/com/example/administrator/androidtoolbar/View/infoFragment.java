package com.example.administrator.androidtoolbar.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.androidtoolbar.R;
import com.example.administrator.androidtoolbar.adapter.AdapterMoment;
import com.example.administrator.androidtoolbar.bean.MomentMsg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class infoFragment extends Fragment {

    private View rootView;
    private List<MomentMsg> momentMsgList;
    private RecyclerView momentRecyclerView;
    private TextView tvMoment;
    private AdapterMoment adaptermoment;
    private Button btnSend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_info, container, false);
        initViews();
        addDates();
        setAdapter();
        setListeners();

        return rootView;

    }

    private void setListeners() {

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MomentMsg msg = new MomentMsg();
                msg.setUserName("Stark");
                msg.setIconId(R.drawable.avasterwe);
                msg.setMoment(tvMoment.getText().toString());
                msg.setLike(R.drawable.ungood);
                //数据增加在首位
                momentMsgList.add(0, msg);
                adaptermoment.notifyDataSetChanged();
            }
        });

    }

    private void setAdapter() {

        adaptermoment = new AdapterMoment(getContext(), momentMsgList);
        momentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        momentRecyclerView.setAdapter(adaptermoment);

    }

    private void addDates() {

        for (int i = 0; i < 10; i++) {
            MomentMsg msg = new MomentMsg();
            msg.setUserName("stark" + i);
            msg.setIconId(R.drawable.avasterwe);
            msg.setMoment("you like then you subscribe " + i);
            msg.setLike((i % 3) == 1 ? R.drawable.good : R.drawable.ungood);
            momentMsgList.add(msg);
        }

    }

    private void initViews() {

        momentRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_list_moments);
        tvMoment = (TextView) rootView.findViewById(R.id.tv_moment_new);
        btnSend = (Button) rootView.findViewById(R.id.btn_moment_send);

        momentMsgList = new ArrayList<>();
    }

}
