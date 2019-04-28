package three

import three._interface.Button
import three.`object`.Payroll
import three.by.BaseImpl
import three.by.BaseProxy
import three.common.Client
import three.constru.User

/**
 * author： YJZ
 * date:  2019/3/19
 * des: 第四章、对象和接口
 */
object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        // interface
        val button = Button()
        button.click()
        button.setFocus()
        button.showOff()


        /**
         * 修饰符 packet abstract_ and _interface
         *                   相关成员                               评注
         * 1.final          不能被重写               类中的默认成员被使用，想要重写需要使用open修饰
         * 2.open           可以被重写               使用该关键字修饰的成员可以被重写
         * 3.abstract       必须要重写               只能在抽象类中使用
         * 4.override       重写父类中的接口成员      重写的方法如果没有final修饰，就可以被重写，否则不能被重写。
         */

        /**
         * 可见性修饰符：默认为public。
         * Java中的默认可见性一一包私有，在kotlin中井没有使用。Kotlin只把包作为在命
         *       名空间里组织代码的一种方式使用 ，并没有将其用作可见性控制
         *                           类成员                顶层声明
         * 1.public               所有地方可见            所有地方可见
         * 2.internal              模块中可见              模块中可见
         * 3.protected             子类中可见                  -
         * 4.private                类中可见               文件中可见
         */

        // 嵌套类和内部类
        val btn = three.inner.Outer()

        // 密封类

        // 构造方法
        val user = User("YJZ")
        user.address = "Elsenheimerstrasse 47,80687"

        user.name = "WY"
        user.address = "XXXX 47,80687"

        // 通用对象方法 java toString hashCode equals
        val client1 = Client("YJZ", 1762859608)
        val client2 = Client("YJZ", 1762859608)
        println(client1)
        // == 比较检查的对象是否相等，而非是对象的引用
        // client类没有重写equals则返回false
        println(client1 == client2)

        val set = hashSetOf(Client("YJZ", 1762859608))
        // 如果client类没有重写hashCode方法则返回false.对象相等，hash值必须相同
        // HashSet首先比较的是它们的hash值，然后再比较真正的值
        println("is contains ${set.contains(Client("YJZ", 1762859608))}")

        // by
        val baseImpl = BaseImpl()
        BaseProxy(baseImpl).show()
        BaseProxy(baseImpl).say()

        // object
        Payroll.calculateSalary()
    }
}