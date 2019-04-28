package three._interface

/**
 * author： YJZ
 * date:  2019/3/19
 * des:
 */
// 接口的声明
interface ClickAble{
    fun click()
    /**
     * 带默认方法体的接口方法
     */
    fun showOff() = print("I`m click able")
}