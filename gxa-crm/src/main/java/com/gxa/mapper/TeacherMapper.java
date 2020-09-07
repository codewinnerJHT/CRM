package com.gxa.mapper;

import com.gxa.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    /**
     * 通过教师id查询教教师信息
     * @param id
     * @return
     */
    Teacher findById(@Param("id")Integer id);

    /**
     * 通过课程id查询课程信息
     * @param courseId
     * @return
     */
    List<Teacher> findAll(@Param("courseId") Integer courseId);


    void updateStatusById(@Param("status") Integer status,@Param("teacherId") Integer teacherId);

    void updateStatusByIds(@Param("status")Integer status,@Param("teacherIds") String[] teacherIds);
}
