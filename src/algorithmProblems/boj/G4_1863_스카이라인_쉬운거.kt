package boj

import java.util.*

class BOJ1863() {
    fun solve() {
        val n = readln().toInt()

        var count = 0
        val skyLine = mutableListOf<Pair<Int, Int>>()
        for (i in 0 until n) {
            val (x, y) = readln().split(" ").map { it.toInt() }
            skyLine.add(x to y)
        }

        skyLine.sortBy {
            it.first
        }

        skyLine.add(0 to 0)

        val stack = Stack<Int>()
        for (i in skyLine.indices) {
            val (_, y) = skyLine[i]
            if (stack.isEmpty() || y > stack.last()) stack.add(y)
            else {
                while (stack.isNotEmpty() && stack.last() > y) {
                    stack.pop()
                    count++
                }
                if (y != 0 && stack.lastOrNull() != y) stack.add(y)
            }
        }

        println(count)
    }

}

fun main() {
    BOJ1863().solve()
}