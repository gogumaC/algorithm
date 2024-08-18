package programmers.level_1.투포인터

class 연속된_부분_수열의_합 {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf(0, 0)
        val dp = IntArray(sequence.size + 1)
        var ml = 1000010
        for (i in 1..sequence.size) {
            dp[i] = dp[i - 1] + sequence[i - 1]
        }

        var si = 1
        var ei = 1
        var sum = 0
        while (ei >= si && ei <= sequence.size) {
            sum = dp[ei] - dp[si - 1]
            if (sum > k) {
                si++
            } else if (sum < k) {
                ei++
            } else {
                if (ml > ei - si) {
                    answer[0] = si - 1
                    answer[1] = ei - 1
                    ml = ei - si
                }
                si++
                ei++
            }
        }

        return answer
    }
}