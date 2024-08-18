package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){

    val br=BufferedReader(InputStreamReader(System.`in`))

    val n=br.readLine().toInt()
    val builder=StringBuilder()
    val minHeap=MinHeap()

    for(i in 0 until n){
        val input=br.readLine().toInt()
        if(input==0){
            builder.append(minHeap.pop())
            builder.append("\n")
        }
        else{
            minHeap.push(input)
        }
    }

    println(builder)
}

class MinHeap(){

    private val list= PriorityQueue<Int>()

    fun pop():Int{
        return if(list.isEmpty()) 0
        else{
            val res=list.first()
            list.remove(res)
            res
        }
    }

    fun push(n:Int){
        list.add(n)
    }
}