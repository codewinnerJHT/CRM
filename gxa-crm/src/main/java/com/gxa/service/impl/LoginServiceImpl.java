package com.gxa.service.impl;

import com.gxa.dto.ResultDto;
import com.gxa.mapper.AdminMapper;
import com.gxa.pojo.Admin;
import com.gxa.service.LoginService;
import com.gxa.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 登录业务代码
     * @param admin 用户信息
     * @param session 对象
     * @return
     */
    @Override
    public ResultDto login(Admin admin, HttpSession session) {

        Admin dbadmin = adminMapper.getAdminByName(admin.getName());
        if (dbadmin.getName() == null) {
            return new ResultDto(1001,"用户不存在");
        }
        if (!dbadmin.getPwd().equals(MD5Util.MD5(admin.getPwd()))){
            return new ResultDto(1002,"密码错误，请重新输入");
        }
        //保存session会话
        session.setAttribute("admin",dbadmin.getName());
        //设置最后登录时间
        dbadmin.setLastLoginTime(new Timestamp(System.currentTimeMillis()));

        adminMapper.updateloginTime(dbadmin);

        return new ResultDto(200,"登录成功");
    }

    /**
     * 退出登录删除session对象
     * @param session
     * @return
     */
    @Override
    public ResultDto loginOut(HttpSession session) {
        if (session != null){
            session.removeAttribute("admin");
        }
        return new ResultDto(200,"退出成功");
    }
}
