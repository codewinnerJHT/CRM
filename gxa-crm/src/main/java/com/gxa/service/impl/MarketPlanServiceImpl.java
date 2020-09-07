package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.ResultDto;
import com.gxa.mapper.ClassRoomMapper;
import com.gxa.mapper.MarketPlanMapper;
import com.gxa.mapper.TeacherMapper;
import com.gxa.pojo.Course;
import com.gxa.pojo.MarketPlan;
import com.gxa.pojo.Vo.MarketPlanVo;
import com.gxa.service.MarketPlanService;
import com.gxa.util.MyValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
@Service
@Transactional(rollbackFor =Exception.class )
public class MarketPlanServiceImpl implements MarketPlanService {

    @Autowired
    private MarketPlanMapper marketPlanMapper;
    @Autowired
    private MyValidator myValidator;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private ClassRoomMapper classRoomMapper;

    Logger log = LoggerFactory.getLogger(MarketPlanServiceImpl.class);

    /**
     * 获取所有的市场计划
     * @return
     */
    @Override
    public ResultDto list(MarketPlanVo marketPlanVo) {
        System.out.println("============="+marketPlanVo);
        PageHelper.startPage(marketPlanVo.getPageNum(),marketPlanVo.getPageSize());
        List<MarketPlan> plans = marketPlanMapper.findAll(marketPlanVo);
        PageInfo<MarketPlan> pageInfo=new PageInfo<>(plans);
        System.out.println("+++++++++++++++"+pageInfo);
        return new ResultDto(200, "获取成功", pageInfo);
    }

    /**
     * 获取市场计划
     * @param marketPlan
     * @return
     */
    @Override
    public ResultDto addPlan(MarketPlan marketPlan) throws Exception {
        //数据校验
        myValidator.validate(marketPlan);
        //添加数据
        marketPlan.setCreateTime(new Timestamp(System.currentTimeMillis()));
        //更新教师状态
        teacherMapper.updateStatusById(2,marketPlan.getTeacherId());

        marketPlanMapper.save(marketPlan);

        //更新教室状态
        classRoomMapper.updateRoomStatusById(1,marketPlan.getClassRoomId());

        return new ResultDto(200,"添加成功");
    }

    /**
     * 删除市场计划
     * @param planIds
     * @param classRoomIds
     * @param teacherIds
     * @return
     */
    @Override
    public ResultDto doDelete(String[] planIds, String[] classRoomIds, String[] teacherIds) {
        //删除市场计划
        marketPlanMapper.doDelete(planIds);
        //更新教师状态
        teacherMapper.updateStatusByIds(1,teacherIds);
        //更新教室状态
        classRoomMapper.updateRoomStatusByIds(4,classRoomIds);
        return new ResultDto(200,"删除成功！");
    }


}
