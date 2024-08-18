package boj

import kotlin.math.pow
import kotlin.math.sqrt

class BOJ1456() {


    fun solve() {
        val (a, b) = readln().split(" ").map { it.toLong() }

        val MAX = sqrt(b.toDouble()).toInt()
        val isPrime = BooleanArray(MAX + 1) { true }
        var count = 0
        isPrime[0] = false
        isPrime[1] = false

        for (i in 2..MAX / 2) {
            if (!isPrime[i]) continue
            var mul = 2
            while (true) {
                isPrime[i * mul] = false
                mul++
                if (i * mul > MAX) break
            }
        }

        for (i in 2..MAX) {
            if (!isPrime[i]) continue
            var exp = 2
            while (true) {
                val num = i.toDouble().pow(exp)
                if (num >= a && num <= b) count++
                else if (num > b) break
                exp++
            }
        }

        println(count)
    }
}

fun main() {
    BOJ1456().solve()
}