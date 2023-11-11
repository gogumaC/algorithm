import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    rec(mutableListOf(), n, 0, m)
    println(sb)
}

fun rec(path: MutableList<Int>, n: Int, depth: Int, m: Int) {
    if (depth == m) {
        sb.append(path.joinToString(separator = " "))
        sb.append("\n")
        return
    }

    val prev = if (path.isEmpty()) 0 else path.last()
    for (i in prev + 1..n) {
        path.add(i)
        rec(path, n, depth + 1, m)
        path.remove(i)
    }
}