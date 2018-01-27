package com.project.unithon.unithon;

import java.io.Serializable;

/**
 * Created by namgiwon on 2018. 1. 21..
 */

public class UserInfoVO implements Serializable {
    private String serialnumber;

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    private String token;
    private String nickname;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
