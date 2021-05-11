package com.lintaostudy.kotlin.demo.other

import com.lintaostudy.kotlin.demo.other.Method.Post

// 注解
annotation class ApiDoc(val s: String)

@ApiDoc("修饰类")
class Box {
    @ApiDoc("修饰字段")
    val size = 6

    @ApiDoc("修饰方法")
    fun size() {

    }
}

/**
 * kotlin 中的元注解类定义于kotlin.annotation包中,主要有:
 * @Target: 定义注解能够应用于哪些目标
 * @Retention: 注解的保留期 (编译阶段还是运行阶段)
 * @Repeatable: 标记的注解可以多次应用于相同的声明或类型
 * @MustBeDocumented: 修饰的注解将被文档工具提取到Api文档中
 * 4种元注解,相比java5种元注解少了@Inherited, 以上4种元注解最常用的是前两种
 * **/

enum class Method {
    Get,
    Post
}

@Target(AnnotationTarget.CLASS) // 作用于类
@Retention(AnnotationRetention.RUNTIME) // 运行时可见
annotation class HttpMethod(val method: Method)

interface Api {
    val name: String
    val version: String
        get() = "1.0"
}

@HttpMethod(Post)
class ApiGetReader(override val name: String) : Api

fun fire(api: Api) {
    // 通过反射 得到类的所有注解
    var annotations = api.javaClass.annotations
    var httpMethod = annotations.find { it is HttpMethod } as? HttpMethod
    println("通过注解获取请求方式:${httpMethod?.method}")
}
