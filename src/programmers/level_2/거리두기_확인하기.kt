package programmers.level_2

import kotlin.math.abs

class Solution {
    fun solution(places: Array<Array<String>>): IntArray {
        var answer: IntArray = IntArray(places.size) { 0 }

        places.forEachIndexed { index, room ->
            answer[index] = (checkSafety(room))
            println("-------")
        }
        return answer
    }

    fun checkSafety(room: Array<String>): Int {

        for (i in 0..4) {
            for (j in 0..4) {
                if (room[i][j] == 'P') {
                    val res = bfs(i, j, room)
                    println(res)
                    if (res == false) return 0
                }
            }
        }
        return 1
    }


    data class Data(val x: Int, val y: Int, var depth: Int)

    fun bfs(x: Int, y: Int, room: Array<String>): Boolean {
        val queue = mutableListOf<Data>()
        val offsetX = intArrayOf(-1, 0, 1, 0)
        val offsetY = intArrayOf(0, -1, 0, 1)
        val mark = Array(5) { BooleanArray(5) { false } }

        println("start $x $y")

        queue.add(Data(x, y, 0))
        mark[x][y] = true

        var res = false

        while (queue.isNotEmpty()) {
            val current = queue.first()
            queue.removeFirst()

            if (room[current.x][current.y] == 'P' && current.depth != 0 && current.depth <= 2 && abs(x - current.x) + abs(
                    y - current.y
                ) < 3
            ) {
                println("$current")
                return false
            }
            if (abs(x - current.x) + abs(y - current.y) > 2) return true

            val currentD = current.depth

            for (i in 0..3) {
                val nx = current.x + offsetX[i]
                val ny = current.y + offsetY[i]

                if (nx > -1 && nx < 5 && ny > -1 && ny < 5 && !mark[nx][ny]) {

                    if (room[nx][ny] == 'X') continue
                    else queue.add(Data(nx, ny, currentD + 1))
                    mark[nx][ny] = true

                }
            }

        }
        return true
    }
}