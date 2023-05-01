package solved.ac.class_2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val stack=mutableListOf<Int>()
fun main(){
    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))
    val n=br.readLine().toInt()
    for(i in 0 until n){
        val input=br.readLine().split(" ")
        val operator=input[0]
        var num=0
        if(input.size==2)num=input[1].toInt()
        if(operator=="push") stackPush(num)
        else if(operator=="pop") bw.write("${stackPop()}\n")
        else if(operator=="size") bw.write("${stackSize()}\n")
        else if(operator=="empty")bw.write("${stackEmpty()}\n")
        else if(operator=="top") bw.write("${stackTop()}\n")
    }
    bw.flush()
}

fun stackPush(n:Int){
    stack.add(n)
}
fun stackPop():Int{
    if(stack.isEmpty()) return -1
    val n=stack.removeLast()
    return n
}
fun stackSize():Int=stack.size
fun stackEmpty():Int=if(stack.isEmpty())1 else 0
fun stackTop():Int{
    if(stack.isEmpty()) return -1
    return stack.last()
}