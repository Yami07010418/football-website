package com.ch.personmis.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Report {
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startdate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date enddate;
    private int currentPage;
    private int pageSize;
    private int  startIndex;
    private String act;

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

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }
}
