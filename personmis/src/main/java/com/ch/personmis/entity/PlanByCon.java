package com.ch.personmis.entity;

import java.util.Date;

public class PlanByCon {
    private String dname;
    private String dtype;
    private int currentPage;
    private int pageSize;
    private int  startIndex;
    private String act;
    private Date plandate1;

    public Date getPlandate1() {
        return plandate1;
    }

    public void setPlandate1(Date plandate1) {
        this.plandate1 = plandate1;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
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

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public int getStartIndex() {
        this.startIndex = (this.currentPage-1)*this.getPageSize();
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
}
