package boj

class BOJ11509() {

    lateinit var balloons: MutableList<Int>
    
    fun solve() {
        val n = readln().toInt()
        balloons = readln().split(" ").map { it.toInt() }.toMutableList()
        val arrows = mutableListOf<Int>()
        for (i in 0 until n) {
            val balloonHeight = balloons[i]
            val arrowIndex = arrows.indexOf(balloonHeight)
            if (arrowIndex >= 0) {
                arrows[arrowIndex]--
            } else {
                arrows.add(balloonHeight - 1)
            }
        }

        print(arrows.size)
    }
}

fun main() {
    BOJ11509().solve()
}