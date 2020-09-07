package com.gxa.pojo.Vo;

public class MarketPlanVo {

    private String planEndTime;

    private String keyWords;

    private Integer courseId;

    private Integer status;

    private Integer pageNum;

    private Integer pageSize;

    public MarketPlanVo() {
    }

    public MarketPlanVo(String planEndTime, String keyWords, Integer courseId, Integer status, Integer pageNum, Integer pageSize) {
        this.planEndTime = planEndTime;
        this.keyWords = keyWords;
        this.courseId = courseId;
        this.status = status;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public String getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(String planEndTime) {
        this.planEndTime = planEndTime;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "MarketPlanVo{" +
                "planEndTime='" + planEndTime + '\'' +
                ", keyWords='" + keyWords + '\'' +
                ", courseId=" + courseId +
                ", status=" + status +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
