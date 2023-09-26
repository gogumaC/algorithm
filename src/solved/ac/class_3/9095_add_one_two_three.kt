package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br=BufferedReader(InputStreamReader(System.`in`))

    val case=br.readLine().toInt()
    val builder=StringBuilder()

    for(i in 0 until case ){
        val n=br.readLine().toInt()
        builder.append(bfs(n))
        builder.append("\n")
    }
    println(builder)
}

fun bfs(n:Int):Int{
    val queue= mutableListOf(0)
    var count=0
    while(queue.isNotEmpty()){
        val current=queue.first()
        queue.removeFirst()

        for(i in 1..3){
            if(current+i<n) {
                queue.add(current+i)
            }
            else if (current+i==n){
                count++
            }
        }

    }
    return count
}