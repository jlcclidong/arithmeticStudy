
/**
 * kotlin 冒泡排序
 * 复杂度O(n^2)
 */


val a = Bean("li1", 12)
val b = Bean("li2", 155)
val c = Bean("li3", 13)
val d = Bean("li4", 17)
val e = Bean("li5", 19)
// var blist:MutableList<Bean> by Delegates.notNull()  //初始化时延时赋值方法必须赋值否则使用会报错 可以避免使用non-safe
val alist = mutableListOf<Bean>(a, b, c, d, e)   //List 初始化方法 这个是可以修改的 listOf()不能被修改
fun main(args: Array<String>) {
    for (x in 0 until alist.size - 1 step 1) {     //until 相当于 ..-1
        for (y in 0 until alist.size - 1 - x step 1) {
            if (alist[y].value < alist[y + 1].value) {
                val bean = alist[y]
                alist[y] = alist[y + 1]
                alist[y + 1] = bean
            }
        }
    }

    alist.forEach {
        println(it.name + "----" + it.value)
    }
}


data class Bean(val name: String, val value: Int){ //kotlin domain写法
//    在kotlin中存set时必须重写这两个方法 ==比较比较值 ===比较对象地址
//    override fun hashCode(): Int {
//        return super.hashCode()
//    }
//
//    override fun equals(other: Any?): Boolean {
//        return super.equals(other)
//    }
}

