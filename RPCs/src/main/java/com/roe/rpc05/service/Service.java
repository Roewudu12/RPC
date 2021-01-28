package com.roe.rpc05.service;

import com.roe.common.IUserService;
import com.roe.common.User;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: HP
 * @Date: 2021/1/3 16:40
 * @Description:服务器接收客户端传入的方法信息，通过反射的方式找到方法并调用
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
        //获取输入输出流
        InputStream in= s.getInputStream();
        OutputStream out = s.getOutputStream();
        //获取输入输出对象
        ObjectInputStream ois = new ObjectInputStream(in);
        ObjectOutputStream oos = new ObjectOutputStream(out);

        //获取方法名等信息，反射调用方法
        String methodName = ois.readUTF();
        Class[] parameterTypes = (Class[]) ois.readObject();
        Object[] args = (Object[]) ois.readObject();

        //反射
        IUserService service = new UserServiceImpl();
        Method method = service.getClass().getMethod(methodName,parameterTypes);
        Object invoke = method.invoke(service, args);

        //发送给客户端
        oos.writeObject(invoke);
        oos.flush();

    }
}
