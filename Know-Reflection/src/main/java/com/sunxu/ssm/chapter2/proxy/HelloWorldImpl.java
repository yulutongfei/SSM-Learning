package com.sunxu.ssm.chapter2.proxy;

/**
 * @author 孙许
 * @date 2018/09/06
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World");
    }
}
