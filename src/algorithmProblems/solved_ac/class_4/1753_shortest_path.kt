package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ1753() {

    val INF = 300001

    fun solve() {

        val br = BufferedReader(InputStreamReader(System.`in`))

        val (V, E) = br.readLine().split(" ").map { it.toInt() }

        val start = br.readLine().toInt()

        val board = mutableMapOf<Int, LinkedList<Pair<Int, Int>>>()

        (0 until E).forEach { _ ->
            val (u, v, w) = br.readLine().split(" ").map { it.toInt() }
            if (!board.containsKey(u)) board[u] = LinkedList()
            board[u]?.add(Pair(v, w))
        }

        dijkstra(start, board, V, E)
    }

    fun dijkstra(start: Int, board: MutableMap<Int, LinkedList<Pair<Int, Int>>>, V: Int, E: Int) {
        val dijkstra = IntArray(V + 1) { INF }
        dijkstra[start] = 0
        val pq = PriorityQueue { o1: Int, o2: Int ->
            dijkstra[o1] - dijkstra[o2]
        }

        pq.add(start)
        while (pq.isNotEmpty()) {

            val current = pq.remove()

            if (!board.containsKey(current)) continue
            for (path in board[current]!!) {
                val node = path.first
                val weight = path.second
                if (dijkstra[current] + weight < dijkstra[node]) {
                    dijkstra[node] = dijkstra[current] + weight
                    pq.add(node)
                }
            }
        }

        with(StringBuilder()) {
            for (i in 1..V) {
                val res = dijkstra[i]
                if (res == INF) append("INF")
                else append(res)
                append("\n")
            }
            println(this)
        }
    }
}

fun main() {
    BOJ1753().solve()
}