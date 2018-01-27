package com.project.unithon.unithon;

import java.io.Serializable;

/**
 * Created by namgiwon on 2018. 1. 21..
 */

public class UserInfoVO implements Serializable {


   private String age;
   private String sex;
   private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
