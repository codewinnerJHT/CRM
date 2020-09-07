package com.gxa.service;


import com.gxa.dto.ResultDto;
import com.gxa.pojo.Admin;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


public interface LoginService {
    /**
     *登录接口
     * @param admin
     * @param session
     * @return
     */
    ResultDto login(Admin admin, HttpSession session);

    /**
     * 退出登录接口
     * @param session
     * @return
     */
    ResultDto loginOut(HttpSession session);
}
