package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

fun main(){

    val br= BufferedReader(InputStreamReader(System.`in`))
    val builder=StringBuilder()

    val (n,k) =br.readLine().split(" ").map{it.toInt()}

    builder.append(bfs2(n,k))
    print(builder)
}



fun bfs(n:Int,k:Int):Int{

    val queue=mutableListOf<Pair<Int,Int>>()//depth, n

    var time=0
    queue.add(0 to k)

    while(!queue.isEmpty()){

       // val mark=Array<Boolean>(k*2){false}
        val current=queue.first()

        queue.removeFirst()

        if(current.second==n){
            time=current.first
            break
        }
        else{
            if(current.second>n){
                if(current.second%2==0) {
                    queue.add(current.first + 1 to current.second / 2)
                }
                    queue.add(current.first+1 to current.second+1)
                    queue.add(current.first+1 to current.second-1)

            }else{
                queue.add(current.first+1 to current.second+1)
            }
        }
    }
    return time
}

fun bfs2(n:Int,k:Int):Int{

    if(n<k){
        val mark=Array(k*2+1){false}
        val dist=Array(k*2+1){0}
        val queue= mutableListOf<Int>()
        queue.add(n)
        mark[n]=true

        while(queue.isNotEmpty()){
            val current=queue.first()
            queue.removeFirst()

            if(current==k) break;

            if(current*2<dist.size&&!mark[current*2]) {
                queue.add(current * 2)
                dist[current*2]=dist[current]+1
                mark[current*2]=true
            }
            if(current>0&&!mark[current-1]) {
                queue.add(current - 1)
                dist[current-1]=dist[current]+1
                mark[current-1]=true
            }
            if(current+1<dist.size&&!mark[current+1]) {
                queue.add(current + 1)
                dist[current+1]=dist[current]+1
                mark[current+1]=true
            }
        }

        return dist[k]
    }else return n-k

}

fun backTracking(n:Int,k:Int):Int{
    var time=0
    var currentK=k

    while(currentK!=n){

        if(currentK<n){
            time+=min(n-currentK,abs(n-currentK*2))
            break;
        }else if(currentK>n){


            val divideGap=abs(currentK/2-n)
            val subtractGap=abs(currentK-1-n)
            if(currentK%2==0&&divideGap<subtractGap){
                currentK/=2;
            }else{
                currentK--
            }
            time++
        }

    }
    return time
}