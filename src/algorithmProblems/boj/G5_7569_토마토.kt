package boj

import java.util.*

class BOJ7569() {

    data class Coordinate(val x: Int, val y: Int, val z: Int)

    val offsets = arrayOf(
        Triple(1, 0, 0),
        Triple(-1, 0, 0),
        Triple(0, 1, 0),
        Triple(0, -1, 0),
        Triple(0, 0, 1),
        Triple(0, 0, -1)
    )

    fun solve() {
        val (M, N, H) = readln().split(" ").map { it.toInt() }

        val box = Array(N) { Array(M) { IntArray(H) } }
        val q = LinkedList<Pair<Coordinate, Int>>()

        var isAlreadyRipen = true
        for (i in 0 until H) {
            for (j in 0 until N) {
                val st = StringTokenizer(readln())
                for (k in 0 until M) {
                    box[j][k][i] = st.nextToken().toInt()
                    if (isAlreadyRipen && box[j][k][i] == 0) isAlreadyRipen = false
                    if (box[j][k][i] == 1) q.add(Coordinate(j, k, i) to 0)
                }
            }
        }

        if (isAlreadyRipen) {
            println(0)
            return
        }

        while (q.isNotEmpty()) {
            val (coordinate, day) = q.remove()
            val (x, y, z) = coordinate

            for ((ox, oy, oz) in offsets) {
                val nx = x + ox
                val ny = y + oy
                val nz = z + oz
                //println("$nx $ny $nz")

                if (nx in 0 until N && ny in 0 until M && nz in 0 until H) {
                    if (box[nx][ny][nz] == -1) continue
                    if (box[nx][ny][nz] == 0 || box[nx][ny][nz] > day + 1) {
                        q.add(Coordinate(nx, ny, nz) to day + 1)
                        box[nx][ny][nz] = day + 1
                    }
                }
            }

        }

        var max = 0
        for (i in 0 until H) {
            for (j in 0 until N) {
                for (k in 0 until M) {
                    if (box[j][k][i] == 0) {
                        println(-1)
                        return
                    }
                    if (box[j][k][i] > max) max = box[j][k][i]

                }
            }
        }

        println(max)
    }
}

fun main() {
    BOJ7569().solve()
}