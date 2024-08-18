import kotlin.collections.ArrayDeque

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0
        
        val graph=mutableMapOf<Int,MutableList<Int>>()
        
        edge.forEach{
            val a=it[0]
            val b=it[1]
            graph[a]=graph[a]?:mutableListOf<Int>()
            graph[b]=graph[b]?:mutableListOf<Int>()
            graph[a]?.add(b)
            graph[b]?.add(a)
        }
        
        val q=ArrayDeque<Int>()
        val visited=IntArray(n+1){-1}
        visited[1]=0
        q.add(1)
        
        var maxLength=0
        while(q.isNotEmpty()){
            var current=q.removeFirst()
            graph[current]?.forEach{next->
                if(visited[next]<0){
                    visited[next]=visited[current]+1
                    q.add(next)
                }
            }
        }
        visited.sortDescending()
        answer=visited.count{it==visited[0]}
        return answer
    }
}