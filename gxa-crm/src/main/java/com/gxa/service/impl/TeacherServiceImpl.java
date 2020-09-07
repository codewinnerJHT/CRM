package com.gxa.service.impl;

import com.gxa.dto.ResultDto;
import com.gxa.mapper.TeacherMapper;
import com.gxa.pojo.Teacher;
import com.gxa.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 通过课程id获取教室信息
     * @param courseId
     * @return
     */
    @Override
    public ResultDto findAll(Integer courseId) {
        List<Teacher> teacher = teacherMapper.findAll(courseId);
        return new ResultDto(200,"查询成功",teacher);
    }
}
