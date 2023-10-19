package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 1. end 기준 정렬
 * 2. end가 같다면 start기준 정렬
 *  (이때 start기준 정렬을 하지 않는 다면 반례
 *  3
 * 4 4
 * 3 4
 * 2 4
 * 답은 2 지만 start기준 정렬이 되어있지 않으면 1로 나온다.)
 * **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val meetings = Array<Pair<Int, Int>?>(n) { null }
    for (i in 0 until n) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        meetings[i] = Pair(start, end)
    }

    val comparator = Comparator { o1: Pair<Int, Int>?, o2: Pair<Int, Int>? ->
        if (o1 != null && o2 != null) {
            if (o1.second != o2.second)
                o1.second - o2.second
            else o1.first - o2.first
        } else 0
    }

    val sortedList = meetings.sortedWith(comparator)
    var count = 0
    var end = 0

    for (i in 0 until n) {
        val current = sortedList[i] ?: Pair(0, 0)
        if (current.first >= end) {
            end = current.second
            count++
        }
    }

    println(count)
}