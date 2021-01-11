package com.roe.rpc02.client;

import com.roe.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @Auther: HP
 * @Date: 2021/1/3 16:54
 * @Description:对客户端进行代理（也就是对网络操作进行一层封装）
 **/

public class Stub {
    public User findUserById(Integer id) throws Exception{
        Socket s= new Socket("127.0.0.1", 8888);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(id);

        s.getOutputStream().write(baos.toByteArray());
        s.getOutputStream().flush();


        DataInputStream dis = new DataInputStream(s.getInputStream());
        int received_id = dis.readInt();
        String name = dis.readUTF();
        User user = new User(received_id,name);

        dos.close();
        s.close();

        return user;
    }
}
