package solved.ac.class_2

import java.util.*


fun main() {
    BOJ10989().solve()
}

class BOJ10989() {
    fun solve() {
        val n = readln().toInt()
        val a = PriorityQueue<Int>()
        (0 until n).forEach { _ ->
            a.offer(readln().toInt())
        }
        
        with(StringBuilder()) {
            a.forEach {
                append(it)
                append("\n")
            }
            print(this)
        }
    }
}
