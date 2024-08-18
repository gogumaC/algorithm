package solved.ac.class_2

//https://www.acmicpc.net/problem/11050


fun main(){

    val (n,k)=readLine()!!.split(" ").map{it.toInt()}
    print(getBinominalCoefficient(n,k))

}

fun getBinominalCoefficient(n:Int,k:Int):Int{
    var res=1
    for(i in 1 .. n-k){
        res*=n-(i-1)
        res/=i
    }
    return res
}

fun getFactorial(n:Int,limit:Int=n):Int{
    var res=1
    for(i in 0 until limit){
        res*=n-i
    }
    return res
}


