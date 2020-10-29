package com.lintaostudy.kotlin.demo

import java.util.*

/**
 * 主构造方法
 */
class KotlinClass constructor(name: String) {
    // 次构造方法必须调用主构造方法,保证主构造方法初始化
    // 次构造方法可以声明多个
    constructor(age: Int, sex: Int, beut: String) : this(beut) {

    }
}

open class Animal(age: Int) {
    var ha = ""

    init {
        ha = "haha"
    }
}

// 可以直接这样声明次构造方法,不需声明主构造方法
class Cat : Animal {
    constructor(age: Int) : super(age)
}

// kotlin 对属性的声明
class Shop {
    val name: String = "seven_eleven"
    val address: String? = null
    val isClosed: Boolean
        get() = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > 8
    var score: Float = 0.1f
        get() = if (field < 0.2f) 0.2f else field * 1.5f
        set(v) {
            println("哇哈哈")
        }
}

// 对属性做延时初始化  lateinit
class Test {
    // 延时初始化
    lateinit var shop: Shop
    fun init() {
        shop = Shop()
    }
    //
    fun late(){
        // 使用:: 调用成员变量
        if(::shop.isInitialized) println("初始化啦")
    }
}