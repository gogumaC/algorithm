package solved.ac.class_5

import kotlin.math.abs

class BOJ2467() {
    lateinit var l: IntArray
    var a = 0
    var b = 0
    var sum = Int.MAX_VALUE
    fun solve() {
        val n = readln().toInt()
        l = readln().split(" ").map { it.toInt() }.toIntArray()

        val min = 0
        val max = n - 1

        if (l[min] > 0) {
            a = l[0]
            b = l[1]
        } else if (l[max] < 0) {
            a = l[max - 1]
            b = l[max]
        } else {

            for (i in 0 until n) {
                val n1 = l[i]
                var start = i + 1
                var end = n - 1
                while (start <= end) {
                    val mid = (start + end) / 2
                    val n2 = l[mid]
                    val tmp = n1 + n2

                    if (abs(tmp) < sum) {
                        a = n1
                        b = n2
                        sum = abs(tmp)
                        if (n1 + n2 == 0) break
                    }

                    if (tmp < 0) start = mid + 1
                    else end = mid - 1
                }
            }
        }

        with(StringBuilder()) {
            append(a)
            append(" ")
            append(b)
            println(this)
        }

    }
}

fun main() {
    BOJ2467().solve()
}