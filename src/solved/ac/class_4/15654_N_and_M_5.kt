package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    nums.sort()

    dfsFor15654(N, M, nums)
}

fun dfsFor15654(n: Int, m: Int, nums: IntArray, indexPath: MutableList<Int> = mutableListOf()) {

    if (indexPath.size == m) {
        val res = indexPath.joinToString(" ") {
            nums[it].toString()
        }
        println(res)
        return
    }

    for (i in 0 until n) {
        if (indexPath.isNotEmpty() && indexPath.contains(i)) continue
        indexPath.add(i)
        dfsFor15654(n, m, nums, indexPath)
        indexPath.remove(i)
    }
}