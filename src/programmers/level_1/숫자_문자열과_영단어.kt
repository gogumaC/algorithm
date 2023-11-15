package programmers.level_1

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var ss = s
        var pair = mapOf<String, Int>(
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9,
            "zero" to 0
        )

        pair.forEach {
            ss = ss.replace(it.key, it.value.toString(), false)
        }
        return ss.toInt()
    }
}