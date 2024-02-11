package boj

import java.util.*
import kotlin.math.min

class BOJ11049() {
    fun solve() {
        val N = readln().toInt()
        val matrix = Array(N) { LongArray(2) }
        val dp = Array(N) { LongArray(N) { 500 * 500 * 500 + 1L } }
        for (i in 0 until N) {
            StringTokenizer(readln()).apply {
                val n = nextToken().toLong()
                val m = nextToken().toLong()
                matrix[i][0] = n
                matrix[i][1] = m
            }
            dp[i][i] = 0
        }

        for (gap in 1 until N) {
            for (i in 0 until N) {
                if (i + gap == N) break
                val i1 = i
                val i2 = i + gap

                val m1 = matrix[i1]
                val m2 = matrix[i2]
                for (k in i1 until i2) {
                    val res = dp[i1][k] + dp[k + 1][i2] + m1[0] * matrix[k][1] * m2[1]
                    dp[i1][i2] = min(dp[i1][i2], res)
                }
            }
        }


        println(dp[0][N - 1])
    }
}

fun main() {
    BOJ11049().solve()
}