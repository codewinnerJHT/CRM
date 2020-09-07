package com.gxa.controller;

import com.gxa.dto.ResultDto;
import com.gxa.pojo.Course;
import com.gxa.pojo.Vo.CourseVo;
import com.gxa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 渲染课程页面
     * @return
     */
    @GetMapping("/list")
    public String listPage(){
        return "/course/course-list";
    }

    /**
     * 渲染添加课程页面
     * @return
     */
    @GetMapping("/add")
    public String addPage(){
        return "/course/course-add";
    }


    /**
     * 获取所有课程
     * @param courseVo
     * @return
     */
    @GetMapping("/getAllCourse")
    @ResponseBody
    public ResultDto getAllCourse(CourseVo courseVo) throws UnsupportedEncodingException {

           URLDecoder.decode(courseVo.getKeyWords(),"UTF-8");
           courseVo.setKeyWords(URLDecoder.decode(courseVo.getKeyWords(),"UTF-8"));
        return courseService.getAllCourse(courseVo);
    }

    /**
     * 获取所有课程，不分页
     * @param
     * @return
     */
    @GetMapping("/list/all/data")
    @ResponseBody
    public ResultDto getAllCourse(){
        return courseService.getAllCourse();
    }


    /**
     * 添加课程
     * @param course
     * @return
     */
    @PostMapping("/doAddCourse")
    @ResponseBody
    public ResultDto doAddCourse(Course course){
        return courseService.doAddCourse(course);
    }


    /**
     * 删除课程
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public ResultDto deleteCourseIds(@RequestParam(name = "ids[]") String[] ids){
        System.out.println("=========="+ids.toString());
        return courseService.deleteCourseIds(ids);
    }

    /**
     * 更新课程页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model){
        Course course = courseService.findCourseByid(id);
        model.addAttribute("course",course);
        return "/course/course-edit";
    }

    /**
     * 更新课程
     * @param course
     * @return
     */
    @PostMapping("/doUpdate")
    @ResponseBody
    public ResultDto doUpdate(Course course){
        return courseService.doUpdate(course);
    }
}
