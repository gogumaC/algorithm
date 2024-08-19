import java.util.*

class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        var left=0L
        var right:Long = (times.maxOrNull()?:0).toLong()*n
        
        //println(bs(1000000000,IntArray(100000){1000000000}))
        
        while(left<=right){
            val mid=left+(right-left)/2
            var checkCount=0L
            for(t in times){
                checkCount+=(mid/t).toLong()
                if(checkCount>=n){
                    right=mid-1
                    break
                }
            }
            if(checkCount<n){
                left=mid+1
            }  
        }
        
        return left
    }
    
}