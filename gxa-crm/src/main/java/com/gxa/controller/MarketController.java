package com.gxa.controller;

import com.gxa.dto.ResultDto;
import com.gxa.pojo.MarketPlan;
import com.gxa.pojo.Vo.MarketPlanVo;
import com.gxa.service.MarketPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 市场控制器
 */
@Controller
@RequestMapping("/market/plan")
public class MarketController {
    @Autowired
    private MarketPlanService marketPlanService;


    /**
     * 市场计划列表
     * @return
     */
    @GetMapping("/list")
    public String listPage(){
        return "market/market-plan-list";
    }

    /**
     * 获取所有市场计划数据
     * @return
     */
    @GetMapping("/list/data")
    @ResponseBody
    public ResultDto list(MarketPlanVo marketPlanVo){
        try {
            URLDecoder.decode(marketPlanVo.getKeyWords(),"UTF-8");
            marketPlanVo.setKeyWords(URLDecoder.decode(marketPlanVo.getKeyWords(),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return marketPlanService.list(marketPlanVo);
    }

    /**
     * 添加页面
     * @return
     */
    @GetMapping("/add/page")
    public String addPage(){
        return "market/market-plan-add";
    }

    /**
     * 添加市场计划
     * @param marketPlan
     * @return
     */
    @PostMapping("/doAdd")
    @ResponseBody
    public ResultDto doAdd(MarketPlan marketPlan) throws Exception {
        System.out.println("市场计划参数{out}"+marketPlan.toString());
        return marketPlanService.addPlan(marketPlan);
    }

    /**
     * 删除市场计划
     * @param planIds
     * @param classRoomIds
     * @param teacherIds
     * @return
     */
    @PostMapping("/doDelete")
    @ResponseBody
    public ResultDto doDelete(@RequestParam(name = "planIds[]") String[] planIds,
                              @RequestParam(name="classRoomIds[]")String[] classRoomIds,
                              @RequestParam(name = "teacherIds[]")String[] teacherIds){
        return marketPlanService.doDelete(planIds,classRoomIds,teacherIds);
    }

}
