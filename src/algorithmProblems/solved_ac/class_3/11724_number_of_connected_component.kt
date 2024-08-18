package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val adjacencyMatrix = Array(n + 1) { Array(n + 1) { false } }

    for (i in 0 until m) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        adjacencyMatrix[u][v] = true
        adjacencyMatrix[v][u] = true
    }

    println(findConnectedComponentByDfs(n, adjacencyMatrix))
}

fun findConnectedComponentByDfs(n: Int, adjacencymatrix: Array<Array<Boolean>>): Int {

    var count = 0
    val mark = Array(n + 1) { false }

    for (root in 1..n) {
        if (!mark[root]) {
            count++

            //dfs
            var current = root
            val stack = mutableListOf<Int>()
            stack.add(current)
            label@ while (stack.isNotEmpty()) {
                current = stack.last()
                stack.removeLast()
                mark[current] = true
                for (i in 1..n) {
                    if (adjacencymatrix[current][i] && !mark[i]) {
                        stack.add(i)
                    }
                }
            }
        }
    }

    val unitCount = max(0, n - mark.filter { true }.size)
    return count + unitCount
}