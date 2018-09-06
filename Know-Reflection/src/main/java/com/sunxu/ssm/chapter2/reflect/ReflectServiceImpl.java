package com.sunxu.ssm.chapter2.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 孙许
 * @date 2018/09/06
 */
public class ReflectServiceImpl {
    public void sayHello(String name) {
        System.out.println("Hello" + name);
    }

    public ReflectServiceImpl getInstance() {
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("com.sunxu.ssm.chapter2.reflect.ReflectServiceImpl").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }

    public Object reflectMethod() {
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            method.invoke(target, "张三");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return returnObj;
    }

    public static void main(String[] args) {
        ReflectServiceImpl reflectService = new ReflectServiceImpl();
        reflectService = (ReflectServiceImpl) reflectService.reflectMethod();
        System.out.println(reflectService);
    }
}
