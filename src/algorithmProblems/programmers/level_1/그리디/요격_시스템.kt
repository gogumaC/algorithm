package programmers.level_1.그리디

class 요격_시스템 {
    fun solution(targets: Array<IntArray>): Int {
        val a = targets.sortedBy { it[1] }
        var count = 0
        var x = 0
        for (i in a.indices) {
            val s = a[i][0]
            val e = a[i][1]
            if (x in s + 1 until e || x == e) continue
            count++
            x = e
        }
        var answer: Int = count
        return answer
    }
}