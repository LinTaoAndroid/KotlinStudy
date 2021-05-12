package com.lintaostudy.demo.other

fun main() {

}

/**
 * 泛型方法
 */
interface Think<T> {
    fun study(): T
    fun read(t: T)
}

class Meditation {
    val medi = 5
}

/**
 * 实现泛型方法
 */
class Stars : Think<Meditation> {
    override fun study(): Meditation {
        TODO("Not yet implemented")
    }

    override fun read(t: Meditation) {
        TODO("Not yet implemented")
    }
}

/** ---------------泛型类-------------**/
// Color 是有构造方法的  (val t: T)
abstract class Color<T>(val t: T) {
    abstract fun printColor()
}

class Blue {
    val color = "Blue"
}

class BlueColor(b: Blue) : Color<Blue>(b) {
    override fun printColor() {
        TODO("Not yet implemented")
    }
}

/** ---------------泛型方法-------------**/
// 解析json 泛型方法
fun <T> fromJson(json: String, x: Class<T>): T? {
    return x.newInstance()
}

/** ---------------泛型约束-------------**/
// 使用冒号 :  定义泛型上界
fun <T : Comparable<T>?> sort(list: List<T>?): Unit {}
fun sort() {
    sort(listOf(1, 2, 3))
}

// 多个上界的情况  使用where 规定多个上界
fun <T> test(list: List<T>, id: T): List<T>
        where T : CharSequence,
              T : Comparable<T> {
    // list里的值大于id的话返回
    return list.filter { it > id }
}

/** -- 在kotlin中out代表协变,in代表逆变,为了加深理解,可以将kotlin的协变(out)看成java的上界通配符,将逆变(in)看成java的下边界通配符 --* */
fun sumofList(list: List<out Number>) {}
//fun addNumbers(list:List <in Int>){}