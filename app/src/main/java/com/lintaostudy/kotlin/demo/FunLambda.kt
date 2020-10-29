package com.lintaostudy.kotlin.demo

import android.os.Build
import androidx.annotation.RequiresApi

class FunLambda {
    /**
     * val 修饰常量
     * var 修饰可变变量
     */
    fun main() {
        // 运行lambda
    }

    fun learningDay(days: Int): Int {
        return days * 2
    }

    class Person {
        //成员方法
        fun test1() {

        }

        // 类方法,类似于java静态方法,伴生对象
        companion object {
            fun test2() {

            }
        }
    }

    // 静态类
    object NumUtils {
        fun num(num: Int): Int {
            return num * 2
        }
    }

    // 单表达式方法: 当方法返回单个表达式时,可以省略花括号并且在=符号之后指定代码体即可
    fun double(x: Int): Int = x * 2;

    /**
     * 方法重载
     */
    fun read(b: Array<Byte>, off: Int = 0, len: Int = 0) {

    }

    /**
     * 可变参数 vararg
     */
    fun append(vararg str: String): String {
        val sb = StringBuffer()
        for (char in str) {
            sb.append(char)
        }
        return sb.toString()
    }

    /**
     * 方法的作用域
     */
    fun magic(): Int {
        fun foo(v: Int): Int {
            return v * v
        }

        val v1 = (1..100).random()
        return foo(v1)
    }

// lanmbda 表达式特点:  1.匿名方法 2.可传递(作为参数)
// lambda 表达式语法:
// 1. 无参  val/var 变量名={操作代码}
// 2.有参 val/var 变量名: (参数的类型: 参数类型,...)->返回值类型 = {参数1,参数2 ...->操作参数的代码 }   等价于: val/var 变量名 = {参数1:类型,参数2:类型,...->操作参数的代码}(即:表达式的返回值类型会根据操作的代码自推导出来,可以用后面这种lambda表达式类型)

    fun test() {// 无参数代码
        println("无参数")
    }

    //改为lanmbda
    val test1 = { println("普通无参数表达式改为lambda表达式") }

    // 普通有参数表达式
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    // 普通有参数表达式改为lambda表达式 两种不同的写法
    val test3: (Int, Int) -> Int = { a, b -> a + b }
    val test4 = { a: Int, b: Int -> a + b }

    @RequiresApi(Build.VERSION_CODES.N)
    fun test5() {
        val arr = arrayOf(1, 2, 3, 4, 5)
        arr.filter { it < 5 }.component5()// 输出第5个元素
        val map = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        map.forEach{ _, velue -> println(velue) }
    }

    /**
     * 扩展list集合函数
     * 对集合元素求和,并返回每一项结果
     */
    fun List<Int>.sum(callback: (Int) -> Unit): Int {
        var result = 0;
        for (v in this) {
            result += v
            callback(v)
        }
        return result;
    }

    // 需求: 实现一个能够对集合元素进行求和的高阶函数,并且返回一个声明为(scale:Int)->Float的函数 函数作为返回值
    fun List<String>.toIntSum(): (scale: Int) -> Float {
        println("第一层函数")
        // return 接收一个(scale  float 参数)
        return fun(scale): Float {
            var result = 0f
            for (v in this) {
                result += v.toFloat() * scale
            }
            return result
        }
    }

    /**
     * kotlin闭包(Closure): 闭包可以理解为能够读取其他方法内部变量的方法,闭包是将方法内部和方法外部连接起来的桥梁
     * 闭包特性: 1.方法可以作为另一个方法的返回值或参数   2.还可以作为一个变量的值     方法可以嵌套定义,即在一个方法内部可以定义另一个方法
     * 闭包的好处: 1. 有益于模块化编程,能够以简单的方式开发较小的模块,从而提高程序的可复用性  2.抽象   闭包在抽象上是数据和行为的整合    3.灵活  4.简化代码
     */
/*
 需求: 实现一个接收一个testClosure方法,该方法要接收一个Int类型的v1参数,同时能够返回一个声明为(v2:Int,(Int)->Unit)的函数,并且这个函数能够计算v1和v2的和
 */
    fun testClosure(v1: Int): (v2: Int, (Int) -> Unit) -> Unit {
        return fun(v2: Int, printer: (Int) -> Unit) {
            printer(v1 + v2)
        }
    }

    //data 函数
    data class Person2(val name: String, val age: Int)

    fun testPerson() {
        var p = Person2("张三", 18)
        val (name, age) = p;
    }

    // 匿名方法
    val z = fun(x: Int, y: Int): Int = x + y

    // 匿名方法
    val a = fun(x: Int, y: Int): Int {
        return x + y
    }

    // 定义一个变量temp,而该变量的类型就是就是(Int)->Boolean
// 把表达式赋值给temp
    fun lete() {
        var temp: ((Int) -> Boolean)? = null
        temp = { n -> (n > 10) }// 方法字面值
    }

}