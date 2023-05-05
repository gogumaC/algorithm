package solved.ac.class_2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    val br= BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))
    val list=mutableListOf<Pair<Int,String>>()
    val n=br.readLine().toInt();
    for(i in 0 until n){
        val (age,name)=br.readLine().split(" ")
        list.add(age.toInt() to name)
    }
    val c= Comparator { o1:Pair<Int,String>, o2:Pair<Int,String> ->
        o1.first-o2.first
    }
    list.sortWith(c)
    list.forEach{
        bw.write("${it.first} ${it.second}\n")
    }
    bw.flush()
}