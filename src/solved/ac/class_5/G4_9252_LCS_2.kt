package solved.ac.class_5

import kotlin.math.max

class BOJ9252() {
    var s1 = " "
    var s2 = " "
    fun solve() {
        s1 += readln()
        s2 += readln()

        dp()

    }

    fun dp() {
        val dp = Array(s1.length) { IntArray(s2.length) }

        for (i in 1 until s1.length) {
            for (j in 1 until s2.length) {
                if (s1[i] == s2[j]) dp[i][j] = dp[i - 1][j - 1] + 1
                else dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            }
        }

        val res = StringBuilder()
        var r = s1.length - 1
        var c = s2.length - 1
        while (true) {
            when (dp[r][c]) {
                0 -> break
                dp[r - 1][c] -> r--
                dp[r][c - 1] -> c--
                else -> {
                    res.append(s1[r])
                    r--;c--
                }
            }
        }

        res.reverse()

        with(StringBuilder()) {
            append(dp[s1.length - 1][s2.length - 1])
            append("\n")
            append(res)
            println(this)
        }
    }
}

fun main() {
    BOJ9252().solve()
}