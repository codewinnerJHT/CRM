package com.gxa.service.impl;

import com.gxa.dto.ResultDto;
import com.gxa.mapper.ClassRoomMapper;
import com.gxa.pojo.ClassRoom;
import com.gxa.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImp implements ClassRoomService {
    @Autowired
    private ClassRoomMapper classRoomMapper;

    /**
     * 获取所有的教室数据
     * @return
     */
    @Override
    public ResultDto findAll() {
        List<ClassRoom> classRooms = classRoomMapper.finAll();
        return new ResultDto(200,"获取成功！",classRooms);
    }
}
