package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

class BOJ12865() {

    data class Stuff(val value: Int = 0, val weight: Int = 0)

    fun solve() {

        val br = BufferedReader(InputStreamReader(System.`in`))

        val (n, k) = br.readLine().split(" ").map { it.toInt() }

        val stuffs = Array(n + 1) { Stuff() }
        (1..n).forEach { i ->
            val (w, v) = br.readLine().split(" ").map { it.toInt() }
            stuffs[i] = Stuff(v, w)
        }

        println(dp(n, k, stuffs))
    }

    fun dp(n: Int, k: Int, stuffs: Array<Stuff>): Int {

        val dp = Array(n + 1) { IntArray(k + 1) { 0 } }
        var max = 0

        for (i in 1..n) {
            for (j in 1..k) {
                if (stuffs[i].weight > j) {
                    dp[i][j] = dp[i - 1][j]
                    continue
                }
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - stuffs[i].weight] + stuffs[i].value)
                max = max(max, dp[i][j])
            }
        }
        return max
    }
}

fun main() {
    BOJ12865().solve()
}