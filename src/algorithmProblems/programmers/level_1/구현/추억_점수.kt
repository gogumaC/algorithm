package programmers.level_1.구현

class 추억_점수 {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val answer: IntArray = IntArray(photo.size)

        val m = name.mapIndexed { idx, v -> v to yearning[idx] }.toMap()
        for (i in photo.indices) {
            val p = photo[i]
            var sum = 0
            for (j in p) {
                sum += m[j] ?: 0
            }
            answer[i] = sum

        }
        return answer
    }
}