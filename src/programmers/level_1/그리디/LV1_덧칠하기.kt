package programmers.level_1.그리디

class LV1_덧칠하기 {
    fun solution(n: Int, m: Int, section: IntArray): Int {

        var pi = 0
        var c = 0
        for (i in section) {
            if (i <= pi) continue
            c++
            pi = i + m - 1

        }
        return c
    }
}