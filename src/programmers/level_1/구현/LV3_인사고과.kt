package programmers.level_1.구현

import java.util.*

class LV3_인사고과 {

    fun solution(scores: Array<IntArray>): Int {
        var answer: Int = 0

        val r = scores.withIndex().sortedWith { o1, o2 ->
            if (o1.value[0] != o2.value[0]) o2.value[0] - o1.value[0]
            else o1.value[1] - o2.value[1]
        }

        var target = scores[0]
        var maxB = 0
        var res = 1

        val s = scores[0][0] + scores[0][1]
        for (i in 0 until r.size) {
            if (r[i].value[0] > target[0] && r[i].value[1] > target[1]) return -1
            if (r[i].value[1] >= maxB) {
                maxB = r[i].value[1]
                val t = r[i].value[0] + r[i].value[1]
                if (t > s) res++
            }
        }

        return res
    }
}