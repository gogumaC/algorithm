package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() {
    BOJ2206().solve()
}

class BOJ2206() {

    val YES = 1
    val NO = 0
    lateinit var map: Array<IntArray>
    var min = Int.MAX_VALUE
    var N = 0
    var M = 0
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        N = n;M = m

        map = Array(N + 1) { IntArray(M + 1) { 0 } }
        val walls = mutableListOf<Pair<Int, Int>>()
        for (i in 1..N) {
            val input = br.readLine()
            for (j in 1..M) {
                map[i][j] = input[j - 1].digitToInt()
                if (map[i][j] == 1) walls.add(Pair(i, j))
            }
        }
        bfs()
        println(if (min != Int.MAX_VALUE) min else -1)
    }

    val offsetR = arrayOf(-1, 0, 1, 0)
    val offsetC = arrayOf(0, -1, 0, 1)

    fun bfs() {
        val q = LinkedList<IntArray>()
        val dist = Array(N + 1) { Array(M + 1) { IntArray(2) } }
        dist[1][1][0] = 1

        q.add(intArrayOf(1, 1, YES))

        while (q.isNotEmpty()) {
            val (r, c, breakable) = q.poll()

            for (i in 0..3) {
                val nr = r + offsetR[i]
                val nc = c + offsetC[i]
                if (nr in 1..N && nc in 1..M) {
                    val currentDim = if (breakable == YES) 0 else 1
                    if (dist[nr][nc][1] == 0 && breakable == YES && map[nr][nc] == 1) {
                        q.offer(intArrayOf(nr, nc, NO))
                        dist[nr][nc][1] = dist[r][c][0] + 1
                    } else if (dist[nr][nc][currentDim] == 0 && map[nr][nc] == 0) {
                        q.offer(intArrayOf(nr, nc, breakable))
                        dist[nr][nc][currentDim] = dist[r][c][currentDim] + 1
                    }
                }
            }
        }
        if (dist[N][M][0] > 0) {
            min = min(dist[N][M][0], min)
        }
        if (dist[N][M][1] > 0) {
            min = min(dist[N][M][1], min)
        }
    }
}
