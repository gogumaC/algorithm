package solved.ac.class_2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//https://www.acmicpc.net/problem/1920


fun main(){


    val br=BufferedReader(InputStreamReader(System.`in`))
    val bw=BufferedWriter(OutputStreamWriter(System.out))
    val n=br.readLine().toInt()
    val nums=br.readLine().split(" ").map{it.toLong()}.toSet()

    val m=br.readLine().toInt()
    val checkNums=br.readLine().split(" ").map{it.toLong()}

    checkNums.forEach{
        bw.write("${if(nums.contains(it))1 else 0}\n")
    }

    bw.flush()

}