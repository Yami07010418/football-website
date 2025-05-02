package com.ch.personmis.entity;

@SuppressWarnings("all")  //去除代码的破浪线
public class BUserEntity {
    private Integer id;
    private String bemail;
    private String bpwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBemail() {
        return bemail;
    }

    public void setBemail(String bemail) {
        this.bemail = bemail;
    }

    public String getBpwd() {
        return bpwd;
    }

    public void setBpwd(String bpwd) {
        this.bpwd = bpwd;
    }
}
