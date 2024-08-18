package boj

import java.util.*

class BOJ1715() {

    var N: Int = 0
    lateinit var bundles: PriorityQueue<Int>
    var res = 0
    fun solve() {

        N = readln().toInt()
        bundles = PriorityQueue<Int>()

        for (i in 0 until N) {
            bundles.add(readln().toInt())
        }

        println(calcMinCompareCount())
    }

    fun calcMinCompareCount(): Int {

        for (i in 0 until N - 1) {
            val a = bundles.remove()
            val b = bundles.remove()
            res += a + b
            bundles.add(a + b)
        }
        return res
    }
}

fun main() {
    BOJ1715().solve()
}