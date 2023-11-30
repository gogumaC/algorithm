package solved.ac.class_4

import java.util.*

class BOJ1167() {

    var V: Int = 0
    lateinit var edges: Array<MutableList<Pair<Int, Int>>>
    fun solve() {

        V = readln().toInt()

        edges = Array(V + 1) { mutableListOf() }
        for (i in 0 until V) {
            val input = readln().split(" ").map { it.toInt() }.filter { it > 0 }
            val start = input[0]

            for (j in 1 until input.size step 2) {
                edges[start].add(Pair(input[j], input[j + 1]))
            }
        }

        val n1 = dfs(1).first
        val dist = dfs(n1).second

        println(dist)
    }

    fun dfs(start: Int): Pair<Int, Int> {

        val stack = Stack<Int>()
        stack.push(start)

        val dist = IntArray(V + 1)

        while (stack.isNotEmpty()) {
            val current = stack.pop()

            for ((u, w) in edges[current]) {
                if (dist[u] == 0 && u != start) {
                    stack.push(u)
                    dist[u] = dist[current] + w
                }
            }
        }

        val sort = dist.withIndex().sortedByDescending { it.value }

        return Pair(sort.first().index, sort.first().value)

    }
}

fun main() {
    BOJ1167().solve()
}