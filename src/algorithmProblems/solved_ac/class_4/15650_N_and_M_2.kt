package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    //back tracking
    dfsFor15650(mutableListOf(), n, m)
}

fun dfsFor15650(path: MutableList<Int>, n: Int, m: Int) {

    if (path.size == m) {
        println(path.joinToString(" "))
        return
    }

    val start = if (path.isNotEmpty()) path.last() + 1 else 1

    for (i in start..n) {
        path.add(i)
        dfsFor15650(path, n, m)
        path.remove(i)
    }
}