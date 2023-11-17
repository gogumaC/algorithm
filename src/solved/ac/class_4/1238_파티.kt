package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

class BOJ1238() {

    var N = 0
    var M = 0
    var X = 0

    lateinit var paths: Array<IntArray>

    val INF = Int.MAX_VALUE / 2

    fun solve() {

        val br = BufferedReader(InputStreamReader(System.`in`))

        val input = br.readLine().split(" ").map { it.toInt() }
        N = input[0]
        M = input[1]
        X = input[2]

        paths = Array(N + 1) { IntArray(N + 1) { INF } }


        for (i in 0 until M) {
            val (start, end, time) = br.readLine().split(" ").map { it.toInt() }
            paths[start][end] = time
        }

        for (i in 1..N) {
            paths[i][i] = 0
        }

        floyd()

        var max = 0
        for (i in 1..N) {
            val sum = paths[i][X] + paths[X][i]
            if (sum > max) {
                max = sum
            }
        }
        println(max)
    }

    fun floyd() {

        for (r in 1..N) {
            for (i in 1..N) {
                if (r == i) continue
                for (j in 1..N) {
                    if (r == j) continue
                    paths[i][j] = min(paths[i][r] + paths[r][j], paths[i][j])
                }
            }
        }
    }
}

fun main() {
    BOJ1238().solve()
}