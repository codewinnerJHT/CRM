package com.gxa.mapper;

import com.gxa.dto.ResultDto;
import com.gxa.pojo.ClassRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassRoomMapper {

    /**
     * 通过id获取教室
     * @param id
     * @return
     */
    ClassRoom findById(@Param("id") Integer id);

    /**
     * 获取所有的课程数据
     * @return
     */
    List<ClassRoom> finAll();

    void updateRoomStatusById(@Param("status") Integer status,@Param("classRoomId") Integer classRoomId);

    void updateRoomStatusByIds(@Param("status") Integer status, @Param("classRoomIds") String[] classRoomIds);
}
