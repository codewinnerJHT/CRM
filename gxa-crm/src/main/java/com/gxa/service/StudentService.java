package com.gxa.service;

import com.gxa.dto.ResultDto;
import com.gxa.pojo.Vo.StudentParamVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StudentService {

    /**
     * 上传学生信息
     * @param file
     * @return
     * @throws IOException
     */
    ResultDto upload(MultipartFile file) throws IOException;

    /**
     * 获取查询所有课程
     * @param studentParamVo
     * @return
     */
    ResultDto getAllStudent(StudentParamVo studentParamVo);

    ResultDto download();
}
