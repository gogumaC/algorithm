package boj

import java.util.*
import kotlin.math.abs

class BOJ2473() {
    fun solve() {
        val N = readln().toInt()
        val liquids = LongArray(N)
        val st = StringTokenizer(readln())
        val ans = LongArray(3)
        for (i in 0 until N) {
            liquids[i] = st.nextToken().toLong()
        }

        liquids.sort()
        var min = Long.MAX_VALUE
        for (i in 0 until N - 2) {
            var end = N - 1
            var start = i + 1
            while (start < end && end > i) {
                val sum = liquids[i] + liquids[start] + liquids[end]

                val gap = abs(sum)
                if (gap < min) {
                    min = gap
                    ans[0] = liquids[i]
                    ans[1] = liquids[start]
                    ans[2] = liquids[end]
                }

                if (sum < 0) {
                    start++
                } else {
                    end--
                }
            }
        }

        StringBuilder().apply {
            ans.forEach {
                append(it)
                append(" ")
            }
            print(this)
        }
    }
}

fun main() {
    BOJ2473().solve()
}