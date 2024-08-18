package boj

class BOJ1091() {

    private var n = 0
    private lateinit var p: List<Int>
    private lateinit var s: List<Int>
    private lateinit var deck: IntArray
    private lateinit var original: IntArray
    
    fun solve() {

        n = readln().toInt()
        p = readln().split(" ").map { it.toInt() }
        s = readln().split(" ").map { it.toInt() }
        deck = IntArray(n) { it }
        original = IntArray(n) { it }

        var count = 0

        while (true) {
            if (checkCycle(count)) {
                count = -1
                break
            }
            if (!checkMatch()) {
                shuffle()
                count++
            } else {
                break
            }

        }

        println(count)
    }

    fun shuffle() {
        val res = deck.clone()
        s.forEachIndexed { index, i ->
            res[i] = deck[index]
        }
        deck = res
    }


    fun checkCycle(count: Int): Boolean {
        if (count == 0) return false
        for (i in 0 until n) {
            if (deck[i] != i) return false
        }
        return true
    }

    fun checkMatch(): Boolean {
        for (i in 0 until n) {
            val dealCard = i
            val player = p[i]
            val cardIndex = deck.indexOf(dealCard)
            if (cardIndex % 3 != player) return false
        }
        return true
    }
}

fun main() {
    BOJ1091().solve()
}