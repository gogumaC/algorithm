package solved.ac.class_3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){

    val br= BufferedReader(InputStreamReader(System.`in`))
    val bw= BufferedWriter(OutputStreamWriter(System.out))

    val m=br.readLine().toInt()
    var set=mutableSetOf<String>()
    for(i in 0 until m){
        val input=br.readLine().split(" ")
        when(input[0]){
            "add"->set.add(input[1])
            "remove"-> set.remove(input[1])
            "check"->bw.write(if(set.contains(input[1])) "1\n" else "0\n")
            "toggle"->if(set.contains(input[1]))set.remove(input[1])else set.add(input[1])
            "all"-> set= List(20){"${it+1}"}.toMutableSet()
            "empty"->set= mutableSetOf()
        }
    }
    bw.flush()
}


