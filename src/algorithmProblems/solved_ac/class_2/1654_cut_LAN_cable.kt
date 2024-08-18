package solved.ac.class_2

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ1654() {
    fun solve() {

        val br = BufferedReader(InputStreamReader(System.`in`))

        val (k, n) = br.readLine().split(" ").map { it.toInt() }

        val length = IntArray(k) { 0 }

        for (i in 0 until k) {
            length[i] = br.readLine().toInt()
        }

        var low = 1L
        var high = length.max() + 1L

        while (low < high) {

            val mid = (high + low) / 2
            var count = 0L
            length.forEach {
                count += it / mid
            }

            if (count >= n) {
                low = mid + 1
            } else {
                high = mid
            }
        }

        println(high - 1)
    }
}

fun main() {
    BOJ1654().solve()
}