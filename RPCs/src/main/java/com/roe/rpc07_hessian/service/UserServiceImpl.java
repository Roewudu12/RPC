package com.roe.rpc07_hessian.service;

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
    public User findUserByName(String name){return new User(111,name);}
}
