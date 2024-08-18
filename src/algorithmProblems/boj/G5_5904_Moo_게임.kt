package boj

class BOJ5904() {

    val moo = "moo"

    fun solve() {
        val n = readln().toInt()

        var i = 0
        var length = 0
        while (true) {
            length = if (i == 0) 3 else length * 2 + i + 3
            if (length >= n) {
                println(getMoo(n - 1, i, length))
                return
            }
            i++
        }
    }

    fun getMoo(n: Int, i: Int, length: Int): Char {
        if (i == 0) return moo[n]
        val prevLength = (length - (i + 3)) / 2
        return if (n in 0 until prevLength) {
            getMoo(n, i - 1, prevLength)
        } else if (n in prevLength until prevLength + i + 3) {
            if (n == prevLength) 'm' else 'o'
        } else {
            val index = n - (prevLength + i + 3)
            getMoo(index, i - 1, prevLength)
        }
    }
}

fun main() {
    BOJ5904().solve()
}