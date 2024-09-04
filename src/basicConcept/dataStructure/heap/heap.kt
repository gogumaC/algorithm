import kotlin.math.*

class Heap(){
    val arr=mutableListOf<Int>()

    fun push(e:Int){
        arr.add(e)
        var cIndex=arr.size
        if(arr.size>1){
            while(cIndex!=1){
                val parent=cIndex/2
                if(arr[parent-1]<arr[cIndex-1]){
                    val temp=arr[parent-1]
                    arr[parent-1]=e
                    arr[cIndex-1]=temp
                    cIndex=parent
                }else break
            }
        }
    }

    fun pop():Int?{
        if(arr.isEmpty()) return null
        val res=arr[0]
        val leaf=arr.removeLast()
        if(arr.isEmpty()) return res
        arr[0]=leaf
        var idx=1
        while(arr.isNotEmpty() && idx<arr.size){
            val c1=2.0.pow(idx).toInt()
            val c2=c1+1
            if(c1-1<arr.size && arr[idx-1]<arr[c1-1] && arr[c1-1]>arr[c2-1]){
                val temp=arr[c1-1]
                arr[c1-1]=arr[idx-1]
                arr[idx-1]=temp
                idx=c1
            }else if(c2-1<arr.size && arr[idx-1]<arr[c2-1] && arr[c2-1]>arr[c1-1]){
                val temp=arr[c2-1]
                arr[c2-1]=arr[idx-1]
                arr[idx-1]=temp
                idx=c2
            }else break
        }   
        return res       
    }
}

fun main(){

    val h=Heap()
    h.push(2)
    h.push(1)
    h.push(3)
    h.push(1)
    println(h.arr)
    println(h.pop())
}