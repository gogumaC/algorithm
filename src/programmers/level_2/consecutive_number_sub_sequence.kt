import kotlin.math.*


fun solution(sequence: IntArray, k: Int): IntArray {
    var answer: IntArray = intArrayOf()
    val prefixSum=IntArray(sequence.size+1){0}
    val sub=mutableListOf<IntArray>()

    sequence.indexOf(k).let{
        if(it>0) return intArrayOf(it,it)
    }

    //prefixSum구하기
    for(i in sequence.indices){
        prefixSum[i+1]=prefixSum[i]+sequence[i]
    }


    //부분수열 구해가며 조건에 맞는거 찾기
    var startIndex=0
    var endIndex=0

    while(endIndex<sequence.size){
        var sum=prefixSum[endIndex+1]-prefixSum[startIndex]

        if(sum==k){
            if(answer.isEmpty())answer=intArrayOf(startIndex,endIndex)
            else if(answer[1]-answer[0]>endIndex-startIndex)answer=intArrayOf(startIndex,endIndex)
            else if(answer[1]-answer[0]==endIndex-startIndex&&answer[0]>startIndex) answer=intArrayOf(startIndex,endIndex)
            startIndex++
        }
        else if(sum>k) startIndex++
        else endIndex++
    }

    return answer
}

