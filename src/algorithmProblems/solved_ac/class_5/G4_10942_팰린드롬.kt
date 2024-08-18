package solved.ac.class_5

class BOJ10942() {
    var N = 0
    lateinit var p: IntArray
    val sb = StringBuilder()
    lateinit var dp: Array<BooleanArray>
    fun solve() {
        N = readln().toInt()
        p = readln().split(" ").map { it.toInt() }.toIntArray()
        dp = Array(N) { BooleanArray(N) }
        val M = readln().toInt()

        dp()

        for (i in 0 until M) {
            val (start, end) = readln().split(" ").map { it.toInt() }
            //sb.append(checkPalindrome(start, end))
            sb.append(if (dp[start - 1][end - 1]) 1 else 0)
            sb.append("\n")
        }

        println(sb)

    }

    fun checkPalindrome(start: Int, end: Int): Int {
        var low = start - 1
        var high = end - 1
        while (low <= high) {
            if (p[low] == p[high]) {
                low++
                high--
            } else {
                return 0
            }
        }
        return 1
    }

    fun dp() {

        for (i in 0 until N) {
            dp[i][i] = true
        }

        for (i in 0 until N - 1) {
            dp[i][i + 1] = (p[i] == p[i + 1])
        }

        for (mid in 1 until N - 1) {

            var start = mid - 1
            var end = mid + 1

            while (start >= 0 && end < N) {
                dp[start][end] = (dp[start + 1][end - 1] && (p[start] == p[end]))
                start--
                end++
            }
        }

        for (mid in 1 until N - 2) {

            var start = mid - 1
            var end = mid + 2

            while (start >= 0 && end < N) {
                dp[start][end] = (dp[start + 1][end - 1] && (p[start] == p[end]))
                start--
                end++
            }
        }
    }
}

fun main() {
    BOJ10942().solve()
}