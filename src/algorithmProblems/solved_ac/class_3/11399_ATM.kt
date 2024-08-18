package solved.ac.class_3

import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n=br.readLine().toInt()
    val withDrawalDuration=br.readLine().split(" ").map{it.toInt()}
    var minTime=0
    withDrawalDuration.sorted().forEachIndexed { index, duration ->
        minTime+=duration*(n-index)
    }
    println(minTime)
}