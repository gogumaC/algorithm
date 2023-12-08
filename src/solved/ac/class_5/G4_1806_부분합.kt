package solved.ac.class_5

import kotlin.math.min

class BOJ1806() {

    var N = 0
    var S = 0

    lateinit var seq: List<Int>
    val sums = IntArray(100000)
    fun solve() {
        val input = readln().split(" ").map { it.toInt() }
        N = input[0]
        S = input[1]

        seq = readln().split(" ").map { it.toInt() }

        sums[0] = seq[0]
        for (i in 1 until N) {
            sums[i] = sums[i - 1] + seq[i]
        }

        // a~b까지 합 = sums[b]-sums[a]+seq[a]

        var start = 0
        var end = 0
        var l = Int.MAX_VALUE

        while (start <= end && start < N && end < N) {
            val sum = sums[end] - sums[start] + seq[start]
            if (sum >= S) {
                l = min(l, end - start + 1)
                start++
            } else end++
        }

        println(if (l == Int.MAX_VALUE) 0 else l)

    }
}

fun main() {
    BOJ1806().solve()
}