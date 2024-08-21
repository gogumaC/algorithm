import java.util.*
import kotlin.math.*

class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        var answer = 0
        
        val pq=PriorityQueue<IntArray>{o1,o2->
            o1[0]-o2[0]
        }
        val graph=Array(N){IntArray(N){Int.MAX_VALUE}}
        
        for(r in road){
            val a=r[0]-1
            val b=r[1]-1
            val w=r[2]
            graph[a][b]=min(graph[a][b],w)
            graph[b][a]=graph[a][b]
        }
        val dp=IntArray(N){Int.MAX_VALUE}
        
        val visited=BooleanArray(N)
        visited[0]=true
        dp[0]=0
        pq.add(intArrayOf(0,0))
        
        while(pq.isNotEmpty()){
            val e=pq.remove()
            val w=e[0]
            val current=e[1]
            
            visited[current]=true
            
            for(i in 0 until N){
                if(!visited[i] && graph[current][i]!=Int.MAX_VALUE && dp[i]>dp[current]+graph[current][i]){
                    dp[i]=dp[current]+graph[current][i]
                    pq.add(intArrayOf(dp[i], i))
                }
            }
          
        }
        
        for(i in 0 until N){
            if(dp[i]<=k) answer++
        }

        return answer
    }
}