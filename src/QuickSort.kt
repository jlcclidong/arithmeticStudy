import java.util.*

/**
 * 快速排序 复杂度O(n ㏒n)。
 * 最基本写法
 * 最复杂情况与冒泡排序相同
 * 如果参照位置定为最左面必须从右往左寻找否则反之，如果不这样会导致排序分组出现错误
 */




fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val first = sc.next()
    val split = first.split(",")
    val mIntArray: MutableList<String> = split as MutableList<String>
    quickSort(mIntArray, 0, mIntArray.size - 1)
    mIntArray.forEach { println(it) }
}

fun quickSort(array: MutableList<String>, start: Int, end: Int) {
    if (start >= end)
        return
    val num = array[start].toInt()
    var left = start
    var right = end
    while (left != right) {
        while (array[right].toInt()  >= num  && left < right)
            right--
        while (array[left].toInt()  <= num && left < right)
            left++
        if (left < right) {
            val change = array[left]
            array[left] = array[right]
            array[right] = change
        }
    }
    array[start] = array[left]
    array[left] = ""+num
    quickSort(array, start, left - 1)
    quickSort(array, left + 1, end)
}


