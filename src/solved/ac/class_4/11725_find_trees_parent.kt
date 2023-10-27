package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val linkedList = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val (n1, n2) = br.readLine().split(" ").map { it.toInt() }
        linkedList[n1].add(n2)
        linkedList[n2].add(n1)
    }

    dfsFor11725(n, linkedList)
}

fun dfsFor11725(n: Int, linkedList: Array<MutableList<Int>>) {

    val mark = Array(n + 1) { false }
    val stack = Stack<Int>()
    val parent = Array(n + 1) { 0 }

    stack.add(1)

    while (stack.isNotEmpty()) {
        val current = stack.pop()
        mark[current] = true
        for (child in linkedList[current]) {
            if (parent[child] == 0) {
                parent[child] = current
                stack.push(child)
            }
        }
    }

    with(StringBuilder()) {
        for (i in 2..n) {
            append(parent[i])
            append("\n")
        }
        println(this)
    }
}