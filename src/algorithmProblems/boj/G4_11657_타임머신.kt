package boj

import kotlin.math.min

class BOJ11657() {
    data class Edge(val start: Int, val end: Int, val weight: Int)

    val INF = Long.MAX_VALUE / 2
    fun solve() {
        val (N, M) = readln().split(" ").map { it.toInt() }

        val map = Array(N + 1) { mutableListOf<Edge>() }
        for (i in 0 until M) {
            val (start, end, weight) = readln().split(" ").map { it.toInt() }
            map[start].add(Edge(start, end, weight))
        }

        val dist = LongArray(N + 1) { INF }
        dist[1] = 0

        for (i in 2..N) {
            for (j in 1..N) {
                if (dist[j] == INF) continue
                map[j].forEach {
                    dist[it.end] = min(dist[it.start] + it.weight, dist[it.end])
                }
            }
        }

        for (i in 1..N) {
            if (dist[i] == INF) continue
            map[i].forEach {
                if (dist[it.end] != min(dist[it.start] + it.weight, dist[it.end])) {
                    println(-1)
                    return
                }
            }
        }

        with(StringBuilder()) {
            for (i in 2..N) {
                if (dist[i] != INF) append(dist[i])
                else append(-1)
                append("\n")
            }

            print(this)
        }
    }
}

fun main() {
    BOJ11657().solve()
}