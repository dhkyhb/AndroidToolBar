package com.example.administrator.androidtoolbar.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.administrator.androidtoolbar.R;

/**
 * Created by YHB on 2017/6/6 0006.
 *
 * 欢迎界面，持续5S
 */

public class activity_welcome extends AppCompatActivity {

    private static final int GOGUIDE = 0;
    private static final int GOMAIN = 1;
    private static final int DELAY = 2000;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case GOGUIDE:
                goGuide();
                break;
                case GOMAIN:
                goLogin();
                break;

            }

        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        initData();
    }

    private void initData() {
        SharedPreferences guide_login = getSharedPreferences("chatRoom", MODE_PRIVATE);
        boolean firstUse = guide_login.getBoolean("firstuse", true);
        if (firstUse) {
            handler.sendEmptyMessageDelayed(GOGUIDE, DELAY);
            SharedPreferences.Editor editor = guide_login.edit();
            editor.putBoolean("firstuse", false);
            editor.commit();
        } else {
            handler.sendEmptyMessageDelayed(GOMAIN, DELAY);
        }
    }

    private void goLogin() {
        Intent i_Login = new Intent(this, activity_login_register.class);
        startActivity(i_Login);
        finish();
    }

    private void goGuide() {
        Intent i_Guide = new Intent(this, activity_guide.class);
        startActivity(i_Guide);
        finish();
    }

}
