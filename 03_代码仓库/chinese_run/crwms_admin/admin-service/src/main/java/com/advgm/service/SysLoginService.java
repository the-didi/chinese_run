package com.advgm.service;

import com.advgm.model.LoginResult;

/**
 * 登录的接口
 */
public interface SysLoginService {

    /**
     * 登录的实现
     * @param username
     *  用户名
     * @param password
     *
     * 用户的密码
     * @return
     * 登录的结果
     */
    LoginResult login(String username ,String password) ;
}
