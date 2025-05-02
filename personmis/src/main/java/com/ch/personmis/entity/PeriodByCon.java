package com.ch.personmis.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PeriodByCon {
    private String sname;
    private int depart_id;
    private int post_id;
    private String status;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startdate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date enddate;
    private int currentPage;
    private int pageSize;
    private int startIndex;
    private String act;

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getDepart_id() {
        return depart_id;
    }

    public void setDepart_id(int depart_id) {
        this.depart_id = depart_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        this.startIndex = (this.currentPage-1)*this.getPageSize();
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
}
