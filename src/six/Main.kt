package six

/**
 * author： YJZ
 * date:  2019/4/2
 * des:  第七章、运算符重载及其他约定
 */
object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        // 7.1
        val p1 = Point(10, 20)
        val p2 = Point(30, 40)
        // 通过使用+来调用plus
        println(p1 + p2)
        println(p1.plus(p2))

        /*
         *  可重载的二元算数运算符
         *      1）* 使用 times
         *      2）/ 使用 div
         *      3）% 使用 mod
         *      4) + 使用 plus
         *      5）- 使用 minus
         */
        val a = 1
        val b = 2
        println(a.times(b)) // 等同于 a + b
        println(a.div(b)) // 等同于 a / b
        println(a.mod(b)) // 等同于 a % b
        println(a.plus(b)) // 等同于 a + b
        println(a.minus(b)) // 等同于 a - b

        // 7.3
        // get
        println(p1[0])
        // set
        p1[1] = 42
        println(p1)

        val (x, y) = p1
        print(x)

        // 7.4 解构声明和循环
        val map = mapOf("Boy" to "YJZ", "girl" to "wy")
        priEntries(map)

        // 7.5 重用属性访问：委托属性

    }

    private fun priEntries(map: Map<String, String>) {

        // 委托属性
        for ((key, value) in map) println("key = $key value = $value")

        // 传统遍历
        map.map {
            println("key = ${it.key} value = ${it.value}")
        }
    }

}