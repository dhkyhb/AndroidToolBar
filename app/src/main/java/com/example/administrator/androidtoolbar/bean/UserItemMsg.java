package com.example.administrator.androidtoolbar.bean;

/**
 * Created by Administrator on 2017/7/4 0004.
 */

public class UserItemMsg {

    private int ivIcon;
    private String tvName;
    private String tvSignature;

    public UserItemMsg()
    {

    }
    public UserItemMsg(int ivIcon, String tvName, String tvSignature) {
        this.ivIcon = ivIcon;
        this.tvName = tvName;
        this.tvSignature = tvSignature;
    }

    public int getIvIcon() {
        return ivIcon;
    }

    public void setIvIcon(int ivIcon) {
        this.ivIcon = ivIcon;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getTvSignature() {
        return tvSignature;
    }

    public void setTvSignature(String tvSignature) {
        this.tvSignature = tvSignature;
    }

    @Override
    public String toString() {
        return "UserItemMsg{" +
                "ivIcon=" + ivIcon +
                ", tvName='" + tvName + '\'' +
                ", tvSignature='" + tvSignature + '\'' +
                '}';
    }
}
