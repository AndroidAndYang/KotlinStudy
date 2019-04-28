package three.modifier.open_final

/**
 * author： YJZ
 * date:  2019/3/21
 * des:
 */
class RichButton() : OpenClass() {
    /**
     * 父类中open的方法可以被重写
     */
    override fun animate() {
        super.animate()
        print("animate")
    }
}