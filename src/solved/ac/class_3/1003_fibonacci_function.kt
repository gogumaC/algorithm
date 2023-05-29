package solved.ac.class_3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


private data class FiboZeroOne(var zeroCount:Int=0,var oneCount:Int=0)
private var fibos=MutableList(41){FiboZeroOne()} //zero - one
private val fiboMark=MutableList(41){false}


fun main(){

    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw= BufferedWriter(OutputStreamWriter(System.out));


    val n=br.readLine().toInt()

    fibos[0].zeroCount=1
    fibos[0].oneCount=0
    fibos[1].zeroCount=0
    fibos[1].oneCount=1

    fiboMark[0]=true
    fiboMark[1]=true

    for(i in 0 until n){
        val input=br.readLine().toInt()
        getFibo(input)
        bw.write("${fibos[input].zeroCount} ${fibos[input].oneCount}\n")
    }
    bw.flush()
}

fun getFibo(n:Int){
    if(!fiboMark[n]){
        fiboMark[n]=true;
        getFibo(n-1)
        getFibo(n-2)
        fibos[n].zeroCount=fibos[n-1].zeroCount+fibos[n-2].zeroCount
        fibos[n].oneCount=fibos[n-1].oneCount+fibos[n-2].oneCount
    }

}

