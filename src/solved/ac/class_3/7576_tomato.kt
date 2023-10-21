package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

/**
 * 처음에는 큐를 mutableList로 만들어서 시간 초과가 났다.
 * 이유는 코틀린에서 mtuableList는 ArrayList기반이라서 맨 앞의 원소를 pop해야하는
 * 큐의 특성상 O(n)의 시간 복잡도가 생기게 되므로 적절치 않다.
 * (앞에 원소를 뺴고 뒤 원소를 모두 하나씩 당겨야하므로)
 * 따라서 큐를 만들고 싶다면 LinkedList를 활용하여 first()작업속도를 감소시켜야한다.O(1)
 * 스택의 경우에는 mutableLIst가 더 적절한 선택이다. 작업속도는 링크드 리스트도 비슷하지만 자료구조 특성상
 * 링크드 리스트는 prev,next를 저장하는 포인터가 필요하므로 메모리 상 오버헤드가 발생한다.
 * **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val board = Array(m) { Array(n) { 0 } }
    val queue = LinkedList<Pair<Int, Int>>()

    var dateCount = 0
    var isFilled = true

    val offsetX = arrayOf(-1, 0, 1, 0)
    val offsetY = arrayOf(0, -1, 0, 1)
    for (i in 0 until m) {
        br.readLine().split(" ").forEachIndexed { j, s ->
            board[i][j] = s.toInt()
            when (board[i][j]) {
                0 -> isFilled = false
                1 -> queue.add(Pair(i, j))
            }
        }
    }
    if (isFilled) {
        println(0)
        return
    }

    while (queue.isNotEmpty()) {
        val current = queue.first()
        queue.removeFirst()
        val currentX = current.first
        val currentY = current.second

        for (i in 0 until 4) {
            val nextX = currentX + offsetX[i]
            val nextY = currentY + offsetY[i]

            if (nextX in 0 until m && nextY in 0 until n) {
                if (board[nextX][nextY] == 0 && board[nextX][nextY] != -1) {
                    board[nextX][nextY] = board[currentX][currentY] + 1
                    dateCount = max(dateCount, board[nextX][nextY])
                    queue.add(Pair(nextX, nextY))
                }
            }
        }
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (board[i][j] == 0) {
                println(-1)
                return
            }
        }
    }
    println(dateCount - 1)
}

fun printFor7576(board: Array<Array<Int>>) {
    with(StringBuilder()) {
        for (i in 0 until board.size) {
            for (j in 0 until board[0].size) {
                append(board[i][j])
                if (j < board[0].size) append(" ")
            }
            append("\n")
        }
        println(this)
    }
}