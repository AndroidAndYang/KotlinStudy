package three.by

/**
 * author： YJZ
 * date:  2019/3/21
 * des: by 类委托
 */

interface Base {
    fun show()
}

class BaseImpl : Base {
    override fun show() {
        println("show")
    }
}

// by 类委托模式，BaseImpl操作的方法再该类中都有，而且我们可以在这里扩展我们的代理类。
class BaseProxy(base: Base) : Base by base {

    /**
     * 覆盖BaseImpl show()方法
     */
    override fun show() {
        println("proxy show")
    }

    fun say() {
        println("say")
    }
}

