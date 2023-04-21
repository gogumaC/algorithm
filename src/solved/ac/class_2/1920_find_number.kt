package solved.ac.class_2

//https://www.acmicpc.net/problem/1920

fun main(){

    val n=readLine()!!.toInt()
    val nums=readLine()!!.split(" ").map{it.toLong()}.toSet()

    val m=readLine()!!.toInt()
    val checkNums=readLine()!!.split(" ").map{it.toLong()}

    checkNums.forEach{
        print("${if(nums.contains(it))1 else 0}\n")
    }

}