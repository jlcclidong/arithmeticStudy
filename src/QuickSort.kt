val mIntArray: Array<Int> = arrayOf(1, 9, 0, 2, 3, 5, 3, 4, 7, 9, 7, 6, 45, 4, 3, 2, 1)


fun main(args: Array<String>) {
    quickSort(mIntArray,0,mIntArray.size-1)
    mIntArray.forEach { println(it) }
}

fun quickSort(a: Array<Int>,start:Int,end:Int) {
    val k = a[0]
    var left = start
    var right = end
    if (left > right)
        return
    while (left != right) {
        while (a[right] >= k && left < right)
            right--
        while (a[left] <= k && left < right)
            left++
        val c: Int = a[left]
        a[left] = a[right]
        a[right] = c
    }
    a[0] = a[left]
    a[left] = k
    quickSort(a,0,left-1)
    quickSort(a,left-1,a.size-1)
}