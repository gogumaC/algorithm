package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ11660() {

    val sb = StringBuilder()

    fun solve() {

        val br = BufferedReader(InputStreamReader(System.`in`))

        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        val board = Array(n + 1) { IntArray(n + 1) { 0 } }

        for (i in 1..n) {
            board[i] = intArrayOf(0) + br.readLine().split(" ").map { it.toInt() }.toIntArray()
        }

        val dp = Array(n + 1) { IntArray(n + 1) { 0 } }

        for (i in 1..n) {
            for (j in 1..n) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + board[i][j]
            }
        }

        for (i in 0 until m) {
            val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
            sb.append(calc(x1, y1, x2, y2, dp, board))
            sb.append("\n")
        }
        print(sb)
    }

    fun calc(x1: Int, y1: Int, x2: Int, y2: Int, dp: Array<IntArray>, board: Array<IntArray>): Int {
        return dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]
    }
}

fun main() {
    BOJ11660().solve()
}