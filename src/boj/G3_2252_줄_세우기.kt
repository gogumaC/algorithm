package boj
//mutableLIst->arrayList : 4976ms->4824ms
//enter뺴고,degree 사용 : 4824ms->620ms
//append한번으로 변경 : 620ms->668ms로 증가
//front back을 StringTokenizer로 읽음 : 668ms->544ms로 감소
//N,M도 StringTokenizer로 변경 : 544ms-> 484ms로 변경
//아마 split이 줄어서 그럴까


import java.util.*

class BOJ2252() {
    fun solve() {
        val input = StringTokenizer(readln())
        val N = input.nextToken().toInt()
        val M = input.nextToken().toInt()
        val q = LinkedList<Int>()
        val out = Array(N + 1) { ArrayList<Int>() }
        val degree = IntArray(N + 1)
        for (i in 0 until M) {
            val st = StringTokenizer(readln())
            val front = st.nextToken().toInt()
            val back = st.nextToken().toInt()
            degree[back]++
            out[front].add(back)
        }

        for (i in 1..N) {
            if (degree[i] == 0) q.add(i)
        }

        val sb = StringBuilder()
        while (q.isNotEmpty()) {
            val current = q.remove()//poll()
            sb.append(current)
            sb.append(" ")
            for (i in out[current]) {
                degree[i]--
                if (degree[i] == 0) q.add(i)
            }
        }
        print(sb)

    }
}

fun main() {
    BOJ2252().solve()
}