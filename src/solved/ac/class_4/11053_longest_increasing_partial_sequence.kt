package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    findSequenceFor11053(n, list)
}

fun findSequenceFor11053(n: Int, list: IntArray) {
    val dp = IntArray(1010) { 0 }
    var maxCount = 1
    dp[list[0]] = 1
    for (i in 1 until n) {
        val current = list[i]
        var max = 0
        for (j in 0 until i) {//3
            if (list[j] < current) {
                max = max(max, dp[list[j]])
            }
        }
        dp[current] = max + 1
        maxCount = max(maxCount, dp[current])

    }
    println(maxCount)
}

