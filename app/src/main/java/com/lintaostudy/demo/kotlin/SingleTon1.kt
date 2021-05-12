package com.lintaostudy.demo.kotlin

/**
 * @author :created by lintao
 * 版本：1.0
 * 创建日期：2021/5/11 20
 * 描述： kotlin 实现静态内部类单例模式
 * 推荐使用静态内部类单例模式:
 * 1. 既能保证线程安全
 * 2. 单例延迟实例化(在加载外部类的时候不会加载内部类,调用SingleProvider.holder才会加载)
 * 3. 保证对象的唯一性
 */
class SingleTon1 private constructor() {
    companion object {
        val instance = SingleProvider.holder
    }

    private object SingleProvider {
        val holder = SingleTon1
    }
}