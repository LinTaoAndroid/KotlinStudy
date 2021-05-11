package com.lintaostudy.kotlin.demo.java;

/**
 * @author :created by lintao
 * 版本：1.0
 * 创建日期：2021/5/11 20
 * 描述： 静态内部类单例模式
 */
public class SingleTon1 {

    private static class SingleTonProvider {

        private static SingleTon1 instance = new SingleTon1();
    }

    private SingleTon1() {
    }

    public static SingleTon1 getInstance() {
        return SingleTonProvider.instance;
    }
}
