package three.modifier.open_final

import three._interface.ClickAble

/**
 * author： YJZ
 * date:  2019/3/21
 * des: kotlin创建的类默认为final,不可被继承
 */

// 类上面如果不使用open关键字表示该类不能被继承,默认为不能继承
open class OpenClass :ClickAble{

    /**
     * 没有被open修饰的方法，不能被重写。
     */
    fun disable(){}

    /**
     * open修改的方法可以被重写
     */
    open fun animate(){}

    /**
     * 重写的是基类或者接口的话，重写的成员默认也是open的。
     * 如果想禁止重写，则只需要在方法前面加上final
     */
    // final表示为不可在子类重写。
    final override fun click() {
    }
}