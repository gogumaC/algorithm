package programmers.level_1.구현

class 달리기_경주 {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {

        val p2r = players.mapIndexed { idx: Int, v: String -> v to idx }.toMap().toMutableMap()
        val a = players.toMutableList()
        callings.forEach {
            val ci = p2r[it]!!

            p2r[it] = p2r[it]!! - 1
            p2r[a[ci - 1]] = p2r[a[ci - 1]]!! + 1

            a[ci] = a[ci - 1]
            a[ci - 1] = it
        }
        return a.toTypedArray()
    }
}