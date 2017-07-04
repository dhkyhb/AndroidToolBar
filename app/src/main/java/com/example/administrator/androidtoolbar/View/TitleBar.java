package com.example.administrator.androidtoolbar.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.androidtoolbar.R;

/**
 * Created by Administrator on 2017/7/3 0003.
 */

public class TitleBar extends RelativeLayout {

    private Context context;

    private Button btnRight;
    private Button btnLeft;
    private TextView tvTitle;

    private String leftText;
    private float leftTextSize;
    private int leftTextColor;
    private Drawable leftBackground;

    private String rightText;
    private float rightTextSize;
    private int rightTextColor;
    private Drawable rightBackground;

    private String titleText;
    private float titleTextSize;
    private int titleTextColor;
    private Drawable titleBackground;

    private int generBackground;
    private titleBarClickListener listener;


    public TitleBar(Context context) {
        super(context, null);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        findAtrr(attrs);
        initViews();
        setTitleLayoutParams();
        setButtonClickListener();

    }

    private void setTitleLayoutParams() {

        btnLeft.setAllCaps(false);
        btnRight.setAllCaps(false);

        LayoutParams btnLeftLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        btnLeftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_START, TRUE);
        addView(btnLeft, btnLeftLayoutParams);

        LayoutParams btnRightLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        btnRightLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_END, TRUE);
        addView(btnRight, btnRightLayoutParams);

        LayoutParams titleLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        titleLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(tvTitle, titleLayoutParams);


    }

    private void initViews() {

        btnLeft = new Button(context);
        btnRight = new Button(context);
        tvTitle = new TextView(context);

        btnLeft.setText(leftText);
        btnLeft.setTextSize(leftTextSize);
        btnLeft.setTextColor(leftTextColor);
        btnLeft.setBackground(leftBackground);

        btnRight.setText(rightText);
        btnRight.setTextSize(rightTextSize);
        btnRight.setTextColor(rightTextColor);
        btnRight.setBackground(rightBackground);

        tvTitle.setText(titleText);
        tvTitle.setTextSize(titleTextSize);
        tvTitle.setTextColor(titleTextColor);
        tvTitle.setBackground(titleBackground);

        setBackgroundColor(generBackground);
    }

    private void findAtrr(AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);

        leftText = typedArray.getString(R.styleable.TitleBar_leftText);
        leftTextSize = typedArray.getDimension(R.styleable.TitleBar_leftTextSize, 12);
        leftTextColor = typedArray.getColor(R.styleable.TitleBar_leftTextColor, 0);
        leftBackground = typedArray.getDrawable(R.styleable.TitleBar_leftBackground);

        rightText = typedArray.getString(R.styleable.TitleBar_rightText);
        rightTextSize = typedArray.getDimension(R.styleable.TitleBar_rightTextSize, 12);
        rightTextColor = typedArray.getColor(R.styleable.TitleBar_rightTextColor, 0);
        rightBackground = typedArray.getDrawable(R.styleable.TitleBar_rightBackground);

        titleText = typedArray.getString(R.styleable.TitleBar_titleText);
        titleTextSize = typedArray.getDimension(R.styleable.TitleBar_titleTextSize, 12);
        titleTextColor = typedArray.getColor(R.styleable.TitleBar_titleTextColor, 0);
        titleBackground = typedArray.getDrawable(R.styleable.TitleBar_titleBackguround);

        generBackground = typedArray.getColor(R.styleable.TitleBar_generalBackgroundColor, 0);

        typedArray.recycle();

    }

    public interface titleBarClickListener {

        void leftClickListener();

        void rightClickListener();

    }

    public void setTitleBarClickListener(titleBarClickListener listener) {
        this.listener = listener;
    }

    public void setButtonClickListener() {
        btnLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.leftClickListener();
                }
            }
        });

        btnRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.rightClickListener();
                }
            }
        });
    }
}
