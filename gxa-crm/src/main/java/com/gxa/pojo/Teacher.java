package com.gxa.pojo;


import java.sql.Timestamp;

public class Teacher {

  private Integer id;
  private String teacherName;
  private Integer teacherGender;
  private Integer teacherAge;
  private Integer courseId;
  private Integer isDeleted;
  private Timestamp createTime;
  private Timestamp updateTime;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getTeacherName() {
    return teacherName;
  }

  public void setTeacherName(String teacherName) {
    this.teacherName = teacherName;
  }


  public Integer getTeacherGender() {
    return teacherGender;
  }

  public void setTeacherGender(Integer teacherGender) {
    this.teacherGender = teacherGender;
  }


  public Integer getTeacherAge() {
    return teacherAge;
  }

  public void setTeacherAge(Integer teacherAge) {
    this.teacherAge = teacherAge;
  }


  public Integer getCourseId() {
    return courseId;
  }

  public void setCourseId(Integer courseId) {
    this.courseId = courseId;
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
    return "Teacher{" +
            "id=" + id +
            ", teacherName='" + teacherName + '\'' +
            ", teacherGender=" + teacherGender +
            ", teacherAge=" + teacherAge +
            ", courseId=" + courseId +
            ", isDeleted=" + isDeleted +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}
