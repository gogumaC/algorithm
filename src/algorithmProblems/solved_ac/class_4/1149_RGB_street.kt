package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

class BOJ1149() {
    val RED = 0
    val GREEN = 1
    val BLUE = 2

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        val cost = Array(n) { intArrayOf() }
        for (i in 0 until n) {
            cost[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        }

        //dfs(n, 0, -1, 0, cost)
        dp(n, cost)
        println(minCost)
    }

    var minCost = Int.MAX_VALUE

    fun dp(n: Int, cost: Array<IntArray>) {
        val dp = Array(n) { IntArray(3) { 0 } }
        dp[0] = cost[0]

        for (i in 1 until n) {
            for (color in RED..BLUE) {
                dp[i][color] = min(dp[i - 1][(color + 1) % 3], dp[i - 1][(color + 2) % 3]) + cost[i][color]
            }
        }
        dp[n - 1].sort()
        minCost = dp[n - 1].first()
    }

    fun dfs(n: Int, index: Int, prevColor: Int, currentCost: Int, cost: Array<IntArray>) {
        if (index == n) {
            minCost = min(minCost, currentCost)
            return
        }
        if (currentCost > minCost) return

        for (color in RED..BLUE) {
            if (prevColor == color) continue
            dfs(n, index + 1, color, currentCost + cost[index][color], cost)
        }
    }
}

fun main() {
    BOJ1149().solve()
}