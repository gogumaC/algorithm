package solved.ac.class_2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val br=BufferedReader(InputStreamReader(System.`in`))

    val n=br.readLine().toInt()
    val cards=MutableList(n) {it+1}

    var startIndex=0
    var endIndex=n-1

    while(endIndex!=startIndex){
        startIndex++
        if(endIndex==startIndex)break
        cards.add(cards[startIndex])
        endIndex++
        startIndex++
    }

    println(cards[startIndex])

}