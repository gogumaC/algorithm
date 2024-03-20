package programmers.level_1.구현


import kotlin.math.max
import kotlin.math.min

class LV1_공원_산책 {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var x = 0
        var y = 0

        for (i in 0 until park.size) {
            if (park[i].contains("S")) {
                y = i
                x = park[i].indexOf("S")
                break
            }
        }

        loop@ for (r in routes) {
            val s = r.split(" ")
            val op = s[0]
            val d = s[1].toInt()
            var tx = x
            var ty = y

            when (op) {
                "E" -> {
                    tx += d
                }

                "W" -> {
                    tx -= d
                }

                "N" -> {
                    ty -= d
                }

                "S" -> {
                    ty += d
                }
            }

            if (tx !in 0 until park[0].length || ty !in 0 until park.size) continue
            val xr = min(x, tx)..max(x, tx)
            val yr = min(y, ty)..max(y, ty)
            for (xx in xr) {
                for (yy in yr) {
                    if (park[yy][xx] == 'X') {
                        continue@loop
                    }
                }
            }
            x = tx
            y = ty
        }


        return intArrayOf(y, x)
    }
}