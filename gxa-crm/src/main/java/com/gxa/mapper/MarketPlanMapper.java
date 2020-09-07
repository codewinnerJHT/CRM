package com.gxa.mapper;

import com.gxa.pojo.MarketPlan;
import com.gxa.pojo.Vo.MarketPlanVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MarketPlanMapper {
    /**
     * 获取所有市场计划
     * @return
     */
    List<MarketPlan> findAll(@Param("marketPlanVo") MarketPlanVo marketPlanVo);

    /**
     * 添加市场计划
     * @param marketPlan
     */
    void save(@Param("marketPlan") MarketPlan marketPlan);

    /**
     * 删除市场计划
     * @param planIds
     */
    void doDelete(@Param("planIds") String[] planIds);
}
