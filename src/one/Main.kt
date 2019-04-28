package one

import one._01_bean.ClassAndProperty
import one._02_enums.ColorEnum

/**
 * author： YJZ
 * date:  2019/2/28
 * des: 第二章、kotlin基础
 */
object Main {

    // public static final String = "TAG"
    const val str = "TAG"

    @JvmStatic fun main(args: Array<String>) {
        // 01与02知识点
        _01_And_02_()
        // 03知识点
        _03_listAbout()
        // 04Exception


    }

    /**
     * 集合学习
     */
    private fun _03_listAbout() {
        val list = listOf(1, 2, 3, 4, 5)
        // list集合遍历
        for (i in list.indices) {
            println("$i ${list[i]}")
        }

        for (i in 1..20) {
            when {
                i % 3 == 0 -> println("$i = fizz")
                i % 5 == 0 -> println("{$i = buzz}")
                i % 15 == 0 -> println(" $i = FizzBuzz")
            }
        }

        // down 为递减10 - 0 step 表示为步长，10 8 6 4...
        for (i in 10 downTo 1 step 2) {
            // println("$i")
        }

        // 4..10
        for (i in 4 until 10) {
            println("$i")
        }

        val map = hashMapOf<String, Int>()
        map.put("YJZ", 24)
        map["lnx"] = 24
        map["ymz"] = 28
        // map的遍历
        map.entries.forEach {
            println("key ${it.key} value ${it.value}")
        }
    }

    /**
     * 类与enum的学习
     */
    private fun _01_And_02_() {
        // 1.变量 :Int 可写可不写。
        // 可变变量
        var a: Int = 3
        a = 6

        // 不可变变量
        val b = 1
        // b = 3 报错

        // 申明一个为空的变量类型时需要指定它的类型。
        val str: String
        // 赋值
        str = "str"

        // 2.表达式函数体  :Int为该函数的返回类型，表达式函数体可以省略函数的返回类型，编译器会自动推导函数的返回类型。
        fun max(a: Int, b: Int): Int = if (a > b) a else b

        // 3. 字符串格式化
        // java  println("" + a)
        println("$a")
        println("${max(a, b)}")

        // 4.类和属性 创建对象不需要使用new关键字。
        /*
            java  ClassAndProperty property = new ClassAndProperty("xx");
            // 获取属性值
            String name = property.getName;
         */
        val property = ClassAndProperty("xx", 20)
        // 设置属性值
        property.name = "new xx"
        println(property.isBigBoy)
        // 获取属性值
        println(property.name)

        // 5.枚举
        println(testWhen(ColorEnum.RED))

        // 6.when的使用（代替switch）
        val score = 60
        when {
            score >= 90 -> println("优秀")
            score >= 80 -> println("优良")
            score >= 70 -> println("中等")
            score >= 60 -> println("及格")
            else -> {
                println("不及格")
            }
        }
    }
}

fun testWhen(colorEnum: ColorEnum): String {
    return when (colorEnum) {
        ColorEnum.ORANGE -> "ORANGE"
        ColorEnum.BLUE -> "BLUE"
        ColorEnum.RED -> "RED"
    }
}
