package programmers.level_1.재귀

class LV2_하노이의_탑 {
    fun solution(n: Int): Array<IntArray> {
        val res = h(n, 1, 3)
        return res.toTypedArray()
    }

    fun h(num: Int, st: Int, des: Int): MutableList<IntArray> {
        if (num == 1) {
            return mutableListOf(intArrayOf(st, des))
        }
        var d = 0
        for (i in 1..3) {
            if (i == st || i == des) continue
            d = i
            break
        }

        return h(num - 1, st, d).apply {
            add(intArrayOf(st, des))
            addAll(h(num - 1, d, des))
        }
    }
}