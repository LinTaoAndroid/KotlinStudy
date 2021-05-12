package com.lintaostudy.demo.kotlin.decorator

import com.lintaostudy.demo.java.decorator.Panda

/**
 * 版本：1.0
 * 创建日期：2021/5/12 20
 * 描述： kotlin 装饰器模式
 */
fun Panda.bamboo(decorator: () -> Unit) {
    eat()
    println("可以吃竹子")
    decorator()
}

fun Panda.carrot(decorator: () -> Unit) {
    println("可以吃胡罗卜")
    decorator()
}

fun main() {
    Panda().run {
        bamboo {
            carrot {}
        }
    }
}