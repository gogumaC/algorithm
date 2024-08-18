package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val map = Array(n) { Array(m) { 0 } }

    var goalX = 0
    var goalY = 0

    for (i in 0 until n) {
        br.readLine().split(" ").forEachIndexed { index, s ->
            map[i][index] = s.toInt()
            if (map[i][index] == 2) {
                goalX = i
                goalY = index
            }
        }
    }
    dijkstraFor14940(n, m, map, goalX, goalY)
}

fun dijkstraFor14940(n: Int, m: Int, map: Array<Array<Int>>, goalX: Int, goalY: Int) {

    val distances = Array(n) { Array(m) { -1 } }
    distances[goalX][goalY] = 0
    val queue = mutableListOf(Pair(goalX, goalY))

    val offsetX = arrayOf(-1, 0, 1, 0)
    val offsetY = arrayOf(0, -1, 0, 1)

    while (queue.isNotEmpty()) {
        val current = queue.first()
        val currentX = current.first
        val currentY = current.second
        queue.removeFirst()

        for (i in 0 until 4) {
            val nextX = currentX + offsetX[i]
            val nextY = currentY + offsetY[i]
            if (nextX > -1 && nextX < n && nextY > -1 && nextY < m) {
                if (map[nextX][nextY] == 1 && distances[nextX][nextY] < 0) {
                    queue.add(Pair(nextX, nextY))
                    distances[nextX][nextY] = distances[currentX][currentY] + 1
                }
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 0) distances[i][j] = 0
        }
    }
    with(StringBuilder()) {
        for (i in 0 until n) {
            for (j in 0 until m) {
                append(distances[i][j])
                if (j != m - 1) append(" ")
            }
            if (i != n - 1) append("\n")
        }
        println(this)
    }
}

