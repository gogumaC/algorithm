import java.io.*

fun main(args: Array<String>) {
    val br=BufferedReader(InputStreamReader(System.`in`))
    val n=br.readLine().toInt()
    val result=StringBuilder()
    for(i in 0 until n){
        val input=br.readLine().split(" ")
        val s=input[0].toUpperCase()
        val t=input[1].toUpperCase()
        val pos=s.indexOf('X')
        result.append(t[pos])
    }
    println(result)  
}