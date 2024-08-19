import kotlin.math.*

class Solution {
    fun solution(a: Int, b: Int, g: IntArray, s: IntArray, w: IntArray, t: IntArray): Long {
        var answer: Long = -1
        
        val n=g.size
        
        var low=0L
        
        var high=((a+b)*2L*(t.maxOrNull()?:1).toLong())
        
        while(low<high){
            val mid=low+(high-low)/2
            
            var total=0L
            var mg=0L
            var ms=0L
            
            for(i in 0 until n){
                val time=t[i]*2.toDouble()
                val count:Long=((mid+t[i])/time).toLong()
                val mines=count*w[i]
                mg+=min(g[i].toLong(),mines)
                ms+=min(s[i].toLong(),mines)
                total+=min(g[i].toLong()+s[i].toLong(),mines)
            }
            
            if(total<a+b || mg<a || ms<b){
                low=mid+1
            }else{
                high=mid
            }            
        }
        return high
    }
}
