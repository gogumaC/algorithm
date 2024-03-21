package programmers.level_1.BFS

import java.util.*

class LV2_리코쳇_로봇 {
    fun solution(board: Array<String>): Int {
        var answer: Int = 0
        var x = 0
        var y = 0
        for (i in 0 until board.size) {
            if (board[i].contains("R")) {
                y = i
                x = board[i].indexOf('R')
                break
            }
        }

        val q = LinkedList<IntArray>()

        for (i in 0..3) {
            q.add(intArrayOf(x, y, 1, i))
        }

        val v = Array(100) { BooleanArray(100) }
        val offset = arrayOf(-1 to 0, 0 to -1, 1 to 0, 0 to 1)
        v[x][y] = true

        while (q.isNotEmpty()) {

            val c = q.remove()
            var tx = c[0]
            var ty = c[1]
            val d = c[2]
            val dir = c[3]

            val (ofx, ofy) = offset[dir]
            while (true) {
                var nx = tx + ofx
                var ny = ty + ofy
                if (nx !in 0 until board[0].length || ny !in 0 until board.size) break
                else if (board[ny][nx] == 'D') break
                else {
                    tx = nx
                    ty = ny
                }
            }

            val off = (dir + 2) % 4
            println("$tx $ty -- $d")
            if (v[tx][ty]) continue
            v[tx][ty] = true

            if (board[ty][tx] == 'G') {
                return d
            }

            for (i in 0 until 4) {
                if (i != off || i != dir) q.add(intArrayOf(tx, ty, d + 1, i))
            }

        }
        return -1
    }

}