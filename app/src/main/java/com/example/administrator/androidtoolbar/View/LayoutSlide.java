package com.example.administrator.androidtoolbar.View;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.administrator.androidtoolbar.R;
import com.example.administrator.androidtoolbar.Utils.TLog;

/**
 * Created by Administrator on 2017/7/4 0004.
 */

public class LayoutSlide extends RelativeLayout{

    private Context context;
    private PicAndTextBtn Dressup;
    private PicAndTextBtn Profile;
    private PicAndTextBtn Setting;
    private PicAndTextBtn night;

    public LayoutSlide(Context context) {
        super(context);
        this.context = context;
        initViews();
    }

    public LayoutSlide(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initViews();
    }

    public LayoutSlide(Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initViews();
    }

    private void initViews() {

        this.addView(LayoutInflater.from(context).inflate(R.layout.main_left_slide_layout, null));

        Dressup = (PicAndTextBtn) findViewById(R.id.PAT_dressup);
        Profile = (PicAndTextBtn) findViewById(R.id.PAT_profile);
        Setting = (PicAndTextBtn) findViewById(R.id.PAT_settting);
        night = (PicAndTextBtn) findViewById(R.id.PAT_night);

        Dressup.setOnClickListener(new PicAndTextBtn.PicAndTextBtnListener() {
            @Override
            public void onClick(View v) {
                TLog.showToast("功能开发中·········");
            }
        });

        Profile.setOnClickListener(new PicAndTextBtn.PicAndTextBtnListener() {
            @Override
            public void onClick(View v) {
                TLog.showToast("功能开发中·········");
            }
        });

        Setting.setOnClickListener(new PicAndTextBtn.PicAndTextBtnListener() {
            @Override
            public void onClick(View v) {
                TLog.showToast("功能开发中·········");
            }
        });

        night.setOnClickListener(new PicAndTextBtn.PicAndTextBtnListener() {
            @Override
            public void onClick(View v) {
                TLog.showToast("功能开发中·········");
            }
        });

    }
}
