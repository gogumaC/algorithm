package boj

import java.util.*
import kotlin.math.max

class BOJ12100() {
    var N = 0
    lateinit var map: Array<IntArray>
    var max = 0
    fun solve() {
        N = readln().toInt()

        map = Array(N) { IntArray(N) }

        for (i in 0 until N) {
            val st = StringTokenizer(readln())
            for (j in 0 until N) {
                map[i][j] = st.nextToken().toInt()
                max = max(max, map[i][j])
            }
        }

        bt(0)

        println(max)
    }

    fun bt(depth: Int) {

        if (depth == 5) {
            return
        }

        for (i in 0 until 4) {
            val save = Array(N) { IntArray(N) }
            saveMap(save)
            when (i) {
                0 -> left()
                1 -> right()
                2 -> up()
                3 -> down()
            }
            bt(depth + 1)
            restoreMap(save)
        }

    }

    fun saveMap(save: Array<IntArray>) {
        for (i in 0 until N) {
            for (j in 0 until N) {
                save[i][j] = map[i][j]
            }
        }
    }

    fun restoreMap(save: Array<IntArray>) {
        for (i in 0 until N) {
            for (j in 0 until N) {
                map[i][j] = save[i][j]
            }
        }
    }

    fun left() {
        for (i in 0 until N) {
            val mark = BooleanArray(N)
            for (j in 1 until N) {
                var current = j
                while (true) {
                    if (current - 1 !in 0 until N) break
                    if (map[i][current - 1] == 0) {
                        map[i][current - 1] = map[i][current]
                        map[i][current] = 0
                        current--
                    } else if (map[i][current - 1] == map[i][current] && !mark[current - 1]) {
                        map[i][current - 1] = 2 * map[i][current - 1]
                        map[i][current] = 0
                        mark[current - 1] = true
                        max = max(map[i][current - 1], max)
                        break
                    } else {
                        break
                    }

                }
            }
        }
    }

    fun right() {
        for (i in 0 until N) {
            val mark = BooleanArray(N)
            for (j in N - 2 downTo 0) {
                var current = j
                while (true) {
                    if (current + 1 !in 0 until N) break
                    if (map[i][current + 1] == 0) {
                        map[i][current + 1] = map[i][current]
                        map[i][current] = 0
                        current++
                    } else if (map[i][current + 1] == map[i][current] && !mark[current + 1]) {
                        map[i][current + 1] = 2 * map[i][current + 1]
                        map[i][current] = 0
                        mark[current + 1] = true
                        max = max(map[i][current + 1], max)
                        break
                    } else {
                        break
                    }

                }
            }
        }
    }

    fun up() {
        for (i in 0 until N) {
            val mark = BooleanArray(N)
            for (j in 1 until N) {
                var current = j
                while (true) {
                    if (current - 1 !in 0 until N) break
                    if (map[current - 1][i] == 0) {
                        map[current - 1][i] = map[current][i]
                        map[current][i] = 0
                        current--
                    } else if (map[current - 1][i] == map[current][i] && !mark[current - 1]) {
                        map[current - 1][i] = 2 * map[current - 1][i]
                        map[current][i] = 0
                        mark[current - 1] = true
                        max = max(map[current - 1][i], max)
                        break
                    } else {
                        break
                    }

                }
            }
        }
    }

    fun down() {
        for (i in 0 until N) {
            val mark = BooleanArray(N)
            for (j in N - 2 downTo 0) {
                var current = j
                while (true) {
                    if (current + 1 !in 0 until N) break
                    if (map[current + 1][i] == 0) {
                        map[current + 1][i] = map[current][i]
                        map[current][i] = 0
                        current++
                    } else if (map[current + 1][i] == map[current][i] && !mark[current + 1]) {
                        map[current + 1][i] = 2 * map[current + 1][i]
                        map[current][i] = 0
                        mark[current + 1] = true
                        max = max(map[current + 1][i], max)
                        break
                    } else {
                        break
                    }

                }
            }
        }
    }
}

fun main() {
    BOJ12100().solve()
}
