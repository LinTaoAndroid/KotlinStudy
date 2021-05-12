package com.lintaostudy.demo.java;

/**
 * @author :created by lintao
 * 版本：1.0
 * 创建日期：2021/5/11 20
 * 描述：
 */
public class SingleTon {

    private static volatile SingleTon singleTon;
    
    public static SingleTon getSingleTon() {
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                if (singleTon == null) singleTon = new SingleTon();
                return singleTon;
            }
        }
        return singleTon;
    }
}
