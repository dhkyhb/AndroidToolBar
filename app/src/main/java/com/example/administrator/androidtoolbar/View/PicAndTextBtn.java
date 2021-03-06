package com.example.administrator.androidtoolbar.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.androidtoolbar.R;

/**
 * Created by Administrator on 2017/7/3 0003.
 */

public class PicAndTextBtn extends LinearLayout {

    private Context context;

    private ImageView ivPic;
    private TextView tvInfo;

    private String text;
    private float textSize;
    private int textColor;
    private Drawable textBackfround;

    private Drawable pic;
    private Drawable picBackground;

    private PicAndTextBtnListener listener;

    public PicAndTextBtn(Context context) {
        this(context, null);
    }

    public PicAndTextBtn(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        findAttrs(attrs);
        initViews();
        setLayoutParames();
        setClickListener();

    }

    public void setOnClickListener(PicAndTextBtnListener listener) {
        this.listener = listener;
    }

    public void setImageView(int id) {
        ivPic.setImageResource(id);
    }

    interface PicAndTextBtnListener {

        void onClick(View v);

    }

    private void setClickListener() {
        ivPic.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(v);
                }
            }
        });

        tvInfo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(v);
                }
            }
        });
    }

    private void setLayoutParames() {

        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        tvInfo.setGravity(Gravity.CENTER_VERTICAL);
        tvInfo.setPadding(20, 0, 0, 0);
        ivPic.setPadding(20, 0, 0, 0);

        LayoutParams imageParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(ivPic, imageParams);

        LayoutParams tvParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        addView(tvInfo, tvParams);

    }

    private void initViews() {

        ivPic = new ImageView(context);
        tvInfo = new TextView(context);

        ivPic.setImageDrawable(pic);
        ivPic.setBackground(picBackground);

        tvInfo.setText(text);
        tvInfo.setTextSize(textSize);
        tvInfo.setTextColor(textColor);
        tvInfo.setBackground(textBackfround);

        tvInfo.setGravity(Gravity.CENTER);

    }

    private void findAttrs(AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PicAndTextBtn);

        text = typedArray.getString(R.styleable.PicAndTextBtn_text);
        textSize = typedArray.getDimension(R.styleable.PicAndTextBtn_textSize, 14);
        textColor = typedArray.getColor(R.styleable.PicAndTextBtn_textColor, Color.BLACK);
        textBackfround = typedArray.getDrawable(R.styleable.PicAndTextBtn_textBackground);

        pic = typedArray.getDrawable(R.styleable.PicAndTextBtn_pic);
        picBackground = typedArray.getDrawable(R.styleable.PicAndTextBtn_picBackground);

        typedArray.recycle();

    }

}
