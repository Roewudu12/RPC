package com.roe.rpc05.client;

import com.roe.common.IUserService;
import com.roe.common.User;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @Auther: HP
 * @Date: 2021/1/5 16:54
 * @Description:动态代理，动态调用服务器方法。通过网络传递方法名、参数等信息到服务器端
 **/

public class Stub {
    public static IUserService getStub(){
        //动态代理的Handler
        InvocationHandler h = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //链接网络将信息发送到服务器端
                Socket s= new Socket("127.0.0.1",8888);

                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

                //传递方法名称以及参数等信息
                String methodName = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                oos.writeUTF(methodName);
                oos.writeObject(parameterTypes);
                oos.writeObject(args);
                oos.flush();

                //获取从服务器传递回来的信息
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Object o = ois.readObject();
                ois.close();
                s.close();
                return o;
            }
        };
        //创建动态代理对象
        Object o = Proxy.newProxyInstance(IUserService.class.getClassLoader(),new Class[]{IUserService.class},h);
        System.out.println(o.getClass().getName());
        System.out.println(o.getClass().getInterfaces()[0]);
        return (IUserService) o;
    }

}
