package six

/**
 * author： YJZ
 * date:  2019/4/2
 * des:
 */
data class Point(var x: Int, var y: Int) {

    /**
     *  通过索引来返回x,y坐标 point[0]
     */
    operator fun get(index: Int): Int = when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }

    operator fun set(index: Int, value: Int) {
        when (index) {
            0 -> x = value
            1 -> y = value
            else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
        }
    }

    //  operator 运算操作符
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}
