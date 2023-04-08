package solved.ac.class_2

//https://www.acmicpc.net/problem/2609

import kotlin.math.*

fun main(){

    val (n1,n2) = readLine()!!.split(" ").map{it.toInt()}
    
    val gcd= getGCDwithEuclidean(n1,n2)//getGCD(n1,n2)
    val lcm=getLCM(n1,n2)
    
    println(gcd)
    println(lcm)
    
}

//시간 복잡도 O(N) : 132ms
fun getGCD(n1:Int,n2:Int):Int{
    val min=min(n1,n2)
    for(i in min downTo 2){
        if(n1%i==0 && n2%i==0)return i
    }
    return 1
}

//유클리드 호제법 : 시간복잡도O(log N) : 128ms
fun getGCDwithEuclidean(n1:Int,n2:Int):Int{
    var big=max(n1,n2)
    var small=min(n1,n2)
    var r=big%small
    while(r!=0){
        big=small
        small=r
        r=big%small
    }
    return small
}

fun getLCM(n1:Int,n2:Int,gcd:Int= getGCDwithEuclidean(n1,n2)):Int{
    val mul=n1*n2
    return mul/gcd
}