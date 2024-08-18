package boj

class BOJ1759() {
    var L = 0
    var C = 0
    lateinit var letters: List<String>
    val sb = StringBuilder()
    fun solve() {
        val (l, c) = readln().split(" ").map { it.toInt() }
        L = l
        C = c
        letters = readln().split(" ").sorted()
        bf(-1, 0, StringBuilder())
        println(sb)
    }


    fun bf(current: Int, depth: Int, path: StringBuilder) {
        if (depth == L && isValid(path)) {
            sb.append(path)
            sb.append("\n")
            return
        }
        for (i in current + 1 until C) {
            path.append(letters[i])
            bf(i, depth + 1, path)
            path.deleteCharAt(path.length - 1)
        }
    }

    fun isValid(s: StringBuilder): Boolean {
        var vowelCount = 0
        var varCount = 0
        for (c in s) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowelCount++
            else varCount++
        }
        return (vowelCount >= 1 && varCount >= 2)
    }
}

fun main() {
    BOJ1759().solve()
}