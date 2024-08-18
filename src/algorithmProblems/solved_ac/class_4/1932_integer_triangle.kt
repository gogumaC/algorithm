package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

class BOJ1932() {

    val tree = Array(500 + 1) { IntArray(500) { 0 } }
    var maxSum = 0

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        for (i in 0 until n) {
            tree[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        }

        println(dp(n))
    }

    fun dp(n: Int): Int {

        val dp = Array(500 + 1) { IntArray(500) { 0 } }
        dp[0][0] = tree[0][0]

        for (depth in 1 until n) {
            for (i in 0..depth) {
                val leftParentSum = if (i > 0) dp[depth - 1][i - 1] else 0
                val rightParentSum = if (i < depth) dp[depth - 1][i] else 0
                dp[depth][i] = max(leftParentSum, rightParentSum) + tree[depth][i]
            }
        }

        dp[n - 1].sortDescending()
        return dp[n - 1][0]
    }

    fun dfs(n: Int, depth: Int = 0, parentIndex: Int, currentSum: Int) {

        if (depth == n) {
            maxSum = max(maxSum, currentSum)
            return
        }

        if (depth == 0) {
            val root = tree[0][0]
            dfs(n, depth + 1, 0, root)
            return
        }

        val leftNodeIndex = parentIndex
        val rightNodeIndex = parentIndex + 1
        val leftNode = tree[depth][leftNodeIndex]
        val rightNode = tree[depth][rightNodeIndex]

        dfs(n, depth + 1, leftNodeIndex, currentSum + leftNode)
        dfs(n, depth + 1, rightNodeIndex, currentSum + rightNode)

    }
}

fun main() {
    BOJ1932().solve()
}