package com.sunxu.ssm.chapter2.reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * @author 孙许
 * @date 2018/09/06
 */
public class ReflectServiceImpl2 {
    private String name;

    public ReflectServiceImpl2(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello" + name);
    }

    public ReflectServiceImpl2 getInstance() {
        ReflectServiceImpl2 object = null;
        try {
            object = (ReflectServiceImpl2) Class.forName("com.sunxu.ssm.chapter2.reflect.ReflectServiceImpl2")
                    .getConstructor(String.class).newInstance("张三");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }
}
