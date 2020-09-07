package com.gxa.service;

import com.gxa.dto.ResultDto;
import com.gxa.pojo.MarketPlan;
import com.gxa.pojo.Vo.MarketPlanVo;

public interface MarketPlanService {

    /**
     * 获取列表数据
     * @return
     */
    ResultDto list(MarketPlanVo marketPlanVo);

    /**
     * 添加市场计划
     * @param marketPlan
     * @return
     */
    ResultDto addPlan(MarketPlan marketPlan) throws Exception;

    /**
     * 删除市场计划
     * @param planIds
     * @param classRoomIds
     * @param teacherIds
     * @return
     */
    ResultDto doDelete(String[] planIds,String[] classRoomIds,String[] teacherIds);
}
