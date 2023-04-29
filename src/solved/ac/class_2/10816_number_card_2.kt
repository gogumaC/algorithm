package solved.ac.class_2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){

    val br= BufferedReader(InputStreamReader(System.`in`))
    val bw= BufferedWriter(OutputStreamWriter(System.out))

    val n=br.readLine().toInt()
    val sangunCards=br.readLine().split(" ")
    val sangunMap=mutableMapOf<Int,Int>()
    sangunCards.forEach{
        val num=it.toInt()
        if(sangunMap[num]==null) sangunMap.put(num,1)
        else sangunMap[num]=sangunMap[num]!!+1
    }
    val m=br.readLine().toInt()
    val cards=br.readLine().split(" ")

    cards.forEach{
        val card=it.toInt()
        if(sangunMap[card]!=null) bw.write("${sangunMap[card]} ")
        else bw.write("0 ")
    }
    bw.flush()
}