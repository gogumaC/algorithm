package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    if(n<0){
        println(0)
        return
    }

    val d=Array(n+3){0L}

    if(n>0){
        d[1]=1
        d[2]=2
    }

    for(i in 3..n){
        d[i]=(d[i-1]+d[i-2])%10007
    }

    println(d[n])
}
