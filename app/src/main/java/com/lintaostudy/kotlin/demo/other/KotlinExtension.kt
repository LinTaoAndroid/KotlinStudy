package com.lintaostudy.kotlin.demo.other

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import com.lintaostudy.kotlin.demo.other.Jump.Companion

/**
 * kotlin扩展
 */
fun main() {
    var mutableList = mutableListOf(1, 2, 3)
    mutableList.swap(0, 1)
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    var temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

/**
 * 泛型扩展
 */
fun <T> MutableList<T>.swap2(index1: Int, index2: Int) {

}

/**-------------扩展属性----------------**/
//为String添加一个lastChar属性,用于获取字符串的最后一个字符
val String.lastChar: Char get() = this.get(this.length - 1)

/**-------------为伴生对象添加扩展----------------**/
class Jump {
    companion object {}
}

// 为伴生对象添加扩展方法
fun Companion.jump(l: Int) {

}

/**-------------kotlin中常用扩展----------------**/
//let扩展函数实际上是一个作用域函数,当你需要去定义变量在一个特定的作用域范围内,那么let函数是一个不错的选择,let函数另一个作用就是可以避免写一些判断null的操作
// 函数原型: fun<T,R> T.let(f:(T)->R):R=f(this)
// let常用用法
fun testLet(str: String?) {
    // 避免判空的操作
    str?.let {
        var length = str.length
    }
    // 限制作用域
    str.let {
        var str1 = "hello kotlin"
        println(it + str1)
    }
}

/**
 * run扩展: run函数只接收一个lanbda函数为参数,以闭包形式返回,返回值为最后一行的值或者指定的return的表达式,在run函数中可以直接访问实例的共有属性和方法
 * 函数原型: fun<T,R> T.run(f: T.()->R):R=f()
 * */
data class Room(val address: String, val price: Float, val size: Float)

fun testRun(room: Room) {
    // 可以直接调用 room.run 获取里面的属性
    room.run {
        println("Room:$address,$price,$size")
    }
}

/**
 *  apply扩展: apply函数的作用就是,调用某对象的apply函数,在函数范围内,可以任意调用该对象的任意方法,并返回该对象
 *            从结构上来看apply函数和run函数很像,唯一不同点就是他们各自返回的值不一样,run函数是以闭包形式返回最后一行代码的值,而apply函数返回的是传入对象的本身
 *            apply一般用于一个对象实例初始化的时候,需要对对象中的属性进行赋值,或者动态inflate出一个xml的view的时候需要给view绑定数据也会用到,这种情景非常常见
 */
fun testApply() {
    ArrayList<String>().apply {
        add("1");
        add("1");
        add("1");
    }.let {
        println(it)
    }
}

/**------------------------案例: 使用kotlin扩展为控件绑定监听器减少模板代码-------------------------------**/
//为Activity添加find扩展函数,用于通过资源id获取控件
fun <T : View> Activity.find(@IdRes id: Int): T {
    return findViewById(id)
}

// 为Int添加onClick扩展方法,用于为资源id对应的控件添加onClick监听
fun Int.onClick(activity: Activity, click: () -> Unit) {
    activity.find<View>(this).apply {
        setOnClickListener {
            click
        }
    }
}

