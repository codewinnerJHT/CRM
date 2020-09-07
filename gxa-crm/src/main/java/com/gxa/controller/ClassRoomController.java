package com.gxa.controller;

import com.gxa.dto.ResultDto;
import com.gxa.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/class/room")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    /**
     * 获取所有的教室
     * @return
     */
    @GetMapping("/list/all/data")
    @ResponseBody
    public ResultDto findAll(){
        return classRoomService.findAll();
    }
}
