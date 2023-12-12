package solved.ac.class_5

class BOJ2239() {
    val N = 9
    val map = Array(N) { intArrayOf() }
    val res = StringBuilder()
    fun solve() {
        for (i in 0 until N) {
            map[i] = readln().map { it.digitToInt() }.toIntArray()
        }
        bt(0, 0)
    }

    fun bt(x: Int, y: Int) {
        if (res.isNotEmpty()) return

        val index = x * N + y

        for (i in index until N * N) {
            val cx = i / N
            val cy = i % N

            if (map[cx][cy] == 0) {
                for (j in 1..9) {
                    map[cx][cy] = j
//                    println("$cx,$cy = $j ~ ${checkValidate(cx, cy)}")
                    if (checkValidate(cx, cy)) bt(cx, cy)
                }
                map[cx][cy] = 0
                break
            }

            if (i == N * N - 1 && res.isEmpty()) printRes()

        }

    }

    fun printRes() {
        with(res) {
            for (i in 0 until N) {
                for (j in 0 until N) {
                    append(map[i][j])
                }
                append("\n")
            }
            println(this)
        }
    }

    fun checkValidate(x: Int, y: Int): Boolean {
        return checkRow(x, y) && checkColumn(x, y) && checkBlock(x, y)
    }

    fun checkColumn(x: Int, y: Int): Boolean {
        for (i in 0 until 9) {
            if (i != y && map[x][y] == map[x][i]) return false
        }
        return true
    }

    fun checkRow(x: Int, y: Int): Boolean {
        for (i in 0 until 9) {
            if (i != x && map[x][y] == map[i][y]) return false
        }
        return true
    }

    fun checkBlock(x: Int, y: Int): Boolean {

        val bx = (x / 3) * 3
        val by = (y / 3) * 3
        for (i in bx until bx + 3) {
            for (j in by until by + 3) {
                if (i == x && j == y) continue
                if (map[x][y] == map[i][j]) return false
            }
        }
        return true
    }


}

fun main() {
    BOJ2239().solve()
}