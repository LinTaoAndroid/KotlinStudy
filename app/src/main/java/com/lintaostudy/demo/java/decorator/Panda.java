package com.lintaostudy.demo.java.decorator;

/**
 * @author :created by lintao
 * 版本：1.0
 * 创建日期：2021/5/12 19
 * 描述：被装饰者
 */
public class Panda implements Animal {

    @Override
    public void eat() {
        System.out.println("不知道要吃啥");
    }
}
