package solved.ac.class_2

//https://www.acmicpc.net/problem/11050

fun main(){

    val (n,k)=readLine()!!.split(" ").map{it.toInt()}
    print(getBinomialCoefficient(n,k))

}

fun getBinomialCoefficient(n:Int,k:Int):Int{
    return getFactorial(n,k)/getFactorial(k)
}

fun getFactorial(n:Int,limit:Int=n):Int{
    var res=1
    for(i in 0 until limit){
        res*=n-i
    }
    return res
}