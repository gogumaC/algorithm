package solved.ac.class_4

/*reference :
* https://shoark7.github.io/programming/algorithm/%ED%94%BC%EB%B3%B4%EB%82%98%EC%B9%98-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EC%9D%84-%ED%95%B4%EA%B2%B0%ED%95%98%EB%8A%94-5%EA%B0%80%EC%A7%80-%EB%B0%A9%EB%B2%95
*
* */
class BOJ11444() {

    val MOD = 1000000007
    val f = mutableMapOf<Long, Long>()

    fun solve() {

        val n = readln().toLong()
        f[0] = 0
        f[1] = 1
        println(fibonacci(n))
    }

    fun fibonacci(n: Long): Long {
        //ref :  https://velog.io/@junttang/BOJ-11444-%ED%94%BC%EB%B3%B4%EB%82%98%EC%B9%98-%EC%88%98-6-%ED%95%B4%EA%B2%B0-%EC%A0%84%EB%9E%B5-C

        if (n == 0L) return 0
        if (n == 1L || n == 2L) return 1
        if (f.containsKey(n)) return f[n]!!
        val res = if (n % 2 == 0L) {
            val m = n / 2
            fibonacci(m) * (fibonacci(m + 1) + fibonacci(m - 1))
        } else {
            val a = (n + 1) / 2
            val b = (n - 1) / 2
            fibonacci(a) * fibonacci(a) + fibonacci(b) * fibonacci(b)
        }
        f[n] = res % MOD
        return f[n]!!
    }
    
}

fun main() {
    BOJ11444().solve()
}