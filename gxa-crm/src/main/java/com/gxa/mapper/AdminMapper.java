package com.gxa.mapper;

import com.gxa.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author:IT-CNLM
 * @date:Created at 2020/08/12
 */
public interface AdminMapper {

    /**
     * 查询所有
     * @return
     */
    List<Admin> findAll();

    /**
     * 通过名字查询是否存在用户
     * @param name 姓名
     * @return 返回查询结果
     */
    Admin getAdminByName(@Param("name") String name);


    void updateloginTime(@Param("admin") Admin admin);
}
