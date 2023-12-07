package solved.ac.class_5

import kotlin.math.max
import kotlin.math.min

class BOJ1197() {

    var V = 0
    var E = 0
    lateinit var edges: Array<List<Int>>
    fun solve() {
        val input = readln().split(" ").map { it.toInt() }
        V = input[0]
        E = input[1]

        edges = Array(E) { listOf() }

        for (i in 0 until E) {
            edges[i] = readln().split(" ").map { it.toInt() }
        }

        println(kruskal())

    }

    fun kruskal(): Int {

        edges.sortBy { it[2] }
        val parents = IntArray(V + 1) { it }
        var weight = 0
        edges.forEach {
            val (u, v, w) = it
            if (parents[u] != parents[v]) {
                weight += w
                val parent = min(parents[u], parents[v])
                val child = max(parents[u], parents[v])

                for (i in 1..V) {
                    if (parents[i] == child) parents[i] = parent
                }
            }

        }

        return weight
    }
}

fun main() {

    BOJ1197().solve()
}