package boj

import java.util.*
import kotlin.math.max

class BOJ7579() {
    fun solve() {
        val st = StringTokenizer(readln())
        val N = st.nextToken().toInt()
        val M = st.nextToken().toInt()

        val mem = IntArray(N + 1)
        val cost = IntArray(N + 1)

        val st1 = StringTokenizer(readln())
        val st2 = StringTokenizer(readln())

        for (i in 1..N) {
            mem[i] = st1.nextToken().toInt()
            cost[i] = st2.nextToken().toInt()
        }

        val maxCost = 10000
        val dp = Array(N + 1) { IntArray(maxCost + 1) }

        for (i in 1..N) {
            for (j in 0..maxCost) {
                if (cost[i] > j) {
                    dp[i][j] = dp[i - 1][j]
                } else {
                    val takeout = dp[i - 1][j]
                    val putin = mem[i] + dp[i - 1][j - cost[i]]
                    dp[i][j] = max(takeout, putin)
                }

                if (i == N && dp[i][j] >= M) {
                    println(j)
                    return
                }

            }
        }
    }
}

fun main() {
    BOJ7579().solve()
}