package solved.ac.class_2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class DQ(){

    private val dq=mutableListOf<Int>()

    fun pushFront(n:Int)=dq.add(0,n)
    fun pushBack(n:Int)=dq.add(n)
    fun popFront():Int{
        if(dq.isEmpty()) return -1
        val temp=dq[0]
        dq.removeAt(0)
        return temp
    }
    fun popBack():Int{
        if(dq.isEmpty()) return -1
        val temp=dq.last()
        dq.removeAt(dq.lastIndex)
        return temp
    }
    fun size():Int=dq.size
    fun empty():Boolean=dq.isEmpty()
    fun front():Int=if(dq.isEmpty()) -1 else dq[0]
    fun back():Int=if(dq.isEmpty()) -1 else dq.last()

}

fun main(){
    val br= BufferedReader(InputStreamReader(System.`in`))
    val bw= BufferedWriter(OutputStreamWriter(System.out))

    val n=br.readLine().toInt()
    val dq=DQ()

    for(i in 0 until n){
        val input=br.readLine().split(" ")
        when(input[0]){
            "push_back"->dq.pushBack(input[1].toInt())
            "push_front"->dq.pushFront(input[1].toInt())
            "pop_front"->bw.write(dq.popFront().toString()+"\n")
            "pop_back"->bw.write(dq.popBack().toString()+"\n")
            "size"->bw.write(dq.size().toString()+"\n")
            "empty"->bw.write(if(dq.empty())"1\n" else "0\n")
            "front"->bw.write(dq.front().toString()+"\n")
            "back"->bw.write(dq.back().toString()+"\n")
        }
    }
    bw.flush()
}