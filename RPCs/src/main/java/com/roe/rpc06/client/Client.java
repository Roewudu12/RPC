package com.roe.rpc06.client;


import com.roe.common.IUserService;

/**
 * @Auther: HP
 * @Date: 2021/1/3 16:40
 * @Description: 动态代理，获得动态生成的对象service
 * client端可以调用任何方法，但服务器端中还是传普通的对象回来（用ObjectInputStream与ObjectOutPutStream）
 **/

public class Client {
    public static void main(String[] args)throws Exception {
        //只要调stub方法就可以获取任意用户想要的对象
        IUserService service = (IUserService) Stub.getStub(IUserService.class);
        System.out.println(service.findUserByName("Alices12300"));

    }
}
