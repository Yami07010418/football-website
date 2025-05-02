package com.ch.personmis.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Examine {
    private Integer id;
    private String sname;
    private String sex;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    private String sid;
    private Integer depart_id;
    private Integer post_id;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date entrydate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date joinworkdate;
    private String workform;
    private String staffsource;
    private String score;
//    private String politicalstatus;
    private String nation;
    private int price;
//    private String nativeplace;
    private String stel;
    private String semail;
    private Double sheight;
    private String bloodtype;
    private  int  weight;
    private String maritalstatus;
    private String registeredresidence;
    private String education;
    private String degree;
    private String university;
    private String  picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    //    private String major;
    private  String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    private byte[] logoFile;

    public byte[] getLogoFile() {
        return logoFile;
    }

    public void setLogoFile(byte[] logoFile) {
        this.logoFile = logoFile;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date graduationdate;

    //以下查询时使用
    private String dname;//部门名称，查询时使用
    private String pname;//岗位名称，查询时使用

    private String birthday1;
    private String entrydate1;
    private String joinworkdate1;
    private String graduationdate1;
    private String startdate1;
    private String enddate1;
    //试用期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startdate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date enddate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date peroidopdate;
    private String status;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Integer getDepart_id() {
        return depart_id;
    }

    public void setDepart_id(Integer depart_id) {
        this.depart_id = depart_id;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public Date getJoinworkdate() {
        return joinworkdate;
    }

    public void setJoinworkdate(Date joinworkdate) {
        this.joinworkdate = joinworkdate;
    }

    public String getWorkform() {
        return workform;
    }

    public void setWorkform(String workform) {
        this.workform = workform;
    }

    public String getStaffsource() {
        return staffsource;
    }

    public void setStaffsource(String staffsource) {
        this.staffsource = staffsource;
    }

//    public String getPoliticalstatus() {
//        return politicalstatus;
//    }
//
//    public void setPoliticalstatus(String politicalstatus) {
//        this.politicalstatus = politicalstatus;
//    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
//
//    public String getNativeplace() {
//        return nativeplace;
//    }
//
//    public void setNativeplace(String nativeplace) {
//        this.nativeplace = nativeplace;
//    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public Double getSheight() {
        return sheight;
    }

    public void setSheight(Double sheight) {
        this.sheight = sheight;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public int getWeight() {
        return weight;

    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    //    public String getMaritalstatus() {
//        return maritalstatus;
//    }
//
//    public void setMaritalstatus(String maritalstatus) {
//        this.maritalstatus = maritalstatus;
//    }

    public String getRegisteredresidence() {
        return registeredresidence;
    }

    public void setRegisteredresidence(String registeredresidence) {
        this.registeredresidence = registeredresidence;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    //    public String getMajor() {
//        return major;
//    }
//
//    public void setMajor(String major) {
//        this.major = major;
//    }

    public Date getGraduationdate() {
        return graduationdate;
    }

    public void setGraduationdate(Date graduationdate) {
        this.graduationdate = graduationdate;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getBirthday1() {
        return birthday1;
    }

    public void setBirthday1(String birthday1) {
        this.birthday1 = birthday1;
    }

    public String getEntrydate1() {
        return entrydate1;
    }

    public void setEntrydate1(String entrydate1) {
        this.entrydate1 = entrydate1;
    }

    public String getJoinworkdate1() {
        return joinworkdate1;
    }

    public void setJoinworkdate1(String joinworkdate1) {
        this.joinworkdate1 = joinworkdate1;
    }

    public String getGraduationdate1() {
        return graduationdate1;
    }

    public void setGraduationdate1(String graduationdate1) {
        this.graduationdate1 = graduationdate1;
    }

    public String getStartdate1() {
        return startdate1;
    }

    public void setStartdate1(String startdate1) {
        this.startdate1 = startdate1;
    }

    public String getEnddate1() {
        return enddate1;
    }

    public void setEnddate1(String enddate1) {
        this.enddate1 = enddate1;
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

    public Date getPeroidopdate() {
        return peroidopdate;
    }

    public void setPeroidopdate(Date peroidopdate) {
        this.peroidopdate = peroidopdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
