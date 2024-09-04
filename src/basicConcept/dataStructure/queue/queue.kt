import java.util.*

class ArrayQueue(val size:Int){
    val arr=IntArray(size)
    var front=0
    var rear=0
    var qSize=0
    fun enqueue(e:Int){
        if(qSize==size){
            println("queue is full")
            return 
        }
        arr[rear]=e
        qSize++
        rear=(rear+1)%size
    }
    
    fun dequeue():Int?{
        if(qSize==0) return null
        val e=arr[front]
        qSize--
        front=(front+1)%size
        return e
        
    }
}

class LinkedListQueue(){
    val arr=LinkedList<Int>()
    
    fun enqueue(e:Int){
        arr.add(e)
    }
    
    fun dequeue():Int?{
        if(arr.isEmpty())return null
        return arr.removeLast()
    }
}

fun main() {
    val q=LinkedListQueue()
    q.enqueue(0)
    q.enqueue(1)
    q.enqueue(2)
    println(q.dequeue())
    println(q.dequeue())
    println(q.dequeue())
    println(q.dequeue())
}