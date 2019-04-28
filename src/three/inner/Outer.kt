package three.inner

/**
 * author： YJZ
 * date:  2019/3/21
 * des: 内部类和嵌套类
 */


/* JAVA
public class Outer {
    public String str = "xx";
    class Inner{
        public Outer getOuter(){
            return Outer.this;
        }
        public void test(){
            System.out.println(str);
        }
    }
}
 */

/**
 * 嵌套类和内部类在Java和kotlin中的对应关系
 *
 *      类A在另一个类B中声明                在Java中           在Kotlin中
 *   嵌套类（不存储外部类的引用）         static class A         class A
 *   内部类（存储外部类的应用）              class A          inner class A
 */
class Outer {
    val str = "xxx"
    // 内部类使用inner关键字
    inner class Inner {

        // 获取外部类
        fun getOuter(): Outer = this@Outer

        // 获取外部类成员变量
        fun test() = print(str)
    }
}
