package com.project.unithon.unithon;

/**
 * Created by namgiwon on 2018. 1. 21..
 */


public class SharedMemory {
    private static SharedMemory sharedMemory = null;
    private static UserInfoVO userinfo = null;

    public static synchronized SharedMemory getinstance(){
        if(sharedMemory == null){
            sharedMemory = new SharedMemory();
        }
        if(userinfo == null){
            userinfo = new UserInfoVO();
        }
        return sharedMemory;
    }

    private String url;
    private String serialnumber;
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserInfoVO getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfoVO userinfo) {
        this.userinfo = userinfo;
    }
}