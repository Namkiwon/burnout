package com.project.unithon.unithon;


public class TimelineVO {
    private int type;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    private int date; //날짜 차이
    private String contents;
    private int highfive;
    private String name;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getHighfive() {
        return highfive;
    }

    public void setHighfive(int highfive) {
        this.highfive = highfive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}