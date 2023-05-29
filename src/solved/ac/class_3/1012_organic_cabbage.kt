package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader


private var field= mutableListOf<MutableList<Int>>()
private var count=0
private var M=0;
private var N=0;
fun main(){

    val br= BufferedReader(InputStreamReader(System.`in`))
    val builder=StringBuilder()


    val testCase=br.readLine().toInt()

    for(T in 0 until testCase){
        count=0;
        val (m,n,cabbageCount)= br.readLine().split(" ").map{it.toInt()}
        M=m
        N=n
        field= MutableList(m){MutableList(n){0} }
        for(i in 0 until cabbageCount){
            val (x,y)=br.readLine().split(" ").map{it.toInt()}
            field[x][y]=1
        }

        for(i in 0 until m){
            for(j in 0 until n){
                if(field[i][j]==1){
                    count++
                    dfs(i,j)
                }
            }
        }
        builder.append("$count\n")
    }
    print(builder)

}

fun dfs(x:Int,y:Int){
    field[x][y]=2
    if(x>0&&field[x-1][y]==1)dfs(x-1,y)
    if(x<M-1&&field[x+1][y]==1)dfs(x+1,y)
    if(y>0&&field[x][y-1]==1)dfs(x,y-1)
    if(y<N-1&&field[x][y+1]==1)dfs(x,y+1)
}