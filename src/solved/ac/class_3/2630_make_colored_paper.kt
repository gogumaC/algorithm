package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val stringBuilder = StringBuilder()

    val n = br.readLine().toInt()

    val board = Array(n) { Array(n) { 0 } }

    for (i in 0 until n) {
        board[i] = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    }

    var blueCount = 0
    var whiteCount = 0

    var current = 0
    var currentN = n
    label@ while (currentN > 0) {
        val blockCount = n / currentN
        val x = (current * currentN) % n
        val y = currentN * (current / blockCount)
        for (i in x until x + currentN) {
            for (j in y until y + currentN) {
                if (board[i][j] == 3 || board[i][j] != board[x][y]) {
                    current++
                    if (current == blockCount * blockCount) {
                        currentN /= 2
                        current = 0
                    }
                    continue@label
                }
                if (i == x + currentN - 1 && j == y + currentN - 1) {
                    when (board[x][y]) {
                        0 -> whiteCount++
                        1 -> blueCount++
                    }
                    for (mi in x until x + currentN) {
                        for (mj in y until y + currentN) {
                            board[mi][mj] = 3
                        }
                    }
                }
            }
        }
        if (current == blockCount * blockCount) {
            currentN /= 2
            current = 0
        }
    }
    stringBuilder.apply {
        append(whiteCount)
        append("\n")
        append(blueCount)
        println(this)
    }
}

fun printBoard(board: Array<Array<Int>>) {
    with(StringBuilder()) {
        for (i in 0 until board.size) {
            for (j in 0 until board[0].size) {
                append(board[i][j])
                append(" ")
                if (j == board[0].size - 1) append("\n")
            }
        }
        println(this)
    }

}