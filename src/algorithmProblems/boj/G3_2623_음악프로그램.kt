package boj

import java.util.*

class BOJ2623() {
    var N = 0
    var M = 0
    fun solve() {
        with(StringTokenizer(readln())) {
            N = nextToken().toInt()
            M = nextToken().toInt()
        }
        val degree = IntArray(N + 1)
        val out = Array(N + 1) { mutableListOf<Int>() }
        for (i in 0 until M) {
            val input = StringTokenizer(readln())
            val order = IntArray(input.nextToken().toInt())
            for (j in order.indices) {
                order[j] = input.nextToken().toInt()
            }
            for (j in 0 until order.size - 1) {
                val prev = order[j]
                val next = order[j + 1]
                out[prev].add(next)
                degree[next]++
            }
        }

        val q = LinkedList<Int>()

        for (i in 1..N) {
            if (degree[i] == 0) q.add(i)
        }
        val sb = StringBuilder()
        while (q.isNotEmpty()) {
            val current = q.poll()
            sb.append(current)
            sb.append("\n")
            for (next in out[current]) {
                degree[next]--
                if (degree[next] == 0) q.add(next)
            }

        }

        if (degree.any { it != 0 }) println(0)
        else print(sb)
    }
}

fun main() {
    BOJ2623().solve()
}