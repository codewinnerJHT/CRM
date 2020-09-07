package com.gxa.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.lang.reflect.Parameter;
import java.sql.Timestamp;

public class Course {

  private Integer id;
  private String courseName;
  private String courseDesc;
  private double coursePrice;
  private Integer courseCount;
  private Integer isDeleted;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
  private Timestamp createTime;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
  private Timestamp updateTime;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }


  public String getCourseDesc() {
    return courseDesc;
  }

  public void setCourseDesc(String courseDesc) {
    this.courseDesc = courseDesc;
  }


  public double getCoursePrice() {
    return coursePrice;
  }

  public void setCoursePrice(double coursePrice) {
    this.coursePrice = coursePrice;
  }


  public Integer getCourseCount() {
    return courseCount;
  }

  public void setCourseCount(Integer courseCount) {
    this.courseCount = courseCount;
  }


  public Integer getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(Integer isDeleted) {
    this.isDeleted = isDeleted;
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
    return "Course{" +
            "id=" + id +
            ", courseName='" + courseName + '\'' +
            ", courseDesc='" + courseDesc + '\'' +
            ", coursePrice=" + coursePrice +
            ", courseCount=" + courseCount +
            ", isDeleted=" + isDeleted +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}
