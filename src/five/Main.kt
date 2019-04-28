package five

/**
 * author： YJZ
 * date:  2019/3/22
 * des: 第六章、kotlin的类型系统
 */
object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        // 1.可空性
        // emptyEnable()
        // 3.集合和与数组

        // 3.1.可空集合
        lisAndArray()


    }

    private fun lisAndArray() {
        // 1.对可空集合进行读取,listOf()里面使用的是包装类型。变量使用基本类型
        fun addValidNumbers(numbers: List<Int?>) {
            var sumOfValidNumbers = 0
            var invalidNumbers = 0
            numbers.forEach {
                if (it == null) {
                    invalidNumbers++
                } else {
                    sumOfValidNumbers += it
                }
            }
            println("Sum of valid numbers: $sumOfValidNumbers")
            println("Invalid numbers: $invalidNumbers")
        }

        addValidNumbers(listOf(1, null, 2, 3))

        // 2.可读集合Collection和可变集合MutableCollection
        fun <T> copyElement(source: Collection<T>, target: MutableCollection<T>) {
            source.forEach {
                target.add(it)
            }
        }

        val sources: Collection<Int> = arrayListOf(1, 2, 3)
        val target: MutableCollection<Int> = arrayListOf()
        println("copy before size = ${target.size}")
        copyElement(sources, target)
        println("copy after size = ${target.size}")
    }

    private fun emptyEnable() {

        // 变量类型后面接上？表示为而空类型，不写默认为不为空。
        fun strLen(string: String?) = string!!.length

        fun isBoolean(type: Any): Boolean {
            return (type as? Boolean)!!
        }

        // Kotlin中所有泛型类和泛型函数的类型参数默认都是可空的，如下T继承Any则不为空
        fun <T : Any> printHashCode(t: T) {
            println(t.hashCode())
        }

        // 1. 可空类型
        //  只有String类型加上？号才可以传递null
        strLen("xx")

        // 2.安全调用运算符
        val string: String? = null
        // ?. 它允许你把一次null检查和一次方法调用合并成一个操作。
        // 如果调用一个非空值的方法，这次方法会正常执行。如果为null，这次调用不会发生，而整个表达式的值为null。
        println(string?.toUpperCase())

        println(Company("海大", Address(null).addressName))

        // 4.安全转换 as? 运算符尝试把值转换成指定的类型， 如果值不是合适的类型就返回 null,
        val boolean = true
        println(isBoolean(boolean))

        // 5.非空断言 ！！
        // 可以把任何值转换成非空类型，如果对null值做非空转换，则会抛出异常。
        val str: String? = ""
        println(str!!)

        // 类似于 if (!TextUtils.isEmpty(str)) print(sirs.length)
        str.let { sirs -> print(sirs.length) }

        printHashCode(1)
    }

}

data class Address(val name: String?) {
    val addressName: String?
        get() {
            // Elvis运算符 ?: 如果为空则返回 unKnow,不为空返回实际值
            return name ?: "unKnow"
        }
}

data class Company(val name: String, val address: String?)