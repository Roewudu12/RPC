package com.roe.rpc07_hessian;

import java.io.Serializable;

/**
 * @Auther: HP
 * @Date: 2021/1/28 16:01
 * @Description:rpc请求对象
 **/

public class RpcRequest implements Serializable {
    private String className;//类名
    private String methodName;//方法名
    private Class<?>[] paramTypes;//请求参数类型
    private Object[] args;//请求的参数值

    public RpcRequest(){}
    public RpcRequest(String className, String methodName, Class<?>[] paramTypes, Object[] args) {
        this.className = className;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.args = args;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class<?>[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
