package four

import four.lambda.Book
import four.lambda.Person

/**
 * author： YJZ
 * date:  2019/3/22
 * des: 第五章、lambda編程
 */

fun salute() = println("salute")

object Main {
    @JvmStatic
    fun main(args: Array<String>) {

        /**
         * 5.1 lambda表达式和成员引用
         */
        // 找出年齡最大的一個
        val personList = arrayListOf(Person("YJZ", 23), Person("WY", 10),
                Person("YMZ", 29), Person("LNX", 23))
        var maxAge = 0
        for (person in personList) {
            if (person.age > maxAge)
                maxAge = person.age
        }
        println(maxAge)

        // kotlin lambda
        println(personList.maxBy { it.age })
        // 访问了类的成员
        println(personList.maxBy(Person::age))
        println(personList.maxBy({ p: Person -> p.age }))

        val getAge = { person: Person -> person.age }

        val sum = { x: Int, y: Int -> x + y }

        println(personList.joinToString(",", transform = { p: Person -> p.name }))

        val messages = listOf("404 not fount", "403 forbidden", "500 Internal Server Error")
        printMessageWithPrefix(messages, "Error")

        printProblemCounts(messages)
        // 引用顶层函数
        kotlin.run(::salute)
        val action = { person: Person, message: String -> sendEmail(person, message) }
        // 直接使用::引用lambda表达式里面的函数
        val nextAction = ::sendEmail

        /**
         * 5.2 集合的函数式API
         */
        // ---------------------- filter ----------------------
        // filter：filter函数可以从集合中移除你不想要的元素，但是它并不会改变这些元素
        val lists = listOf(1, 2, 3, 4)
        // 筛选出符合条件里面的集合的数据
        val newList = lists.filter { it % 2 == 0 }
        newList.forEach {
            println(it)
        }
        // 筛选出年里大于20的人
        val personNewList = personList.filter { person: Person -> person.age > 20 }
        println(personNewList.joinToString(","))
        // ---------------------- filter ----------------------

        // ---------------------- map ----------------------
        // map：map函数对集合中的每个元素应用给定的函数并把结果收集到一个新集合。
        val numLists = listOf(1, 2, 3, 4)
        val newNumList = numLists.map { it * it }
        println(newNumList.joinToString(", "))

        // 查找年龄大于10的，并输出他的姓名
        println(personList.filter { it.age > 10 }.map { it.name })
        // 找出年龄最大的
        // personList.filter { it.age == personList.maxBy(Person::age)!!.age } 这样写，list的集合有多大就会执行多少遍
        // 这样只计算了一次
        val listMaxAge = personList.maxBy(Person::age)!!.age
        println(personList.filter { it.age == listMaxAge }.joinToString(","))
        // 对map进行filter过滤
        val map = mapOf(0 to "zero", 1 to "one")
        // 单独的对key filter
        map.filterKeys { it == 0 }
        // 单独的对value filter
        map.filterValues { it == "zero" }
        map.mapKeys { }
        map.mapValues { }
        // 对key和value filter
        println(map.filter { it.key == 0 }.values.joinToString(","))
        // ---------------------- map ----------------------

        /**
         * all、any、count、find：对集合应用判断式
         */
        // 判断单个
        val isBigBoy = { p: Person -> p.age >= 18 }
        println("isBigBoy = $isBigBoy")
        // 判断所有一个不成立返回false，使用all
        println(personList.all(isBigBoy)) // false
        // 判断所有如果有一个成立返回true,使用any
        println(personList.any(isBigBoy)) // true
        // 如果想知道有多少个元素满足，则使用count
        println(personList.count(isBigBoy)) // 1
        // find 如果有多个元素满足，则只会返回第一个元素或者返回null
        println(personList.find(isBigBoy))
        // firstOrNull更好的表达意思，查找第一个，没有则返回null
        println("firsOrNull = ${personList.firstOrNull(isBigBoy)}")

        /**
         * groupBy：把列表转换成分组的 map
         */
        // 按年龄分组，如果年龄相等，则会分入一个组里面。
        val personMap = personList.groupBy { it.age }
        personMap.forEach { t, u ->
            /*
                Person(name=YJZ, age=23),Person(name=LNX, age=23)
                Person(name=WY, age=10)
                Person(name=YMZ, age=29)
             */
            println(u.joinToString(","))
        }

        val strList = listOf("a", "ab", "b")
        // 按第一個字符分组
        strList.groupBy(String::first) // {a=[a, ab], b=[b]}

        /**
         * flatMap和flatten ：处理嵌套集合中的元素
         */

        // flatMap: 首先根据作为实参给定的函数对集合中的每个元素做变换（或者说映射）,然后把多个列表合并（或者说平铺)成一个列表
        // 查询书的作者
        val bookList = listOf(Book("book1", listOf("YJZ1", "YJZ2")),
                Book("book2", listOf("YJZ3", "YJZ4")))

        // toSet() 移除结果集中重复的元素
        for (s in bookList.flatMap { it.authors }.toSet()) {
            println(s)
        }

        val strings = listOf("abc", "def ")
        /*
            "abc"           "def"
              ↓      映射     ↓
           a  b  c         d  e  f
              ↓      平铺     ↓
           a    b   c    d   e   f
         */
        strings.flatMap { it.toList() } // [a, b, c, d, e, f]
        //  flatten: 把多个列表合并（或者说平铺)成一个列表
        val list = listOf(listOf(1, 2), listOf(4, 2), listOf(3), listOf(4))
        println(list.flatten()) //(1,2,4,2,3,4)

        /**
         * 集合懒惰性：序列
         */
        /*
          filter map 都会返回一个列表，这意味着上面例子中的链式调用会创建两个列表一个保存filter函数的结果，另一个保存
          map 函数的结果。如果源列表只有两个元素，这不是什么问题，但是如果有一百万个元素，（链式）调用就会变得十分低效。
         */
        personList.map { person: Person -> person.name }.filter { it.startsWith("J") }
        // 提高效率 是用序列,没有创建任何用于存储元素的中间集合。
        // Kotlin 惰性集合操作的入口就是Sequence接口,这个接口表示的就是个可以逐个列举元素的元素序列。
        // personList.asSequence().map(Person::name).filter { it.startsWith("J") }.toList()

        // 序列的中间和末端操作
        val sequence = listOf(1, 2, 3, 4).asSequence().map { print("map($it)"); it * it }.filter { print("filter($it)"); it % 2 == 0 }
        // 上述代码执行不会打印任何内容，因为序列的中间操作是惰性的。
        sequence.toList() // 末端操作触发执行了所有的延期计算。

        // 创建序列  generateSequence()
        val generateSequence = generateSequence(0) { it + 1 }
        val takeWhile = generateSequence.takeWhile { it <= 100 }
        // 上面延迟创建的则会在调用sum()方法的时候执行。
        println(takeWhile.sum())

        /**
         * 带接受者的lambda，whit 和 apply
         */

        // with：在对同一个对象执行多次操作，而不需要反复把对象的名称写出来。
        println(withAndApplyStudy())
    }

    private fun withAndApplyStudy(): String {
        val stringBuffer = StringBuffer()
        for (str in 'A'..'Z') {
            stringBuffer.append(str)
        }
        stringBuffer.append("Now I know the alphabet! ")

        // 使用with
        val withStr = StringBuffer()
        val with = with(withStr) {
            // 在with里面可以省略对象的书写
            for (str in 'A'..'Z') {
                append(str)
            }
            append("Now I know the alphabet! ")
        }

        val applyStr = StringBuffer()
        val apply = applyStr.apply {
            for (str in 'A'..'Z') {
                append(str)
            }
            append("Now I know the alphabet! ")
        }


        return stringBuffer.toString() + "\n" + with.toString() + "\n" + apply.toString()
    }

    private fun sendEmail(person: Person, message: String): Unit {

    }

    private fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
        // forEach 关键字的使用，比普通 for 循环更简洁一些，但它并没有更多其他优势。
        messages.forEach {
            println("$prefix $it")
        }
    }

    // 在lambda中修改局部变量
    private fun printProblemCounts(response: Collection<String>) {
        var clientErrors = 0
        var serverErrors = 0
        response.forEach {
            if (it.startsWith("4")) {
                clientErrors++
            } else if (it.startsWith("5")) {
                serverErrors++
            }
        }
        println("clientErrors = $clientErrors , serverErrors = $serverErrors ")
    }
}
