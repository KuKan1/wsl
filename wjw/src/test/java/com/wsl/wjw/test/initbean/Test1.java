package com.wsl.wjw.test.initbean;
public class Test1 {
    public void init() {
        System.out.println("this is init method1");
    }
    public void init(String param) {
        System.out.println("this is init method2===="+ param);
    }
    public Test1() {
        super();
        System.out.println("构造函数1");
    }
    public void destroy() {
        System.out.println("this is destroy method1");
    }
}