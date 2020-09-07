package com.gxa.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class MarketPlan {

  private Integer id;
  @NotBlank(message = "计划名称不能为空")
  private String planName;
  @NotBlank(message = "计划详情不能为空")
  private String planDetail;
  private Integer status;
  private Integer courseId;
  private Integer teacherId;
  private Integer classRoomId;
  private Integer planStuCount;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
  private Timestamp planEndTime;
  private Integer isDeleted;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
  private Timestamp createTime;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
  private Timestamp updateTime;

  /*
     计划关联的课程
   */
  private Course course;
  /*
     计划关联的老师
   */
  private Teacher teacher;

  /*
   计划关联的教室
   */
  private ClassRoom classRoom;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getPlanName() {
    return planName;
  }

  public void setPlanName(String planName) {
    this.planName = planName;
  }


  public String getPlanDetail() {
    return planDetail;
  }

  public void setPlanDetail(String planDetail) {
    this.planDetail = planDetail;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  public Integer getCourseId() {
    return courseId;
  }

  public void setCourseId(Integer courseId) {
    this.courseId = courseId;
  }


  public Integer getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(Integer teacherId) {
    this.teacherId = teacherId;
  }


  public Integer getClassRoomId() {
    return classRoomId;
  }

  public void setClassRoomId(Integer classRoomId) {
    this.classRoomId = classRoomId;
  }


  public Integer getPlanStuCount() {
    return planStuCount;
  }

  public void setPlanStuCount(Integer planStuCount) {
    this.planStuCount = planStuCount;
  }


  public Timestamp getPlanEndTime() {
    return planEndTime;
  }

  public void setPlanEndTime(Timestamp planEndTime) {
    this.planEndTime = planEndTime;
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


  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public ClassRoom getClassRoom() {
    return classRoom;
  }

  public void setClassRoom(ClassRoom classRoom) {
    this.classRoom = classRoom;
  }

  @Override
  public String toString() {
    return "MarketPlan{" +
            "id=" + id +
            ", planName='" + planName + '\'' +
            ", planDetail='" + planDetail + '\'' +
            ", status=" + status +
            ", courseId=" + courseId +
            ", teacherId=" + teacherId +
            ", classRoomId=" + classRoomId +
            ", planStuCount=" + planStuCount +
            ", planEndTime=" + planEndTime +
            ", isDeleted=" + isDeleted +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", course=" + course +
            ", teacher=" + teacher +
            ", classRoom=" + classRoom +
            '}';
  }
}
