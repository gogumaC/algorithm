package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }
    val sums = nums.toIntArray()
    for (i in 1 until n) {
        sums[i] += sums[i - 1]
    }

    StringBuilder().let {
        for (i in 0 until m) {
            val (start, finish) = br.readLine().split(" ").map { it.toInt() - 1 }
            val sum = if (start - 1 < 0)  sums[finish] else sums[finish] - sums[start-1]
            it.append(sum)
            it.append("\n")
        }
        println(it)
    }
}
