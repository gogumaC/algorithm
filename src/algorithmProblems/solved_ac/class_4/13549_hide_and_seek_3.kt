package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
import kotlin.math.min

class BOJ13549() {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val (n, k) = br.readLine().split(" ").map { it.toInt() }

        dijkstra(n, k)

    }

    fun dijkstra(n: Int, k: Int) {

        val size = min(100001, max(n, k) * 2 + 1)
        val time = IntArray(size) { 100001 }

        time[n] = 0
        val pq = PriorityQueue(Comparator { o1: Int, o2: Int ->
            time[o1] - time[o2]
        })
        pq.add(n)
        val mark = BooleanArray(size) { false }
        while (pq.isNotEmpty()) {
            val current = pq.remove()

            if (current > size - 1) continue
            mark[current] = true

            if (current * 2 < size && !mark[current * 2]) {
                time[current * 2] = min(time[current * 2], time[current])
                pq.add(current * 2)

            }

            if (current + 1 < size && !mark[current + 1]) {
                time[current + 1] = min(time[current + 1], time[current] + 1)
                pq.add(current + 1)

            }

            if (current - 1 > -1 && !mark[current - 1]) {
                time[current - 1] = min(time[current - 1], time[current] + 1)
                pq.add(current - 1)
            }

        }

        println(time[k])

    }
}

fun main() {
    BOJ13549().solve()
}