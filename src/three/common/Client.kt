package three.common

/**
 * author： YJZ
 * date:  2019/3/21
 * des:
 */
// data class 默认重写 toString() hashCode() equals()方法 等同于下面
data class Client(private val name: String, private val postalCode: Int)

//class Client(private val name: String, private val postalCode: Int) {
//
//    // 字符串表示
//    override fun toString(): String = "Client(name = $name,postalCode = $postalCode)"
//
//    // 对象相等性
//    override fun equals(other: Any?): Boolean {
//        // is == instanceOf
//        if (other == null || other !is Client) {
//            return false
//        }
//        return name == other.name && postalCode == other.postalCode
//    }
//    // hashCode 和 equals 需要一并重写
//    override fun hashCode(): Int {
//        var result = name.hashCode()
//        result = 31 * result + postalCode
//        return result
//    }
//}
