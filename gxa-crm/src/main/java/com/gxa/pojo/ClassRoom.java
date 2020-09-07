package com.gxa.pojo;


import com.alibaba.excel.annotation.format.DateTimeFormat;

import java.sql.Timestamp;

public class ClassRoom {

  private Integer id;
  private String num;
  private Integer volume;
  private Integer status;
  private Integer isDeleted;
  @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
  private Timestamp createTime;
  @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
  private Timestamp updateTime;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getNum() {
    return num;
  }

  public void setNum(String num) {
    this.num = num;
  }


  public Integer getVolume() {
    return volume;
  }

  public void setVolume(Integer volume) {
    this.volume = volume;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
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
    return "ClassRoom{" +
            "id=" + id +
            ", num='" + num + '\'' +
            ", volume=" + volume +
            ", status=" + status +
            ", isDeleted=" + isDeleted +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}
