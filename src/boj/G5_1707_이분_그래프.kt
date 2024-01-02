package boj

import java.util.*

class BOJ1707() {

    private lateinit var mark: IntArray
    private val sb = StringBuilder()
    fun solve() {
        val T = readln().toInt()
        for (t in 0 until T) {

            val (V, E) = readln().split(" ").map { it.toInt() }
            mark = IntArray(V + 1)
            val path = Array(V + 1) { ArrayList<Int>() }
            for (i in 0 until E) {
                val (u, v) = readln().split(" ").map { it.toInt() }
                path[u].add(v)
                path[v].add(u)
            }
            var res = true
            for (i in 1..V) {
                if (mark[i] == 0) {
                    if (!bfs(i, path)) {
                        res = false
                        break
                    }
                }
            }

            sb.append(if (res) "YES\n" else "NO\n")
        }
        print(sb)
    }

    fun bfs(start: Int, path: Array<ArrayList<Int>>): Boolean {
        val q = LinkedList<Int>()
        q.add(start)
        mark[start] = 1
        while (q.isNotEmpty()) {
            val current = q.poll()
            val currentMark = mark[current]
            for (i in path[current]) {
                if (mark[i] == 0) {
                    mark[i] = -currentMark
                    q.add(i)
                } else {
                    if (mark[i] != -currentMark) return false
                }
            }
        }
        return true
    }
}

fun main() {
    BOJ1707().solve()
}