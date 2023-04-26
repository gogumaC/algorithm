package solved.ac.class_2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


fun main(){

    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw= BufferedWriter(OutputStreamWriter(System.out))
    val n=br.readLine().toInt()
    val treeSet= TreeSet<Int>()

    for(i in 0 until n){
        treeSet.add(br.readLine().toInt())
    }

    treeSet.forEach{
        bw.write("$it\n")
    }

    bw.flush()
}