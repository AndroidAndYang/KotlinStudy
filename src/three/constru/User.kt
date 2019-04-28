package three.constru

/**
 * author： YJZ
 * date:  2019/3/21
 * des:
 */
// constructor表明为构造方法，可省略不写
// class constructor User(name: String) {
// 使用 private 修饰表示该类不能被其它代码实例化
// class User private constructor(var name: String,val isSubscribed : Boolean = true) {

// isSubscribed 默认参数，创建User类时，如果不申明则为该默认值。申明已实际申明为准
class User(var name: String, val isSubscribed: Boolean = true) {

    var nickName: String = name
        private set // 表示该字段不能再外部被修改

    // 该构造方法为从构造方法，class后面的构造方法为主构造方法
    // constructor(age:Int){
    //
    // }

    // init 初始化方法
    init {
        // 初始化以及赋值操作
        println(nickName)
    }


    var address: String = "unSpecified"
        set(value) {
            println("""
                address was changed for $name：
                "$field" -> "$value".""".trimIndent())
            field = value
        }
}