package com.sunxu.ssm.chapter2.proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 孙许
 * @date 2018/09/07
 * @description
 */
public class CglibProxyTest {

    CglibProxy cglib;

    @Before
    public void setUp() throws Exception {
        cglib = new CglibProxy();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void intercept() {
        ReflectServiceImpl proxy = (ReflectServiceImpl) cglib.getProxy(ReflectServiceImpl.class);
        proxy.sayHello("孙许");
    }
}