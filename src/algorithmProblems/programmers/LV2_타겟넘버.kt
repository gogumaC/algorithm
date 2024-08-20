import kotlin.collections.ArrayDeque
class Solution {
    fun solutionWithBFS(numbers: IntArray, target: Int): Int {
        var answer = 0
        val q=ArrayDeque<Pair<Int,Int>>()
        q.add(Pair(0,-1))
        var count=0
        while(q.isNotEmpty()){
            val (current,depth)=q.removeFirst()
            if(depth==numbers.size-1) continue
            val plus=current+numbers[depth+1] to depth+1
            val minus=current-numbers[depth+1] to depth+1
            if(depth+1==numbers.size-1){
                if(plus.first==target) count++
                if(minus.first==target) count++
            }
            q.add(plus)
            q.add(minus)
        }
        return count
    }

    var count=0
    fun solutionWithDFS(numbers: IntArray, target: Int): Int {
        var answer = 0
        dfs(numbers,0,0,target)
        return count
    }
    
    fun dfs(numbers:IntArray,depth:Int,total:Int,target:Int){
        if(depth==numbers.size){
            if(total==target) count++
            return
        }
        dfs(numbers,depth+1,total+numbers[depth],target)
        dfs(numbers,depth+1,total-numbers[depth],target)
    }
}