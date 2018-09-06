package com.sunxu.ssm.chapter2.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;

/**
 * @author 孙许
 * @date 2018/09/07
 */
public class CglibProxy implements MethodInterceptor {

    private static Logger logger = LogManager.getLogger(CglibProxy.class);

    /**
     * 生成CGLIB代理对象
     * @param cls Class类
     * @return 生成Class类的CGLIB代理对象
     */
    public Object getProxy(Class cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * 代理逻辑方法
     * @param obj
     * @param method
     * @param args
     * @param proxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        logger.info("调用真实对象前");
        Object result = proxy.invokeSuper(obj, args);
        logger.info("调用真实对象后");
        return result;
    }
}
