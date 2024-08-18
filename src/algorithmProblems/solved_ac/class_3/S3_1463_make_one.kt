package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min

fun main(){
    val br=BufferedReader(InputStreamReader(System.`in`))
    val builder=StringBuilder()

    val n=br.readLine().toInt()
    builder.append(dp(n))
    println(builder)

}

fun dp(n:Int):Int{
    val res=Array(n + 1){0}

    if(n>1) res[2]=1
    if(n>2) res[3]=1

    for(i in 4..n){
        var min=Int.MAX_VALUE
        if(i%3==0) min=min(res[i/3],min)
        if(i%2==0) min=min(res[i/2],min)
        min=min(res[i-1],min)

        res[i]=min+1
    }

    return res[n]

}