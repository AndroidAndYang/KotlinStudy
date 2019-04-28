package three.close

/**
 * author： YJZ
 * date:  2019/3/21
 * des:
 */
interface Expr {
    class Num(val value: Int) : Expr
    class Sum(val left: Int, val right: Int) : Expr
}

// 密封类
sealed class Exprs {

    class Num(val value: Int) : Exprs()
    class Sum(val left: Int, val right: Int) : Exprs()
}

fun eval(expr: Expr, exprs: Exprs) {
    // 使用when必须提供一个else分支来处理没有任何其它分配的情况
    when (expr) {
        is Expr.Num -> expr.value
        is Expr.Sum -> expr.left + expr.right
        else -> throw IllegalStateException("unKnow expression")
    }
    // 当类使用sealed修饰时，表示该类为密封类，在处理when时就不要使用else来判断没有任何其它分配的情况。
    when(exprs){
        is Exprs.Num -> exprs.value
        is Exprs.Sum -> exprs.left + exprs.right
    }
}