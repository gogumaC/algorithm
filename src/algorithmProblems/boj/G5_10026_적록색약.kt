package boj

import java.util.*

class BOJ10026() {
    var N = 0
    lateinit var map: Array<String>

    val offsets = arrayOf(-1 to 0, 0 to -1, 1 to 0, 0 to 1)
    fun solve() {
        N = readln().toInt()
        map = Array(N) { "" }
        for (i in 0 until N) {
            map[i] = readln()
        }

        val sectionCount = findSectionCount()

        val colorWeakSectionCount = findColorWeakSectionCount()

        StringBuilder().apply {
            append(sectionCount)
            append(" ")
            append(colorWeakSectionCount)
            println(this)
        }
    }

    fun findSectionCount(): Int {
        val stack = Stack<Pair<Int, Int>>()
        val isVisited = Array(N) { BooleanArray(N) }
        var count = 0

        for (i in 0 until N) {
            for (j in 0 until N) {
                if (isVisited[i][j]) continue
                count++
                stack.add(i to j)
                isVisited[i][j] = true
                while (stack.isNotEmpty()) {
                    val (x, y) = stack.pop()
                    offsets.forEach { (offsetX, offsetY) ->
                        val nX = x + offsetX
                        val nY = y + offsetY
                        if (nX in 0 until N && nY in 0 until N && !isVisited[nX][nY] && map[i][j] == map[nX][nY]) {
                            isVisited[nX][nY] = true
                            stack.add(nX to nY)
                        }
                    }
                }

            }
        }
        return count
    }

    fun findColorWeakSectionCount(): Int {

        for (i in 0 until N) {
            map[i] = map[i].replace('G', 'R')
        }

        return findSectionCount()
    }


}

fun main() {
    BOJ10026().solve()
}