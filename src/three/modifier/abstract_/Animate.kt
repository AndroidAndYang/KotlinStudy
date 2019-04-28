package three.modifier.abstract_

/**
 * author： YJZ
 * date:  2019/3/21
 * des: 抽象类默认为open
 */
abstract class Animate {

    abstract fun animate()
    /**
     * 抽象类中，只有使用open关键字的方法才能被重写
     */
    open fun stopAnimating() {}

    /**
     * 该方法没有open关键字，不能被子类所重写。和普通类一样
     */
    fun animateTwice() {}
}