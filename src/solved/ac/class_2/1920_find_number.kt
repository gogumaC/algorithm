package solved.ac.class_2

//https://www.acmicpc.net/problem/1920

fun main(){

    //val numsCount=readLine()
    val nums=readLine()!!.split(" ")

    //val inputsCount=readLine()
    val inputs=readLine()!!.split(" ")

    inputs.forEach{
        println(if(nums.contains(it))1 else 0)
    }

}