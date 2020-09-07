package com.gxa.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.gxa.mapper.StudnetMapper;
import com.gxa.pojo.Student;
import com.gxa.pojo.Vo.StudentVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(rollbackFor = Throwable.class)
public class StudentListener extends AnalysisEventListener<StudentVo> {

    /**
     * 日志记录器
     */
    private static final Logger LOGGER  = LoggerFactory.getLogger(AdminListener.class);

    private StudnetMapper studnetMapper;
    private Map<String ,Integer> gender=new HashMap<>(16);

    public StudentListener() {
    }

    public StudentListener(StudnetMapper studnetMapper){
        this.studnetMapper = studnetMapper;

        gender.put("男",0);
        gender.put("女",1);
        gender.put("不详",2);
    }



    /**
     * 每次5条
     */
    private static final int BATCH_COUNT = 5;

    List<Student> list = new ArrayList<Student>(BATCH_COUNT);

    @Override
    public void invoke(StudentVo studentVo, AnalysisContext analysisContext) {
        System.out.println("解析开始");
        System.out.println(studentVo.toString());
        Student student=new Student(
                studentVo.getStuName(),studentVo.getStuAge(),gender.get(studentVo.getStuStrGender()),
                studentVo.getStuPhone(),studentVo.getStuHobby(),studentVo.getStuCourseIntention(),studentVo.getParentName(),
                studentVo.getParentPhone(),studentVo.getActivityId(),studentVo.getConsultantId(),studentVo.getDeposit(),
                studentVo.getCreateTime());
        list.add(student);
        if (list.size() == BATCH_COUNT){
            studnetMapper.save(list);
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        if (!list.isEmpty()){
            studnetMapper.save(list);
        }
        System.out.println("解析结束");
    }
}
