package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ1865() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    var N = 0
    var M = 0
    var W = 0

    val INF = Int.MAX_VALUE / 2

    fun solve() {
        val T = br.readLine().toInt()

        for (t in 0 until T) {
            val input = br.readLine().split(" ").map { it.toInt() }
            N = input[0]
            M = input[1]
            W = input[2]

            val res = if (checkTimeBack()) "YES" else "NO"
            sb.append(res + "\n")
        }

        print(sb)
    }

    fun checkTimeBack(): Boolean {
        val path = ArrayList<IntArray>()
        for (i in 0 until M) {
            val (start, end, weight) = br.readLine().split(" ").map { it.toInt() }
            path.add(intArrayOf(start, end, weight))
            path.add(intArrayOf(end, start, weight))
        }
        for (i in M until M + W) {
            val (start, end, weight) = br.readLine().split(" ").map { it.toInt() }
            path.add(intArrayOf(start, end, -weight))
        }

        for (i in 1..N) {
            if (bellmanFord(path, i)) return true
        }

        return false
    }

    fun bellmanFord(edges: MutableList<IntArray>, start: Int = 0): Boolean {
        val dist = IntArray(N + 1) { INF }
        dist[start] = 0
        for (i in 1..N) {
            var isChanged = false
            for ((u, v, w) in edges) {
                if (dist[u] != INF && dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w
                    isChanged = true
                }
            }
            if (!isChanged) break
        }

        if (dist[start] < 0) return true
        for ((u, v, w) in edges) {
            if (dist[u] != INF && dist[v] > dist[u] + w) {
                return true
            }
        }

        return dist[start] < 0
    }

}

fun main() {
    BOJ1865().solve()
}