package com.sunxu.ssm.chapter2.proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 孙许
 * @date 2018/09/06
 */
public class JdkProxy implements InvocationHandler {
    /**
     * 真实对象
     */
    private Object target = null;
    private static Logger logger = LogManager.getLogger(JdkProxy.class);

    /**
     * 代理方法逻辑
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("进入代理逻辑方法");
        // 相当于调用了sayHelloWorld方法，obj是方法的返回值
        Object obj = method.invoke(target, args);
        logger.info("在调度真实对象之后的服务");
        return obj;
    }

    /**
     * 建立代理对象和真实对象的代理关系，并返回代理对象
     * @param target
     * @return
     */
    public Object  bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }
}
