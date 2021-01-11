package com.roe.rpc01.client;


import com.roe.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @Auther: HP
 * @Date: 2021/1/3 16:40
 * @Description:
 **/

public class Client {
    public static void main(String[] args)throws Exception {
        Socket s= new Socket("127.0.0.1", 8888);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(2334);

        s.getOutputStream().write(baos.toByteArray());
        s.getOutputStream().flush();


        DataInputStream dis = new DataInputStream(s.getInputStream());
        int id = dis.readInt();
        String name = dis.readUTF();
        User user = new User(id,name);

        System.out.println(user);
        dos.close();
        s.close();
    }
}
