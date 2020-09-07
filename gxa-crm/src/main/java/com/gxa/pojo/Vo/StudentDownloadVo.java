package com.gxa.pojo.Vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.gxa.excel.String2TimeStampConverter;

import java.sql.Timestamp;

public class StudentDownloadVo {


    @ExcelProperty("学生姓名")
    private String stuName;

    @ExcelProperty("学生年龄")
    private Integer stuAge;

    @ExcelProperty("学生性别")
    private String stuStrGender;

    @ExcelProperty("学生电话")
    private long stuPhone;

    @ExcelProperty("学生爱好")
    private String stuHobby;

    @ExcelProperty("学员意向课程")
    private Integer stuCourseIntention;

    @ExcelProperty("家长姓名")
    private String parentName;

    @ExcelProperty("家长电话")
    private long parentPhone;

    @ExcelProperty("参加活动")
    private Integer activityId;

    @ExcelProperty
    private Integer consultantId;

    @ExcelProperty("支付金额")
    private Integer deposit;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("日期")
    private Timestamp createTime;

    public StudentDownloadVo() {
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

    public StudentDownloadVo(String stuName, Integer stuAge, String stuStrGender, long stuPhone, String stuHobby, Integer stuCourseIntention, String parentName, long parentPhone, Integer activityId, Integer consultantId, Integer deposit, Integer status, Timestamp createTime) {
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuStrGender = stuStrGender;
        this.stuPhone = stuPhone;
        this.stuHobby = stuHobby;
        this.stuCourseIntention = stuCourseIntention;
        this.parentName = parentName;
        this.parentPhone = parentPhone;
        this.activityId = activityId;
        this.consultantId = consultantId;
        this.deposit = deposit;
        this.status = status;
        this.createTime = createTime;
    }
}
