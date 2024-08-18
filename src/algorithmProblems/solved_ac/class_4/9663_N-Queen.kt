package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

class BOJ9663() {

    var count = 0

    fun solve() {

        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val queens = IntArray(n)
        backTracking(n, queens, 0)
        println(count)
    }

    fun backTracking(
        n: Int,
        queens: IntArray,
        current: Int
    ) {

        if (current == n) {
            count++
            return
        }

        for (i in 0 until n) {
            queens[current] = i
            if (checkEnable(queens, current)) backTracking(n, queens, current + 1)
        }
    }


    fun checkEnable(queens: IntArray, current: Int): Boolean {
        for (i in 0 until current) {
            if (queens[current] == queens[i] || current - i == abs(queens[current] - queens[i])) return false
        }
        return true
    }
}

fun main() {
    BOJ9663().solve()
}