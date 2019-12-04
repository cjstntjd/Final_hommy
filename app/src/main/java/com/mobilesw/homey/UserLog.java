package com.mobilesw.homey;

import java.io.Serializable;

public class UserLog implements Serializable {

    private String userID;
    private String logDesc;
    private String date;

    public UserLog() {

    }

    public UserLog(String userID, String logDesc, String date) {
        this.userID = userID;
        this.logDesc = logDesc;
        this.date = date;
    }

    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
