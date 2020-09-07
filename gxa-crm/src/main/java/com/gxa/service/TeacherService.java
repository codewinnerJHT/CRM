package com.gxa.service;


import com.gxa.dto.ResultDto;


public interface TeacherService {
    /**
     * 通过课程id查询课程信息
     * @param courseId
     * @return
     */
    ResultDto findAll(Integer courseId);

}
