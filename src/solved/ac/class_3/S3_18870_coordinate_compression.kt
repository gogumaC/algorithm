package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }
    val sortedList = list.toSortedSet().toList()

    val resultMap = mutableMapOf<Int, Int>()
    sortedList.forEachIndexed { index, i ->
        resultMap[i] = index
    }

    with(StringBuilder()) {
        list.forEach {
            append(resultMap[it])
            append(" ")
        }
        println(this)
    }
}

