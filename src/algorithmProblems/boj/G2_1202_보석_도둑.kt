package boj

import java.util.*

class BOJ1202() {

    data class Jewel(var weight: Int, var value: Int)

    var N = 0
    var K = 0
    fun solve() {

        with(StringTokenizer(readln())) {
            N = nextToken().toInt()
            K = nextToken().toInt()
        }

        val jewels = mutableListOf<Jewel>()

        for (i in 0 until N) {
            val st = StringTokenizer(readln())
            val jewel = Jewel(st.nextToken().toInt(), st.nextToken().toInt())
            jewels.add(jewel)
        }

        val bagWeight = IntArray(K)
        var sum = 0L
        for (i in 0 until K) {
            bagWeight[i] = readln().toInt()
        }


        bagWeight.sort()
        jewels.sortBy { it.weight }


        val pq = PriorityQueue<Int>(reverseOrder())
        var index = 0
        for (i in 0 until K) {

            val w = bagWeight[i]
            while (index < N && w >= jewels[index].weight) {
                pq.add(jewels[index].value)
                index++
            }

            if (pq.isNotEmpty()) sum += pq.remove()
        }

        println(sum)
    }
}

fun main() {
    BOJ1202().solve()
}