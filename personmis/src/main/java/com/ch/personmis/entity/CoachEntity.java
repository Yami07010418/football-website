package com.ch.personmis.entity;




@SuppressWarnings("all")//去除代码波浪线
//@Data
public class CoachEntity {
    private int id;//主键
    private String uname;
    private String upwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
