package com.gxa.controller;

import com.gxa.dto.ResultDto;
import com.gxa.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 通过课程id获取老师信息
     * @param CourseId
     * @return
     */
    @GetMapping("/list/course/{CourseId}")
    @ResponseBody
    public ResultDto getTeacherByCourseId(@PathVariable Integer CourseId){
        return teacherService.findAll(CourseId);
    }
}
