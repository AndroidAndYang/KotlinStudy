package two

// 导入时重新命名
import one.Main as oneMain
// 可以导入某个变量 或者方法
import one.Main.str as str

/**
 * author： YJZ
 * date:  2019/3/19
 * des: 第三章、函数的定义与调用
 */


object Main {


    @JvmStatic
    fun main(args: Array<String>) {
        createList()
        val list = listOf(1, 2, 3)
        println(list.myJoinToString(";", "[", "]"))
        multiStr("xxx", "2xx", "3xx")
        val str = "12 345-6.A"

        println(str.split("\\.|-".toRegex()))
        println(str.split("."))

        val path = "/Users/yole/kotlin-book/chapter.adoc"
        val directory = path.substringBeforeLast("/")
        val fullName = path.substringAfterLast("/")
        val fileName = fullName.substringBefore(".")
        val extension = path.substringAfter(".")
        println("$directory $fileName $extension")

        val saveUser = saveUser(User(1, "YJZ", "XX"))
        if (saveUser) {
            print("save success")
        } else {
            print("save fail")
        }

    }

    private fun saveUser(user: User): Boolean {
        // 将验证逻辑放到bean中
        user.validateBeforeSave()

        // 函数的嵌套
        fun validate(value: String, name: String): Boolean {
            if (value.isEmpty()) {
                throw NullPointerException("can`t save user ${user.id} : empty $name")
            }
            return true
        }

        val validateName = validate(user.name, "name")
        val validateAddress = validate(user.name, "address")

        return validateName && validateAddress
    }


    /**
     * 集合类的创建与遍历
     */
    private fun createList() {
        /**
         * 1.Kotlin没有自己的集合类，采用的java的标准集合类。
         * 2.为什么Kotlin没有自己专门的集合类呢？那是因为使用
         *   标准的Java集合Kotlin可以更容易与Java代码交互。
         */
        val set = hashSetOf(5, 4, 2)
        // 获取最后一个元素
        println(set.last())
        // 获取最大的元素
        println(set.max())

        val list = arrayListOf(1, 3, 7)
        list.last()
        list.max()

        // 拼接成 (1;3;7)
        println(list.joinToString(";", "(", ")"))

        val map = mapOf(1 to "one", 2 to "two")

        // 遍历set
        set.forEach {
            println(it)
        }

        for (i in list.indices) {
            println(list[i])
        }

        map.entries.forEach {
            println("key = ${it.key} value = ${it.value}")
        }
        println(set.javaClass) // HashSet
        println(list.javaClass) // ArrayList
        println(map.javaClass) // LinkedHashMap
    }

    /**
     * separator 间隔符
     * prefix 最前面的符号
     * postfix 最后面的符号
     */
    fun <T> Collection<T>.myJoinToString(separator: String = ",", prefix: String = "", postfix: String = ""): String {

        val result = StringBuffer(prefix)
        for ((index, element) in this.withIndex()) {
            if (index > -1) {
                result.append(element)
                if (index != this.size - 1)
                    result.append(separator)
            }
        }
        result.append(postfix)

        return result.toString()
    }

    /**
     * vararg 可变参数
     */
    private fun multiStr(vararg element: String) {
        print(element.asList().joinToString())
    }
}

