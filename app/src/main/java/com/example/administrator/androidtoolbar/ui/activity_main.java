package com.example.administrator.androidtoolbar.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TabHost;

import com.example.administrator.androidtoolbar.R;
import com.example.administrator.androidtoolbar.Utils.PicManager;
import com.example.administrator.androidtoolbar.View.TitleBar;
import com.example.administrator.androidtoolbar.View.chatFragment;
import com.example.administrator.androidtoolbar.View.contactFragment;
import com.example.administrator.androidtoolbar.View.infoFragment;
import com.example.administrator.androidtoolbar.adapter.fragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YHB on 2017/6/6 0006.
 *
 * 主界面，目前分为聊天，联系人，信息
 */

public class activity_main extends AppCompatActivity{

    private TabHost tabHMainLayout;
    private List<TabLayout.Tab> tabList;
    private ViewPager vp_main;
    private fragmentAdapter chatAdapter;
    private List<Fragment> frag_lists;
    private TabLayout tab_main;
    private DrawerLayout dl_main;

    private TitleBar titleBar;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        initView();
        setAdapter();
        setListener();
    }

    private void setListener() {

        /**
         *  setTabTextColor 设置选中未选中文本颜色
         */
        tab_main.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                tabList.get(position).setIcon(PicManager.BOTTOM_TITLE_PIC[position]);
                tab_main.setTabTextColors(ContextCompat.getColor(activity_main.this,
                        R.color.black), ContextCompat.getColor(activity_main.this,
                        R.color.blue));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                tabList.get(position).setIcon(PicManager.BOTTOM_TITLE_PIC[position + 3]);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        titleBar.setTitleBarClickListener(new TitleBar.titleBarClickListener() {
            @Override
            public void leftClickListener() {
                dl_main.openDrawer(Gravity.LEFT);
            }

            @Override
            public void rightClickListener() {

            }
        });

    }

    /**
     * setupwithViewpager中带有removealltab
     * 所以在关联之后再设置
     * */
    private void setAdapter() {
        chatAdapter = new fragmentAdapter(getSupportFragmentManager(), frag_lists);
        vp_main.setAdapter(chatAdapter);
        tab_main.setupWithViewPager(vp_main);
//        tab_main.getTabAt(0).setText("Chat");
//        tab_main.getTabAt(1).setText("Contacts");
//        tab_main.getTabAt(2).setText("Info");
        tabList.add(tab_main.getTabAt(0));
        tabList.add(tab_main.getTabAt(1));
        tabList.add(tab_main.getTabAt(2));
        tabList.get(0).setIcon(R.drawable.msgselected).setText("Chat");
        tabList.get(1).setIcon(R.drawable.contactsunselected).setText("Contacts");
        tabList.get(2).setIcon(R.drawable.momentunselected).setText("Moments");
    }

    private void initView() {
        tabList = new ArrayList<>();
        vp_main = (ViewPager) findViewById(R.id.viewp_main);
        tab_main = (TabLayout) findViewById(R.id.tabL_main);
        titleBar = (TitleBar) findViewById(R.id.titlebar_main);
        dl_main = (DrawerLayout) findViewById(R.id.dl_main);

        frag_lists = new ArrayList<>();
        frag_lists.add(new chatFragment());
        frag_lists.add(new contactFragment());
        frag_lists.add(new infoFragment());

    }

//    private String updateTabLayout(String text){
//            TextView tab_tv = new TextView(this);
//            tab_tv.setTextSize(14);
//            tab_tv.setGravity(Gravity.CENTER);
//            tab_tv.setTextColor(getResources().getColor(R.color.tabwidget_title));
//            tab_tv.setTypeface(Typeface.MONOSPACE);
//        return (String) tab_tv.getText();
//        }
}
