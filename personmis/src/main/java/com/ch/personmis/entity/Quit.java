package com.ch.personmis.entity;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Quit {
    private Integer id;
    private Integer staff_id;
    private String sname;
    private String qtype;
    private String act;
    //日期格式化（需要在配置文件配置FormattingConversionServiceFactoryBean）
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date qdate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date opdate;
    //日期格式化（需要在配置文件配置FormattingConversionServiceFactoryBean）
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startdate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date enddate;
    //查询时需要
    private String qdate1;
    private String opdate1;
    private int currentPage;
    private int pageSize;
    private int  startIndex;

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

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getStaff_id() {
        return staff_id;
    }
    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getQtype() {
        return qtype;
    }
    public void setQtype(String qtype) {
        this.qtype = qtype;
    }
    public Date getQdate() {
        return qdate;
    }
    public void setQdate(Date qdate) {
        this.qdate = qdate;
    }
    public Date getOpdate() {
        return opdate;
    }
    public void setOpdate(Date opdate) {
        this.opdate = opdate;
    }
    public String getQdate1() {
        return qdate1;
    }
    public void setQdate1(String qdate1) {
        this.qdate1 = qdate1;
    }
    public String getOpdate1() {
        return opdate1;
    }
    public void setOpdate1(String opdate1) {
        this.opdate1 = opdate1;
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
    public String getAct() {
        return act;
    }
    public void setAct(String act) {
        this.act = act;
    }

}
