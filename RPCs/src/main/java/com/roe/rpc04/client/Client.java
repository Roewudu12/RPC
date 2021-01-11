package com.roe.rpc04.client;


import com.roe.common.IUserService;

/**
 * @Auther: HP
 * @Date: 2021/1/3 16:40
 * @Description: 动态代理，获得动态生成的对象service
 **/

public class Client {
    public static void main(String[] args)throws Exception {
        IUserService service = Stub.getStub();
        System.out.println(service.findUserById(1234));

    }
}
