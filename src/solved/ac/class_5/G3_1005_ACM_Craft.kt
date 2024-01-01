package solved.ac.class_5

import java.util.*

class BOJ1005() {
    val sb = StringBuilder()
    fun solve() {
        val T = readln().toInt()
        for (i in 0 until T) {
            sb.append(findMinTime())
            sb.append("\n")
        }
        println(sb)
    }

    fun findMinTime(): Int {

        val (N, K) = readln().split(" ").map { it.toInt() }

        val time = intArrayOf(0) + readln().split(" ").map { it.toInt() }

        val forward = mutableMapOf<Int, MutableList<Int>>()
        val reverse = mutableMapOf<Int, MutableList<Int>>()

        val isStart = BooleanArray(N + 1) { true }

        for (i in 1..N) {
            forward[i] = mutableListOf()
            reverse[i] = mutableListOf()
        }
        isStart[0] = false

        for (i in 0 until K) {
            val (start, next) = readln().split(" ").map { it.toInt() }
            isStart[next] = false
            forward[start]!!.add(next)
            reverse[next]!!.add(start)
        }

        val q = LinkedList<Int>()
        val res = IntArray(N + 1) { 0 }

        for (i in 1..N) {
            if (isStart[i]) {
                q.add(i)
                res[i] = time[i]
            }
        }

        val W = readln().toInt()

        while (q.isNotEmpty()) {
            val current = q.poll()

            if (current == W) return res[W]

            forward[current]!!.forEach {
                reverse[it]!!.remove(current)

                if (res[it] < res[current] + time[it]) res[it] = res[current] + time[it]

                if (reverse[it]!!.isEmpty()) {
                    q.add(it)
                }
            }
        }

        return 0
    }
}

fun main() {
    BOJ1005().solve()
}