package boj

class BOJ1915() {
    fun solve() {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val map = Array(n + 1) { IntArray(m + 1) }
        var max = 0

        for (i in 1..n) {
            val input = readln()
            for (j in 1..m) {
                map[i][j] = input[j - 1].digitToInt()
                if (map[i][j] == 1 && max != 1) max = 1
            }
        }

        for (i in 1..n) {
            for (j in 1..m) {
                if (map[i][j] == 0) continue
                map[i][j] = minOf(map[i - 1][j - 1], map[i - 1][j], map[i][j - 1]) + 1
                if (map[i][j] > max) max = map[i][j]
            }
        }

        println(max * max)
    }
}

fun main() {
    BOJ1915().solve()
}