package solved.ac.class_4

import java.util.*

class BOJ1918() {

    val priority = mapOf(
        '*' to 1,
        '/' to 1,
        '+' to 2,
        '-' to 2,
        '(' to Int.MAX_VALUE,
        ')' to Int.MAX_VALUE
    )

    fun solve() {

        val input = readln()

        println(toPostfix(input))
    }

    private fun toPostfix(s: String) = StringBuilder().apply {

        val os = Stack<Char>()

        s.forEach {
            if (!priority.containsKey(it)) {
                append(it)
            } else {
                if (it == '(') os.push(it)
                else if (it == ')') {
                    while (os.isNotEmpty()) {
                        val op = os.pop()
                        if (op == '(') break
                        append(op)
                    }
                } else if (os.isNotEmpty() && priority[it]!! >= priority[os.peek()]!!) {
                    while (os.isNotEmpty() && priority[it]!! >= priority[os.peek()]!!) {
                        append(os.pop())
                    }
                    os.push(it)
                } else {
                    os.push(it)
                }
            }
        }

        while (os.isNotEmpty()) {
            append(os.pop())
        }
    }
}

fun main() {
    BOJ1918().solve()
}