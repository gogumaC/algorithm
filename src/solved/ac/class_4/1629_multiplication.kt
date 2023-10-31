package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader

//ref : https://st-lab.tistory.com/237

class BOJ1629() {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (a, b, c) = br.readLine().split(" ").map { it.toLong() }
        println(pow(a, b, c))
    }

    fun pow(a: Long, exp: Long, mod: Long): Long {
        if (exp == 0L) return 1
        if (exp == 1L) return a % mod

        val temp = pow(a, exp / 2, mod)

        if (exp % 2 == 1L) {
            return (temp * temp % mod) * a % mod
        }
        return temp * temp % mod
    }
}

fun main() {
    BOJ1629().solve()
}



