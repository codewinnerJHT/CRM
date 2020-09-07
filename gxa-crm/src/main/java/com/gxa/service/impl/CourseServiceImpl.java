package com.gxa.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.ResultDto;
import com.gxa.mapper.CourseMapper;
import com.gxa.pojo.Course;
import com.gxa.pojo.Vo.CourseVo;
import com.gxa.service.CourseService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Timestamp;
import java.util.List;


@Service
@Transactional(rollbackFor =Exception.class )
public class CourseServiceImpl implements CourseService {


    @Autowired
    private CourseMapper courseMapper;

    /**
     * 查询所有课程
     * @return
     */
  @Override
    public ResultDto getAllCourse() {
        List<Course> allCourse = courseMapper.getAllCourse2();
        return new ResultDto(200,"查询所有课程成功",allCourse);
    }

    /**
     * 添加课程
     * @param course
     * @return
     */
    @Override
    public ResultDto doAddCourse(Course course) {
        Course courseByName = courseMapper.getCourseByName(course.getCourseName());
        if (courseByName != null){
            return new ResultDto(1003,"课程名重复,请重新添加");
        }
        course.setCreateTime(new Timestamp(System.currentTimeMillis()));
        courseMapper.doAddCourse(course);
        return new ResultDto(200,"添加成功");
    }

    /**
     * 删除课程
     * @param ids
     * @return
     */
    @Override
    public ResultDto deleteCourseIds(String[] ids) {
        courseMapper.deleteCourseIds(ids);
        return new ResultDto(200,"删除成功");
    }

    /**
     * 通过课程Id，查询课程
     * @param id
     * @return
     */
    @Override
    public Course findCourseByid(Integer id) {
        return courseMapper.findCourseByid(id);
    }

    /**
     * 更新课程
     * @param course
     * @return
     */
    @Override
    public ResultDto doUpdate(Course course) {
        course.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        courseMapper.doUpdate(course);
        return new ResultDto(200,"修改成功");
    }

    /**
     * 查询课程
     * @param courseVo
     * @return
     */
    @Override
    public ResultDto getAllCourse(CourseVo courseVo) {
        PageHelper.startPage(courseVo.getPageNum(),courseVo.getPageSize());
        List<Course> allCourse = courseMapper.getAllCourse(courseVo);
        PageInfo<Course> pageInfo=new PageInfo<>(allCourse);
        return new ResultDto(200,"查询所有课程成功",pageInfo);
    }

}
