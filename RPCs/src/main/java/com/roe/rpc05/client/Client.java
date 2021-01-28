package com.roe.rpc05.client;


import com.roe.common.IUserService;

/**
 * @Auther: HP
 * @Date: 2021/1/3 16:40
 * @Description: 动态代理，获得动态生成的对象service
 * client端可以调用热歌方法，但服务器端中还是传普通的对象回来（用ObjectInputStream与ObjectOutPutStream）
 **/

public class Client {
    public static void main(String[] args)throws Exception {
        //只要调stub方法就可以利用IUserService
        IUserService service = Stub.getStub();
        System.out.println(service.findUserByName("Alicesss"));

    }
}
