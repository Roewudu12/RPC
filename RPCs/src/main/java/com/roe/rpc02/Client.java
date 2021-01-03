package com.roe.rpc02;


import com.roe.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @Auther: HP
 * @Date: 2021/1/3 16:40
 * @Description: 直接调用代理Stub获得User
 **/

public class Client {
    public static void main(String[] args)throws Exception {
        Stub stub = new Stub();
        User user = stub.findUserById(4578);
        System.out.println(user);

    }
}
