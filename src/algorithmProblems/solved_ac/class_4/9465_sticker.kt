package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

class BOJ9465() {

    val sb = StringBuilder()

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val t = br.readLine().toInt()

        for (i in 0 until t) {

            val n = br.readLine().toInt()
            val board = Array(2) { intArrayOf(0) }

            for (j in 0 until 2) {
                board[j] += br.readLine().split(" ").map { it.toInt() }.toIntArray()
            }
            sb.append(dp(n, board))
            sb.append("\n")
        }

        println(sb)
    }

    fun dp(n: Int, board: Array<IntArray>): Int {

        val dp = Array(2) { IntArray(n + 1) { 0 } }
        dp[0][0] = 0
        dp[1][0] = 0
        dp[0][1] = board[0][1]
        dp[1][1] = board[1][1]

        for (i in 2..n) {
            dp[1][i] = max(dp[0][i - 1], dp[0][i - 2]) + board[1][i]
            dp[0][i] = max(dp[1][i - 1], dp[1][i - 2]) + board[0][i]
        }

        return max(dp[0][n], dp[1][n])
    }
}

fun main() {
    BOJ9465().solve()
}