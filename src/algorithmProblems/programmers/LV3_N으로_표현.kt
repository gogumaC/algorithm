class Solution {
    fun solution(N: Int, number: Int): Int {
        var answer = 0
        val dp=Array(9){mutableSetOf<Int>()}
        dp[1].add(N)
        if(N==number) return 1
        for(i in 2 .. 8){
            for(j in 1 until i){
                val left=dp[i-j]
                val right=dp[j]
                for(l in left){
                    for(r in right){
                        val plus=l+r
                        val minus=l-r
                        val time=l*r
                        val div=if(r!=0) l/r else -1
                        dp[i].apply{
                            add(plus)
                            add(minus)
                            add(time)
                            if(r!=0) add(div)
                        }
                    }
                }
                dp[i].add(("$N".repeat(i)).toInt())
                if(dp[i].contains(number)){
                    return i
                }
            }
        }
        
        
        return -1
    }
}