package com.gxa.mapper;

import com.gxa.pojo.Student;
import com.gxa.pojo.Vo.StudentDownloadVo;
import com.gxa.pojo.Vo.StudentParamVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudnetMapper {

    /**
     * 上传学生信息
     * @param list
     */
    void save(@Param("list") List<Student> list);

    List<Student> getAllStudent(@Param("studentParamVo") StudentParamVo studentParamVo);

    List<StudentDownloadVo> download();
}
