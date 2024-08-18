package solved.ac.class_2

fun main() {
    BOJ15829().solve()
}

class BOJ15829 {

    val M = 1234567891
    val R = 31
    fun solve() {

        val l = readln().toInt()
        val input = readln()

        println(hash(l, input))
    }

    fun hash(l: Int, input: String): Long {
        var hash = 0L
        var r = 1L
        for (i in 0 until l) {
            val a = input[i] - 'a' + 1
            hash = (hash + a * r) % M
            r = (r * R) % M
        }
        return hash
    }
}