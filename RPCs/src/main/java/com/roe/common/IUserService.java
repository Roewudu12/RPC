package com.roe.common;

/**
 * @Auther: HP
 * @Date: 2021/1/3 16:38
 * @Description:
 **/
public interface IUserService {
    public User findUserById(Integer id);
    public User findUserByName(String name);
}
