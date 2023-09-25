package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val br=BufferedReader(InputStreamReader(System.`in`))

    val n=br.readLine().toInt()
    val pairCount=br.readLine().toInt()

    val adjacencyMatrix=Array(n+2){Array(n+2){0} }

    for(i in 0 until pairCount){
        val (node1,node2)=br.readLine().split(" ").map{it.toInt()}
        adjacencyMatrix[node1][node2]=1
        adjacencyMatrix[node2][node1]=1
    }

    println(dfs(n,adjacencyMatrix))
}

fun dfs(n:Int,adjacencyMatrix:Array<Array<Int>>,startNode:Int=1):Int{
    val stack=mutableListOf<Int>()
    val mark=Array(n+1){false}
    mark[1]=true
    var count=0
    stack.add(startNode)
    while(stack.isNotEmpty()){
        val current=stack.last()
        stack.removeLast()

        for(i in 1 ..n){
            if(adjacencyMatrix[current][i]==1&&!mark[i]){
                mark[i]=true
                stack.add(i)
                count++
            }
        }
    }
    return count
}
