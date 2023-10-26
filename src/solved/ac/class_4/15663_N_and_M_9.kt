package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader

val sb15663 = StringBuilder()

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }.sorted()

    dfsFor15663(N, M, nums.toIntArray())
    println(sb15663)
}


fun dfsFor15663(
    n: Int,
    m: Int,
    nums: IntArray,
    depth: Int = 0,
    visited: BooleanArray = BooleanArray(n) { false },
    res: String = "",
) {
    if (depth == m) {
        sb15663.append(res)
        sb15663.append("\n")
        return
    }

    var prev = -1
    for (i in 0 until n) {
        if (visited[i]) continue
        if (prev > -1 && nums[i] == nums[prev]) continue
        visited[i] = true
        dfsFor15663(n, m, nums, depth + 1, visited, res + "${nums[i]} ")
        visited[i] = false
        prev = i
    }
}