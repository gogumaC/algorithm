package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ1874() {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val sb = StringBuilder()

        val n = br.readLine().toInt()

        val seq = IntArray(n) { 0 }
        for (i in 0 until n) {
            seq[i] = br.readLine().toInt()
        }

        val stack = Stack<Int>()
        var pushCount = 1
        stack.add(1)
        sb.append("+\n")
        var seqIndex = 0
        while (seqIndex != n) {
            val element = seq[seqIndex]
            val last = if (stack.isNotEmpty()) stack.last() else 0
            if (last == element) {
                sb.append("-\n")
                seqIndex++
                stack.pop()
            } else if (last < element) {
                sb.append("+\n")
                stack.add(++pushCount)
            } else {
                println("NO")
                return
            }
        }
        println(sb)
    }
}

fun main() {
    BOJ1874().solve()
}