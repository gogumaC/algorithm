package boj

import kotlin.math.ceil
import kotlin.math.sqrt

class BOJ1669() {
    fun solve() {

        val (x, y) = readln().split(" ").map { it.toInt() }
        if (x == y) {
            println(0)
            return
        }
        val peak = sqrt(y - x.toDouble())
        val res = ceil(2 * peak - 1)
        println(res.toInt())
    }
}

fun main() {
    BOJ1669().solve()
}