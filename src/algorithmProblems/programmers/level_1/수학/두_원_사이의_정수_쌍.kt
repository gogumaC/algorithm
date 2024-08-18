package programmers.level_1.수학

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

class 두_원_사이의_정수_쌍 {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0
        val r22 = r2.toLong() * r2.toLong()
        val r11 = r1.toLong() * r1.toLong()

        for (x in 1..r2) {
            val biy = floor(sqrt((r22 - x.toLong() * x).toDouble())).toLong()
            val sy = if (x >= r1) 0 else ceil(sqrt((r11 - x.toLong() * x).toDouble())).toLong()
            answer += biy - sy + 1
        }

        return answer * 4
    }
}