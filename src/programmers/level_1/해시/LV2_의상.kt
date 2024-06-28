class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val m=mutableMapOf<String,Int>()
        for(cloth in clothes){
            val cat=cloth[1]
            m[cat]=(m[cat]?:0)+1
        }
        
        for(v in m.values){
            answer*=v+1
        }

        return answer-1
    }
}