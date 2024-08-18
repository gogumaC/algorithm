package boj

import java.util.*

class BOJ11000() {
    fun solve() {
        val n = readln().toInt()
        val lectures = Array(n) { IntArray(2) }

        val finishTimes = PriorityQueue<Int>()
        for (i in 0 until n) {
            val (s, t) = readln().split(" ").map { it.toInt() }
            lectures[i][0] = s
            lectures[i][1] = t
        }

        lectures.sortWith { o1, o2 ->
            if (o1[0] != o2[0]) o1[0] - o2[0] else o1[1] - o2[1]
        }

        for ((start, finish) in lectures) {

            finishTimes.add(finish)
            if (finishTimes.isEmpty()) continue
            if (finishTimes.peek() <= start) {
                finishTimes.remove()
            }
        }

        println(finishTimes.size)


    }
}

fun main() {
    BOJ11000().solve()
}

