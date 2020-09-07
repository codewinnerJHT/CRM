package com.gxa.service;

import com.gxa.dto.ResultDto;
import com.gxa.pojo.Course;
import com.gxa.pojo.Vo.CourseVo;
import org.apache.ibatis.annotations.Param;

public interface CourseService {
    /**
     * 添加课程
     * @param course
     * @return
     */
    ResultDto doAddCourse(Course course);

    /**
     * 删除课程
     * @param ids
     */
    ResultDto deleteCourseIds(String[] ids);

    /**
     * 通过id查询课程信息
     * @param id
     * @return
     */
    Course findCourseByid(Integer id);

    /**
     * 更新课程
     * @param course
     * @return
     */
    ResultDto doUpdate(Course course);

    /**
     * 查询所有课程（带分页）
     * @param courseVo
     * @return
     */
    ResultDto getAllCourse(CourseVo courseVo);

    /**
     * 查询所有课程（不带分页）
     * @return
     */
    ResultDto getAllCourse();
}
