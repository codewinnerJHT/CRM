package com.gxa.pojo;


import java.sql.Timestamp;

public class Consultant {

  private Integer id;
  private String name;
  private Integer age;
  private Integer gender;
  private Integer phone;
  private Integer qq;
  private Integer isDeleted;
  private Timestamp createTime;
  private Timestamp updateTime;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }


  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }


  public Integer getPhone() {
    return phone;
  }

  public void setPhone(Integer phone) {
    this.phone = phone;
  }


  public Integer getQq() {
    return qq;
  }

  public void setQq(Integer qq) {
    this.qq = qq;
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
    return "Consultant{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", gender=" + gender +
            ", phone=" + phone +
            ", qq=" + qq +
            ", isDeleted=" + isDeleted +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}
