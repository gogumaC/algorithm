package boj

import java.util.*

class BOJ12015() {

    var N = 0
    lateinit var seq: IntArray

    fun solve() {
        N = readln().toInt()

        seq = IntArray(N)
        with(StringTokenizer(readln())) {
            for (i in 0 until N) {
                seq[i] = nextToken().toInt()
            }
        }
        val res = IntArray(N)
        var resLastIndex = 0
        res[resLastIndex] = seq[0]

        for (i in 1 until N) {
            val current = seq[i]
            if (res[resLastIndex] < current) {
                resLastIndex++
                res[resLastIndex] = current
            } else if (res[resLastIndex] > current) {
                val index = binarySearch(res, resLastIndex, current)
                res[index] = current
            }
        }
        println(resLastIndex + 1)

    }

    fun binarySearch(list: IntArray, lastIndex: Int, n: Int): Int {

        var high = lastIndex
        var low = 0

        while (high > low) {
            val mid = low + (high - low) / 2
            if (list[mid] < n) low = mid + 1
            else high = mid
        }
        return high
    }
}


fun main() {
    BOJ12015().solve()
}