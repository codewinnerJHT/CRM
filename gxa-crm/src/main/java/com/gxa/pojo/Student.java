package com.gxa.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Student {

  private long id;
  private String stuName;
  private Integer stuAge;
  private Integer stuGender;
  private long stuPhone;
  private String stuHobby;
  private Integer stuCourseIntention;
  private String parentName;
  private long parentPhone;
  private Integer activityId;
  private Integer consultantId;
  private Integer deposit;
  private Integer idDeleted;
  private Integer status;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
  private Timestamp createTime;
  private Timestamp updateTime;

  public Student() {
  }

  public Student(String stuName, Integer stuAge, Integer stuGender, long stuPhone, String stuHobby, Integer stuCourseIntention, String parentName, long parentPhone, Integer activityId, Integer consultantId, Integer deposit, Timestamp createTime) {
    this.stuName = stuName;
    this.stuAge = stuAge;
    this.stuGender = stuGender;
    this.stuPhone = stuPhone;
    this.stuHobby = stuHobby;
    this.stuCourseIntention = stuCourseIntention;
    this.parentName = parentName;
    this.parentPhone = parentPhone;
    this.activityId = activityId;
    this.consultantId = consultantId;
    this.deposit = deposit;
    this.createTime = createTime;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getStuName() {
    return stuName;
  }

  public void setStuName(String stuName) {
    this.stuName = stuName;
  }


  public Integer getStuAge() {
    return stuAge;
  }

  public void setStuAge(Integer stuAge) {
    this.stuAge = stuAge;
  }


  public Integer getStuGender() {
    return stuGender;
  }

  public void setStuGender(Integer stuGender) {
    this.stuGender = stuGender;
  }


  public long getStuPhone() {
    return stuPhone;
  }

  public void setStuPhone(long stuPhone) {
    this.stuPhone = stuPhone;
  }


  public String getStuHobby() {
    return stuHobby;
  }

  public void setStuHobby(String stuHobby) {
    this.stuHobby = stuHobby;
  }


  public Integer getStuCourseIntention() {
    return stuCourseIntention;
  }

  public void setStuCourseIntention(Integer stuCourseIntention) {
    this.stuCourseIntention = stuCourseIntention;
  }


  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }


  public long getParentPhone() {
    return parentPhone;
  }

  public void setParentPhone(long parentPhone) {
    this.parentPhone = parentPhone;
  }


  public Integer getActivityId() {
    return activityId;
  }

  public void setActivityId(Integer activityId) {
    this.activityId = activityId;
  }


  public Integer getConsultantId() {
    return consultantId;
  }

  public void setConsultantId(Integer consultantId) {
    this.consultantId = consultantId;
  }


  public Integer getDeposit() {
    return deposit;
  }

  public void setDeposit(Integer deposit) {
    this.deposit = deposit;
  }


  public Integer getIdDeleted() {
    return idDeleted;
  }

  public void setIdDeleted(Integer idDeleted) {
    this.idDeleted = idDeleted;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }


  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }


  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", stuName='" + stuName + '\'' +
            ", stuAge=" + stuAge +
            ", stuGender=" + stuGender +
            ", stuPhone=" + stuPhone +
            ", stuHobby='" + stuHobby + '\'' +
            ", stuCourseIntention=" + stuCourseIntention +
            ", parentName='" + parentName + '\'' +
            ", parentPhone=" + parentPhone +
            ", activityId=" + activityId +
            ", consultantId=" + consultantId +
            ", deposit=" + deposit +
            ", idDeleted=" + idDeleted +
            ", status=" + status +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}
