import kotlin.collections.ArrayDeque
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val q=ArrayDeque<List<Int>>()
        val priorityQ=ArrayDeque<Int>()
        
        priorities.forEachIndexed{i,v->
            priorityQ.add(v)
            q.add(listOf(i,v))
        }
        
        priorityQ.sort()
        var count=1
        while(q.isNotEmpty()){
            val current=q.removeFirst()
            if(current[1]==priorityQ.last()){
                priorityQ.removeLast()
                if(current[0]==location){
                    return count
                }
                count++
            }else{
                q.add(current)
            }
        }
        
        return count
    }
}