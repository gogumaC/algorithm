package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br=BufferedReader(InputStreamReader(System.`in`))
    val builder=StringBuilder()

    val (n,m)=br.readLine().split(" ").map{it.toInt()}
    val stringMap= mutableMapOf<String,Int>()
    val pokemons=Array(n+1){""}

    for(i in 1..n){

        pokemons[i]=br.readLine()
        stringMap.put(pokemons[i],i)
    }

    for(i in 0 until m){
        val input=br.readLine()
        if(input.toIntOrNull()!=null){
            builder.append(pokemons[input.toInt()])
        }else{
            builder.append(stringMap[input])
        }
        builder.append("\n")
    }

    print(builder)

}