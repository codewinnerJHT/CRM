package com.gxa.mapper;

import com.gxa.pojo.Course;
import com.gxa.pojo.Vo.CourseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    /**
     * 获取课程所有数据
     * @return
     */
    List<Course> getAllCourse(@Param("courseVo") CourseVo courseVo);

    /**
     * 添加课程
     * @param course
     */
    void doAddCourse(@Param("course") Course course);

    /**
     * 通过课程名查询课程
     * @param courseName
     * @return
     */
    Course getCourseByName(@Param("courseName") String courseName);

    /**
     *
     * @param ids
     */
    void deleteCourseIds(@Param("ids") String[] ids);


    Course findCourseByid(@Param("id") Integer id);

    void doUpdate(@Param("course") Course course);

    List<Course> getAllCourse2();
}
