package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

class BOJ11404() {

    val MAX = Int.MAX_VALUE / 2
    val weights = Array(101) { IntArray(101) { MAX } }
    var M = 0
    var N = 0

    val res = Array(101) { IntArray(101) { MAX } }
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val sb = StringBuilder()

        N = br.readLine().toInt()
        M = br.readLine().toInt()

        for (i in 0 until M) {
            val (start, goal, weight) = br.readLine().split(" ").map { it.toInt() }
            weights[start][goal] = min(weights[start][goal], weight)
            res[start][goal] = weights[start][goal]
        }

        for (i in 1..N) {
            res[i][i] = 0
        }

        floyd()

        with(sb) {
            for (i in 1..N) {
                for (j in 1..N) {
                    append(if (res[i][j] >= MAX) 0 else res[i][j])
                    append(" ")
                }
                append("\n")
            }
            println(this)
        }

    }

    fun floyd() {
        for (r in 1..N) {
            for (i in 1..N) {
                for (j in 1..N) {
                    if (i == r || j == r) continue
                    res[i][j] = min(res[i][j], res[i][r] + res[r][j])
                }
            }
        }
    }

    fun dijkstra(start: Int) {
        val pq = PriorityQueue { o1: Pair<Int, Int>, o2: Pair<Int, Int> ->
            o1.second - o2.second
        }
        val mark = BooleanArray(N + 1) { false }
        pq.add(start to 0)
        while (pq.isNotEmpty()) {
            val current = pq.remove().first
            mark[current] = true
            for (goal in 1..N) {
                if (weights[current][goal] != Int.MAX_VALUE && !mark[goal]) {
                    res[start][goal] = min(res[start][current] + weights[current][goal], res[start][goal])
                    pq.add(goal to weights[current][goal])
                }
            }
        }

    }
}

fun main() {
    BOJ11404().solve()
}