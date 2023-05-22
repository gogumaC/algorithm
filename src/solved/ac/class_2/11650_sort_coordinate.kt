package solved.ac.class_2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(){

    val br= BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))

    val n=br.readLine().toInt()
    val list=mutableListOf<Pair<Int,Int>>()
    for(i in 0 until n){
        val (x,y)=br.readLine().split(" ").map{it.toInt()}
        list.add(x to y)
    }

    val c=Comparator{o1:Pair<Int,Int>,o2:Pair<Int,Int>->
        if(o1.first==o2.first) compareValues(o1.second,o2.second)
        else compareValues(o1.first,o2.first)
    }

    list.sortWith(c)
    list.forEach{
        bw.write("${it.first} ${it.second}\n")
    }
    bw.flush()
}