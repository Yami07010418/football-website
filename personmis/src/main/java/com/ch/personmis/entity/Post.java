package com.ch.personmis.entity;

public class Post {
    private Integer id;
    private String pname;
    private String ptype;
    private Integer organization;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getPtype() {
        return ptype;
    }
    public void setPtype(String ptype) {
        this.ptype = ptype;
    }
    public Integer getOrganization() {
        return organization;
    }
    public void setOrganization(Integer organization) {
        this.organization = organization;
    }
}
