package boj

import kotlin.math.min

class BOJ1106() {

    fun solve() {
        val (c, n) = readln().split(" ").map { it.toInt() }

        val promotions = mutableListOf<Pair<Int, Int>>()
        for (i in 1..n) {
            val (cost, customer) = readln().split(" ").map { it.toInt() }
            promotions.add(cost to customer)
        }

        val dp = IntArray(c + 100) { Int.MAX_VALUE / 2 }
        dp[0] = 0

        for ((cost, customer) in promotions) {
            for (j in customer until dp.size) {
                dp[j] = min(dp[j], dp[j - customer] + cost)
            }
        }

        println(dp.filterIndexed { index, _ -> index >= c }.min())
    }
}

fun main() {
    BOJ1106().solve()
}