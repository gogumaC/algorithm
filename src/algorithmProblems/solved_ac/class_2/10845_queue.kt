package solved.ac.class_2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val queue=mutableListOf<Int>()
fun main(){
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))
    val n=br.readLine().toInt()
    for(i in 0 until n ){
        val input=br.readLine().split(" ")
        val operator=input[0]
        var num=0
        if(input.size==2)num=input[1].toInt()

        when(operator){
            "push"->qPush(num)
            "pop"->bw.write("${qPop()}\n")
            "size"->bw.write("${qSize()}\n")
            "empty"->bw.write("${qEmpty()}\n")
            "front"->bw.write("${qFront()}\n")
            "back"->bw.write("${qBack()}\n")
        }
    }
    bw.flush()

}

fun qPush(n:Int){queue.add(n)}
fun qPop():Int{
    if(queue.isEmpty())return -1
    val first=queue.first()
    queue.removeAt(0)
    return first
}
fun qSize():Int=queue.size
fun qEmpty():Int=if(queue.isEmpty())1 else 0
fun qFront():Int{
    if(queue.isEmpty())return -1
    else return queue.first()
}
fun qBack():Int{
    if(queue.isEmpty())return -1
    else return queue.last()
}