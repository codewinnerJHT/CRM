package com.gxa.pojo.Vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.gxa.excel.String2TimeStampConverter;


import java.sql.Timestamp;

public class StudentVo {

    @ExcelProperty(index = 0)
    private String stuName;

    @ExcelProperty(index = 1)
    private Integer stuAge;

    @ExcelProperty(index = 2)
    private String stuStrGender;

    @ExcelProperty(index = 3)
    private long stuPhone;

    @ExcelProperty(index = 4)
    private String stuHobby;

    @ExcelProperty(index = 5)
    private Integer stuCourseIntention;

    @ExcelProperty(index = 6)
    private String parentName;

    @ExcelProperty(index = 7)
    private long parentPhone;

    @ExcelProperty(index = 8)
    private Integer activityId;

    @ExcelProperty
    private Integer consultantId;

    @ExcelProperty(index = 10)
    private Integer deposit;

    @ExcelProperty(index = 11)
    private Integer status;

   @ExcelProperty(index = 12, converter = String2TimeStampConverter.class)
    private Timestamp createTime;

    public StudentVo() {
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

    public String getStuStrGender() {
        return stuStrGender;
    }

    public void setStuStrGender(String stuStrGender) {
        this.stuStrGender = stuStrGender;
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


    @Override
    public String toString() {
        return "StudentVo{" +
                "stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                ", stuStrGender='" + stuStrGender + '\'' +
                ", stuPhone=" + stuPhone +
                ", stuHobby='" + stuHobby + '\'' +
                ", stuCourseIntention=" + stuCourseIntention +
                ", parentName='" + parentName + '\'' +
                ", parentPhone=" + parentPhone +
                ", activityId=" + activityId +
                ", consultantId=" + consultantId +
                ", deposit=" + deposit +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';

    }

}
