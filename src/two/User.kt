package two

/**
 * author： YJZ
 * date:  2019/3/19
 * des:
 */
class User(val id : Long,val name: String, val address: String){
    fun validateBeforeSave(){
        // 函数的嵌套
        fun validate(value: String, name: String): Boolean {
            if (value.isEmpty()) {
                throw NullPointerException("can`t save user $id : empty $name")
            }
            return true
        }

        val validateName = validate(name, "name")
        val validateAddress = validate(name, "address")
    }
}
