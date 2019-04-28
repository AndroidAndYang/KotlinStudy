package three.`object`

/**
 * author： YJZ
 * date:  2019/3/21
 * des:
 */
// object 修饰的对象为单例类，直接通过类名.获取
// object 修饰的类不能有构造方法
// 对象声明在定义的时候就立即创建了
object Payroll {

    val allEmployess = arrayListOf<Person>()

    fun calculateSalary(): Float {
        var salary = 0f
        for (item in allEmployess) {
            salary += item.money
        }
        return salary
    }

}

class Person(val name: String, val money: Float){
    // 伴生对象，通过 Person.say()调用，类似java static
    companion object {
        fun say(){
            println("hello")
        }
    }
}