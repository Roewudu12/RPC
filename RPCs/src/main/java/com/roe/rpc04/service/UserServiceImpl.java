package com.roe.rpc04.service;

import com.roe.common.IUserService;
import com.roe.common.User;

/**
 * @Auther: HP
 * @Date: 2021/1/3 16:39
 * @Description:
 **/

public class UserServiceImpl implements IUserService {
    public User findUserById(Integer id) {
        return new User(id,"Alice");
    }
}
