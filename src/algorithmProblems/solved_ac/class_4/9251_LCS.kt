package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

//ref : https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence#longest-common-subsequence-substring

class BOJ9251() {

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val s1 = br.readLine()
        val s2 = br.readLine()

        println(dp(s1, s2))
    }

    fun dp(s1: String, s2: String): Int {

        val lcs = Array(s1.length + 1) { IntArray(s2.length + 1) { 0 } }
        var max = 0

        for (i in 1..s1.length) {
            for (j in 1..s2.length) {
                if (s1[i - 1] == s2[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1
                } else lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])

                max = max(lcs[i][j], max)
            }
        }

        return max
    }
}

fun main() {
    BOJ9251().solve()
}