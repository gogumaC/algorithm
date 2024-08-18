package boj

import java.util.*

class BOJ1916() {

    class Bus(val start: Int, val end: Int, val weight: Int)

    fun solve() {
        val n = readln().toInt()
        val m = readln().toInt()
        val map = Array(n + 1) { mutableListOf<Bus>() }

        for (i in 0 until m) {
            val (start, end, weight) = readln().split(" ").map { it.toInt() }
            map[start].add(Bus(start, end, weight))
        }

        val (start, end) = readln().split(" ").map { it.toInt() }

        val dist = IntArray(n + 1) { Int.MAX_VALUE }

        val pq = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
            o1.second - o2.second
        }

        pq.add(start to 0)

        dist[start] = 0
        while (pq.isNotEmpty()) {
            val current = pq.poll().first
            if (current == end) break
            map[current].forEach {
                if (dist[it.end] > dist[current] + it.weight) {
                    dist[it.end] = dist[current] + it.weight
                    pq.add(it.end to dist[it.end])
                }
            }
        }

        print(dist[end])
    }
}

fun main() {
    BOJ1916().solve()
}