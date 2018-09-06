package com.sunxu.ssm.chapter2.proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 孙许
 * @date 2018/09/06
 * @description
 */
public class JdkProxyTest {

    JdkProxy jdk;

    @Before
    public void setUp() throws Exception {
        jdk = new JdkProxy();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void invoke() {
        HelloWorld proxy = (HelloWorld) jdk.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
    }
}