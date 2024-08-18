package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun main(){
    val br= BufferedReader(InputStreamReader(System.`in`))
    val builder=StringBuilder()

    val (n,r,c)=br.readLine().split(" ").map{it.toInt()}
    val N:Int= 2.0.pow(n.toDouble()).toInt()
    builder.append(getIndex(r,c,N/2))
    print(builder)
}

fun getIndex(r:Int,c:Int,n:Int):Int{
    var sum=0
    var currentR=r
    var currentC=c
    var currentN=n

    while(currentN>0){
        val blockR=currentR/currentN
        val blockC=currentC/currentN
        val blockNum=blockC+blockR*2;
        sum+=blockNum*currentN*currentN
        currentR%=currentN
        currentC%=currentN
        currentN/=2
    }
    return sum

}