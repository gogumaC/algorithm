import java.util.*

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        val q=LinkedList<Pair<Int,Int>>()
        for(i in progresses.indices){
            q.add(progresses[i] to speeds[i])
        }
        var time=0
        while(q.isNotEmpty()){
            var count=0
            while(q.isNotEmpty()){
                val current=q.first()
                if(current.first+current.second*time>=100){
                    count++
                    q.removeFirst()
                }else{
                    if(count>0)answer.add(count)
                    break
                }  
                if(q.isEmpty()){
                    if(count>0)answer.add(count)
                    break
                }
            }
            time++     
        } 
        return answer.toIntArray()
    }
}