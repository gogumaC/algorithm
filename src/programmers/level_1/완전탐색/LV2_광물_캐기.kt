package programmers.level_1.완전탐색

import kotlin.math.min

class LV2_광물_캐기 {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer: Int = 0

        if (picks[0] > 0) dfs(minerals, 0, picks[0] - 1, picks[1], picks[2])
        if (picks[1] > 0) dfs(minerals, 1, picks[0], picks[1] - 1, picks[2])
        if (picks[2] > 0) dfs(minerals, 2, picks[0], picks[1], picks[2] - 1)
        return min
    }

    val pt = arrayOf(intArrayOf(1, 1, 1), intArrayOf(5, 1, 1), intArrayOf(25, 5, 1))

    var min = Int.MAX_VALUE
    fun dfs(minerals: Array<String>, cp: Int, dP: Int, iP: Int, sP: Int, depth: Int = 0, t: Int = 0) {

        if (t >= min) return

        if (depth >= minerals.size) {

            min = min(min, t)
            return
        }
        var tt = t
        val p = pt[cp]

        for (i in depth until depth + 5) {

            if (i >= minerals.size) break
            when (minerals[i]) {
                "diamond" -> {
                    tt += p[0]
                }

                "iron" -> {
                    tt += p[1]
                }

                "stone" -> {
                    tt += p[2]
                }

            }
        }
        if (dP == 0 && iP == 0 && sP == 0) {
            min = min(min, tt)
            return
        }
        if (dP > 0) dfs(minerals, 0, dP - 1, iP, sP, depth + 5, tt)
        if (iP > 0) dfs(minerals, 1, dP, iP - 1, sP, depth + 5, tt)
        if (sP > 0) dfs(minerals, 2, dP, iP, sP - 1, depth + 5, tt)

    }
}