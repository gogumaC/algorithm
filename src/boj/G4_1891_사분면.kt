package boj

import kotlin.math.pow

class BOJ1891() {

    private var boxLine = 0L
    fun solve() {
        val (d, n) = readln().split(" ")
        val (x, y) = readln().split(" ").map { it.toLong() }

        boxLine = 2.0.pow(d.toInt()).toLong()

        val (cx, cy) = convertNumtoXY(n)
        val nx = cx + x
        val ny = cy + y
        if (nx in (0 until boxLine) && ny in (0 until boxLine)) println(convertXYtoNum(nx, ny))
        else println(-1)
    }

    private val pointMap = mapOf(1 to Pair(1, 1), 2 to Pair(0, 1), 3 to Pair(0, 0), 4 to Pair(1, 0))

    fun convertNumtoXY(n: String): Pair<Long, Long> {
        var x = 0L
        var y = 0L
        n.forEachIndexed { index, c ->
            val unit = (boxLine / 2.0.pow(index + 1)).toLong()

            x += pointMap[c.digitToInt()]!!.first * unit
            y += pointMap[c.digitToInt()]!!.second * unit
        }
        return x to y
    }

    fun convertXYtoNum(x: Long, y: Long): String {
        with(StringBuilder()) {
            var cx = x
            var cy = y
            var index = 0
            while (true) {

                val unit = (boxLine / 2.0.pow(index + 1)).toLong()
                if (unit == 0L) break
                val xx = cx / unit
                val yy = cy / unit

                when {
                    xx == 1L && yy == 1L -> append(1)
                    xx == 0L && yy == 1L -> append(2)
                    xx == 0L && yy == 0L -> append(3)
                    xx == 1L && yy == 0L -> append(4)
                }

                cx %= unit
                cy %= unit
                index++
            }
            return this.toString()
        }
    }
}

fun main() {
    BOJ1891().solve()
}