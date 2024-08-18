package programmers.level_1.구현

class 가장_많이_받은_선물 {
    fun solution(f: Array<String>, gifts: Array<String>): Int {
        val m = mutableMapOf<String, Int>()
        f.forEachIndexed { index, string ->
            m.put(string, index)
        }
        val r = Array(f.size) { IntArray(f.size) }
        val p = IntArray(f.size)
        gifts.forEach {
            val input = it.split(" ")
            val a = input[0]
            val b = input[1]
            r[m[a]!!][m[b]!!]++
            p[m[a]!!]++
            p[m[b]!!]--
        }

        val g = IntArray(f.size)
        for (i in 0 until f.size) {
            for (j in i + 1 until f.size) {
                if (r[i][j] != r[j][i]) {
                    if (r[i][j] > r[j][i]) g[i]++
                    else g[j]++

                } else {
                    if (p[i] > p[j]) g[i]++
                    else if (p[i] < p[j]) g[j]++
                }

            }
        }
        var answer: Int = g.sorted().reversed()[0]
        return answer
    }
}