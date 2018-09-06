package com.sunxu.ssm.chapter2.proxy;

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
}
