package boj

import kotlin.math.pow
import kotlin.math.sqrt

class BOJ11664() {
    fun solve() {
        val input = readln().split(" ").map { it.toDouble() }
        val a = input.slice(0..2)
        val b = input.slice(3..5)
        val c = input.slice(6..8).toDoubleArray()

        val u = doubleArrayOf(b[0] - a[0], b[1] - a[1], b[2] - a[2])

        var start = a.toDoubleArray()
        var end = b.toDoubleArray()

        while (true) {

            val mid = DoubleArray(3) { start[it] + (end[it] - start[it]) / 2 }
            //val mid1 = DoubleArray(3) { start[it] + (end[it] - start[it]) / 3 }
            //val mid2 = DoubleArray(3) { end[it] - (end[it] - start[it]) / 3 }
            val lenSC = calcDist(start, c)
            val lenEC = calcDist(end, c)
            val lenSE = calcDist(start, end)
            if (lenSE <= 10.0.pow(-6)) {
                println(String.format("%.10f", lenSC))
                return
            } else if (lenSC < lenEC) {
                end = mid
            } else {
                start = mid
            }
        }
    }

    fun calcDist(p1: DoubleArray, p2: DoubleArray): Double {
        val x = p2[0] - p1[0]
        val y = p2[1] - p1[1]
        val z = p2[2] - p1[2]
        return sqrt(x.pow(2) + y.pow(2) + z.pow(2))
    }
}

fun main() {
    BOJ11664().solve()
}