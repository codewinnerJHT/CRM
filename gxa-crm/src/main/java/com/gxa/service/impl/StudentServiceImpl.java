package com.gxa.service.impl;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.ResultDto;
import com.gxa.excel.StudentListener;
import com.gxa.mapper.StudnetMapper;
import com.gxa.pojo.Student;
import com.gxa.pojo.Vo.StudentDownloadVo;
import com.gxa.pojo.Vo.StudentParamVo;
import com.gxa.pojo.Vo.StudentVo;
import com.gxa.service.StudentService;
import com.gxa.util.TestFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@Transactional(rollbackFor = Throwable.class)
public class StudentServiceImpl  implements StudentService {

    @Autowired
    private StudnetMapper studnetMapper;

    /**
     * 上传学生信息
     * @param file
     * @return
     * @throws IOException
     */
    public ResultDto upload(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        EasyExcel.read(inputStream, StudentVo.class,new StudentListener(studnetMapper)).sheet().doRead();
        return new ResultDto(200,"上传成功");
    }

    /**
     * 查询所有课程（带分页）
     * @param studentParamVo
     * @return
     */
    @Override
    public ResultDto getAllStudent(StudentParamVo studentParamVo) {
        PageHelper.startPage(studentParamVo.getPageNum(),studentParamVo.getPageSize());
        List<Student> students=studnetMapper.getAllStudent(studentParamVo);
        PageInfo<Student> studentPageInfo = new PageInfo<>(students);
        return new ResultDto(200,"查询所有学生信息成功",studentPageInfo);
    }

    /**
     * 文件下载
     * @return
     */
    @Override
    public ResultDto download() {

        List<StudentDownloadVo> studentDownloadVos=studnetMapper.download();
        String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, StudentDownloadVo.class).sheet("模板").doWrite(studentDownloadVos);

        return new ResultDto(200,"学生信息下载成功");
    }
}
