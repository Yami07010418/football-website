package com.ch.personmis.entity;

import java.util.Date;

public class Plan {
    private Integer id;
    private Date plandate;
    private Date plandate1;
    private String dname;
    private String dtype;
    private String dtel;
    private String dfax;
    private String description;
    private Integer supdepartment;
    private Date establishmentdate;
    private String establishmentdate1;//查询时使用
    private String supdepartment1;//查询时使用
    private  Integer coach_id;
    private  int currentPage;
    private  int pageSize;

    public Integer getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(Integer coach_id) {
        this.coach_id = coach_id;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }


    public Date getPlandate1() {
        return plandate1;
    }

    public void setPlandate1(Date plandate1) {
        this.plandate1 = plandate1;
    }

    public Date getPlandate() {
        return plandate;
    }

    public void setPlandate(Date plandate) {
        this.plandate = plandate;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public String getDtel() {
        return dtel;
    }
    public void setDtel(String dtel) {
        this.dtel = dtel;
    }
    public String getDfax() {
        return dfax;
    }
    public void setDfax(String dfax) {
        this.dfax = dfax;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getSupdepartment() {
        return supdepartment;
    }
    public void setSupdepartment(Integer supdepartment) {
        this.supdepartment = supdepartment;
    }
    public Date getEstablishmentdate() {
        return establishmentdate;
    }
    public void setEstablishmentdate(Date establishmentdate) {
        this.establishmentdate = establishmentdate;
    }
    public String getEstablishmentdate1() {
        return establishmentdate1;
    }
    public void setEstablishmentdate1(String establishmentdate1) {
        this.establishmentdate1 = establishmentdate1;
    }
    public String getSupdepartment1() {
        return supdepartment1;
    }
    public void setSupdepartment1(String supdepartment1) {
        this.supdepartment1 = supdepartment1;
    }

}
