package com.lintaostudy.demo.other

/**
 * 抽象类
 */
fun main() {
    Teacher.gotoClass();
}

/**
 * 抽象类
 */
abstract class Person {
    abstract fun eat()
}

class XiaoMing : Person() {
    override fun eat() {
        println("我是小明")
    }
}

// 接口定义
interface Study {
    // 接口可以有变量
    var time: Int
    fun shuxue()

    // 接口可以有具体的实现方法
    fun englis() {
        println("学习英语")
    }
}

// 可以实现接口的变量和方法
class XiaoGang(override var time: Int) : Study {
    override fun shuxue() {

    }
}

//--------同时实现两个接口里的相同方法名的方法----------------------
interface StudentA {
    fun study()
}

interface StudentB {
    fun study()
}

class XiaoHong : StudentA, StudentB {
    // 覆盖父类方法
    override fun study() {
        super<StudentA>.toString()
    }
}

// 通过对象表达式改变类
open class Address(address: String) {
    open fun enteraddress() {}
}

class ShopT() {
    var address: Address? = null
    fun addAddress(ress: Address) {
        this.address = ress
    }
}

// 可以通过object:类名(覆写类方法来改变原来的类)  不创建其子类对其修改
fun addAddress() {
    ShopT().addAddress(object : Address("北京") {
        override fun enteraddress() {
            super.enteraddress()
        }
    })
}

// 通过object对象声明一个对象 (匿名对象)
fun demo() {
    val dm = object {
        var d: Int = 1
        var m: Int = 2
    }
    println(dm.d + dm.m)
}

// 静态类DateUtils 里的静态方法isEmpty
object DateUtils {
    fun <T> isEmpty(list: ArrayList<T>): Boolean {
        return list?.isEmpty() ?: false
    }
}

/**
 * 伴生对象: 类似与java的静态方法
 */
class Teacher(name: String, age: Int) {
    companion object {
        // Teacher类的伴生对象
        val teache = Teacher("王老师", 18)
        fun gotoClass() {
            println("我要上课了")
        }
    }
}