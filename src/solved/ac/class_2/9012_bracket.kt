package solved.ac.class_2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){

    val br= BufferedReader(InputStreamReader(System.`in`))
    val bw= BufferedWriter(OutputStreamWriter(System.out))
    val n=br.readLine().toInt()
    loop@ for(testCase in 0 until n){
        val input=br.readLine()
        var stack=0

        for(it in input){
            if(it=='(') stack++
            else {
                if(stack!=0)stack--
                else {
                    bw.write("NO\n")
                    continue@loop
                }

            }
        }

        bw.write(if(stack==0)"YES\n" else "NO\n")
    }
    bw.flush()
}