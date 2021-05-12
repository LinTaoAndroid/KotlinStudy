package com.lintaostudy.demo.kotlin

import kotlin.LazyThreadSafetyMode.SYNCHRONIZED

/**
 * @author :created by lintao
 * 版本：1.0
 * 创建日期：2021/5/11 20
 * 描述： 使用lazy 实现java单例双重校验锁的形式
 *
 */
class Singleton private constructor() {
    companion object {
        val INSTANCE: Singleton by lazy(mode = SYNCHRONIZED) {
            Singleton()
        }
    }
}