package three._interface

/**
 * author： YJZ
 * date:  2019/3/19
 * des:
 */
class Button : ClickAble, Focusable {

    override fun setFocus() {
        println("Focus")
    }

    override fun click() {
        println("click able")
    }


    /**
     * 当接口中有相同的方法时，需要指明调用具体的某个方法
     */
    override fun showOff() {
        // java ClickAble.super.showOff()
        // override fun showoff() = super<ClickAble>. showOff() 调用一个类的时候的写法
        super<Focusable>.showOff()
        super<ClickAble>.showOff()
        println("override showOff")
    }
}
