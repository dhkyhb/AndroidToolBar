package com.example.administrator.androidtoolbar.bean;

/**
 * Created by Administrator on 2017/7/28 0028.
 */

public class MomentMsg {

    private int iconId;
    private String userName;
    private String moment;
    private int like;

    public int getIconId() {
        return iconId;
    }

    public String getUserName() {
        return userName;
    }

    public String getMoment() {
        return moment;
    }

    public int getLike() {
        return like;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMoment(String moment) {
        this.moment = moment;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "MomentMsg{" +
                "iconId=" + iconId +
                ", userName='" + userName + '\'' +
                ", moment='" + moment + '\'' +
                ", like=" + like +
                '}';
    }
}
