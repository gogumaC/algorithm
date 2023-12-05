package solved.ac.class_5

import kotlin.math.abs

class BOJ2166() {

    lateinit var x: LongArray
    lateinit var y: LongArray
    var n = 0

    fun solve() {
        n = readln().toInt()
        x = LongArray(n + 1)
        y = LongArray(n + 1)

        for (i in 0 until n) {
            val (x, y) = readln().split(" ").map { it.toLong() }
            this.x[i] = x
            this.y[i] = y
        }

        x[n] = x[0]
        y[n] = y[0]
        println(String.format("%.1f", calcArea()))

    }

    fun calcArea(): Double {
        var sum1 = 0L
        var sum2 = 0L
        for (i in 0 until n) {
            sum1 += x[i] * y[i + 1]
            sum2 += x[i + 1] * y[i]
        }
        return abs(sum1 - sum2) / 2.0
    }
}

fun main() {
    BOJ2166().solve()
}