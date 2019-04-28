package one._01_bean

/**
 * author： YJZ
 * date:  2019/2/28
 * des: 类和属性
 */

/*
Java
public class ClassAndProperty {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
*/

// 可变属性为var 有getter / setter 方法 不可变属性则为 val 只有getter方法
class ClassAndProperty(var name:String,var age:Int){
    // 内部属性的getter
    var isBigBoy:Boolean = false
    // 不需要花括号的写法 get() = if (age > 18) true else false
        get() {
            return age > 18
        }
}

