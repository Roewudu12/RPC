package com.roe.rpc07_hessian;

import java.io.Serializable;

/**
 * @Auther: HP
 * @Date: 2021/1/28 16:05
 * @Description:Rpc服务端响应结果包装类，在网络上进行传输。
 **/

public class RpcResponse implements Serializable {
    private Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
