package programmers.level_1.그래프

class 도넛과_막대_그래프 {
    fun solution(edges: Array<IntArray>): IntArray {
        val ind = IntArray(1000010)
        val outd = IntArray(1000010)
        var start = 0
        var answer: IntArray = intArrayOf(0, 0, 0, 0)
        val g = Array(1000010) { mutableListOf<Int>() }
        for (i in 0 until edges.size) {
            val a = edges[i][0]
            val b = edges[i][1]
            g[a].add(b)
            ind[b]++
            outd[a]++
        }
        for (i in 1 until ind.size) {
            if (ind[i] == 0 && outd[i] >= 2) {
                start = i
                answer[0] = i
                break
            }
        }

        println(ind.slice(0..20).toList())
        println(outd.slice(0..20).toList())
        for (i in 1 until ind.size) {
            if (i == start) continue
            if (ind[i] >= 1 && outd[i] == 0) answer[2]++
            else if (ind[i] >= 2 && outd[i] == 2) answer[3]++
        }
        answer[1] = g[start].size - answer[2] - answer[3]
        return answer
    }
}