package boj

import java.util.*

class BOJ9466() {

    var n = 0
    lateinit var map: IntArray
    lateinit var isVisited: IntArray
    lateinit var finished: BooleanArray
    var cycleCount = 0

    val NOT_VISITED = 0
    val VISITED = 1
    val CYCLE = 2

    fun solve(): Int {
        n = readln().toInt()
        map = IntArray(n + 1)
        val st = StringTokenizer(readln())
        isVisited = IntArray(n + 1)
        finished = BooleanArray(n + 1)
        isVisited[0] = CYCLE
        for (i in 1..n) {
            val to = st.nextToken().toInt()
            map[i] = to
        }

        for (i in 1..n) {
            if (isVisited[i] != NOT_VISITED) continue
            dfs(i)
        }

        return n - cycleCount
    }

    fun dfs(start: Int) {
        val stack = Stack<Int>()
        val temp = mutableSetOf<Int>()
        stack.add(start)
        while (stack.isNotEmpty()) {
            val current = stack.pop()
            temp.add(current)
            val next = map[current]
            if (finished[next]) break

            when (isVisited[next]) {
                NOT_VISITED -> {
                    isVisited[next] = VISITED
                    stack.add(next)
                }

                VISITED -> {
                    isVisited[next] = CYCLE
                    stack.add(next)
                    cycleCount++
                }

                CYCLE -> break
            }

        }
        temp.forEach {
            finished[it] = true
        }
    }
}

fun main() {
    val t = readln().toInt()
    val sb = StringBuilder()
    for (i in 0 until t) {
        sb.append(BOJ9466().solve())
        sb.append("\n")
    }

    print(sb)
}