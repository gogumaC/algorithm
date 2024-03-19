package programmers.level_1.구현

import java.util.*

class 과제_진행하기 {

    data class Plan(val name: String, var start: Int, var time: Int)

    fun solution(plans: Array<Array<String>>): Array<String> {
        var answer = mutableListOf<String>()
        val a = plans.map {
            val s = it[1].split(":")
            val m = s[0].toInt() * 60 + s[1].toInt()

            Plan(it[0], m, it[2].toInt())
        }.sortedBy { it.start }

        val s = Stack<Plan>()
        var t = 0

        for (i in 0 until a.size) {
            val n = a[i]

            while (true) {
                if (s.isEmpty()) {
                    break
                }
                if (t + s.last().time > n.start) {
                    s.last().time = t + s.last().time - n.start
                    break
                } else {
                    val done = s.pop()
                    answer.add(done.name)
                    t += done.time
                }
            }
            s.add(n)
            t = n.start

        }

        while (s.isNotEmpty()) {
            answer.add(s.pop().name)
        }

        return answer.toTypedArray()
    }
}