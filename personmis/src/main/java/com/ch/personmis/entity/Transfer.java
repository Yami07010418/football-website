package com.ch.personmis.entity;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Transfer {
    private Integer id;
    private Integer staff_id;
    private Integer beforepost_id;
    private Integer afterpost_id;
    private String sname;
    private String ttype;
    private String beforepost_name;
    private String afterpost_name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date tdate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date opdate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startdate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date enddate;
    //查询时需要
    private String tdate1;
    private String opdate1;
    private int currentPage;
    private int pageSize;
    private int  startIndex;
    private String act;
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
    public Integer getBeforepost_id() {
        return beforepost_id;
    }
    public void setBeforepost_id(Integer beforepost_id) {
        this.beforepost_id = beforepost_id;
    }
    public Integer getAfterpost_id() {
        return afterpost_id;
    }
    public void setAfterpost_id(Integer afterpost_id) {
        this.afterpost_id = afterpost_id;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getTtype() {
        return ttype;
    }
    public void setTtype(String ttype) {
        this.ttype = ttype;
    }
    public String getBeforepost_name() {
        return beforepost_name;
    }
    public void setBeforepost_name(String beforepost_name) {
        this.beforepost_name = beforepost_name;
    }
    public Date getTdate() {
        return tdate;
    }
    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }
    public Date getOpdate() {
        return opdate;
    }
    public void setOpdate(Date opdate) {
        this.opdate = opdate;
    }
    public String getTdate1() {
        return tdate1;
    }
    public void setTdate1(String tdate1) {
        this.tdate1 = tdate1;
    }
    public String getOpdate1() {
        return opdate1;
    }
    public void setOpdate1(String opdate1) {
        this.opdate1 = opdate1;
    }
    public String getAfterpost_name() {
        return afterpost_name;
    }
    public void setAfterpost_name(String afterpost_name) {
        this.afterpost_name = afterpost_name;
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
