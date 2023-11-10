package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ1967() {

    data class Edge(val node: Int, val weight: Int)

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()

        val tree = Array(n + 1) { mutableListOf<Edge>() }

        for (i in 1 until n) {
            val (parent, child, weight) = br.readLine().split(" ").map { it.toInt() }

            tree[parent].add(Edge(child, weight))
            tree[child].add(Edge(parent, weight))
        }

        val res1 = dfs(1, n, tree)
        val res2 = dfs(res1.first, n, tree)

        println(res2.second)

    }

    fun dfs(start: Int, n: Int, tree: Array<MutableList<Edge>>): Pair<Int, Int> {
        val stack = Stack<Pair<Int, Int>>()
        stack.add(Pair(start, 0))
        val mark = BooleanArray(n + 1) { false }

        var maxDist = 0
        var farthestNode = start

        while (stack.isNotEmpty()) {
            val (current, distance) = stack.pop()

            if (mark[current]) continue
            mark[current] = true

            if (distance > maxDist) {
                maxDist = distance
                farthestNode = current
            }

            for (edge in tree[current]) {
                if (mark[edge.node]) continue
                stack.push(Pair(edge.node, distance + edge.weight))
            }
        }

        return Pair(farthestNode, maxDist)
    }
}

fun main() {
    BOJ1967().solve()
}