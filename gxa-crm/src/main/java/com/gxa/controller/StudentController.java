package com.gxa.controller;


import com.gxa.dto.ResultDto;
import com.gxa.pojo.Vo.StudentParamVo;
import com.gxa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@Controller
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    /**
     * 学生信息页面渲染
     * @return
     */
    @GetMapping("/list/page")
    public String list(){
        return "student/student-list";
    }

    /**
     * 学生信息上传
     * @return
     */
    @PostMapping("/do/upload")
    @ResponseBody
    public ResultDto upload(MultipartFile file) throws IOException {
        return studentService.upload(file);
    }

    /**
     * 查询所有信息
     * @param studentParamVo
     * @return
     */
    @GetMapping("/list/all/data")
    @ResponseBody
    public ResultDto getAllStudent(StudentParamVo studentParamVo){
        return studentService.getAllStudent(studentParamVo);
    }
    @PostMapping("/do/download")
    @ResponseBody
    public ResultDto download(){
        return studentService.download();
    }

}
