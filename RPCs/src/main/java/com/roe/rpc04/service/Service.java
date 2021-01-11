package com.roe.rpc04.service;

import com.roe.common.IUserService;
import com.roe.common.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: HP
 * @Date: 2021/1/3 16:40
 * @Description:
 **/

public class Service {
    private static boolean running = true;

    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(8888);
        while(running){
            Socket s = ss.accept();
            process(s);
            s.close();
        }
        ss.close();
    }

    private static void process(Socket s) throws Exception{

        InputStream in= s.getInputStream();
        OutputStream out = s.getOutputStream();

        DataInputStream dis = new DataInputStream(in);
        DataOutputStream dos = new DataOutputStream(out);

        int id = dis.readInt();
        System.out.println("收到"+id);
        IUserService service = new UserServiceImpl();
        User user = service.findUserById(id);
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        System.out.println("得到姓名:"+user.getName());
        dos.flush();

    }
}
