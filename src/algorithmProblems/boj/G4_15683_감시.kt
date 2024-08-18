package boj

import kotlin.math.min

class BOJ15683() {
    lateinit var map: Array<IntArray>
    var cctvs = mutableListOf<CCTV>()

    class CCTV(val x: Int, val y: Int, val type: Int) {

        val direction: IntArray

        init {
            direction = when (type) {
                1 -> intArrayOf(RIGHT)
                2 -> intArrayOf(LEFT, RIGHT)
                3 -> intArrayOf(UP, RIGHT)
                4 -> intArrayOf(LEFT, UP, RIGHT)
                5 -> intArrayOf(UP, RIGHT, DOWN, LEFT)
                else -> intArrayOf()
            }
        }

        companion object {
            val UP = 0
            val RIGHT = 1
            val DOWN = 2
            val LEFT = 3
        }

        var rotate: Int = 0

        fun rotate() {
            for (i in 0 until direction.size) {
                direction[i] = (direction[i] + 1) % 4
            }
        }


        fun getRotateCount(): Int {
            return when (type) {
                1, 3, 4 -> 4
                2 -> 2
                else -> 1
            }
        }

    }

    fun solve() {
        val (n, m) = readln().split(" ").map { it.toInt() }
        map = Array(n) { intArrayOf() }
        for (i in 0 until n) {
            map[i] = readln().split(" ").map { it.toInt() }.toIntArray()
        }


        for (i in 0 until n) {
            for (j in 0 until m) {
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvs.add(CCTV(i, j, map[i][j]))
                }
            }
        }

        recursive(0)

        print(min)

    }

    var min = Int.MAX_VALUE

    fun recursive(index: Int) {
        if (index == cctvs.size) {
            min = min(min, checkBlindCount())
            return
        }
        val target = cctvs[index]

        for (i in 0 until target.getRotateCount()) {
            target.rotate()
            recursive(index + 1)
        }
    }

    fun checkBlindCount(): Int {

        var count = 0
        cctvs.forEach { cctv ->
            cctv.direction.forEach {
                fillMap(cctv, it)
            }
        }

        for (i in 0 until map.size) {
            for (j in 0 until map[0].size) {
                if (map[i][j] == 0) count++
                if (map[i][j] < 0) map[i][j] = 0
            }
        }
        return count
    }

    val directionMap = mapOf(
        CCTV.UP to intArrayOf(0, 1),
        CCTV.DOWN to intArrayOf(0, -1),
        CCTV.RIGHT to intArrayOf(1, 0),
        CCTV.LEFT to intArrayOf(-1, 0)
    )

    fun fillMap(cctv: CCTV, direction: Int) {
        var index = 1

        while (true) {
            val x = cctv.x + directionMap[direction]!![0] * index
            val y = cctv.y + directionMap[direction]!![1] * index
            if (x in 0 until map.size && y in 0 until map[0].size) {
                if (map[x][y] == 6) break
                if (map[x][y] == 0) {
                    map[x][y] = -1
                }
                index++

            } else break
        }
    }
}

fun main() {
    BOJ15683().solve()
}