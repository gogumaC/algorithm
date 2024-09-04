import java.util.*

class ArrayStack(size:Int){
    val arr=IntArray(size)
    var top=-1
    
    fun push(e:Int){
        if(top==arr.size-1){ 
            println("stack is full")
        	return
        }
        
        top++
        arr[top]=e
    }
    
    fun pop():Int?{
        if(top==-1){
            println("stack is empty")
            return null
        }
        val e=arr[top]
        top--
        return e
    }
}

class DynamicArrayStack(){
    
    var size=2
    var arr=IntArray(size)
    var top=-1
    
    fun push(e:Int){
        if(top==arr.size-1){ 
            swapBigger()
        }
        
        top++
        arr[top]=e
    }
    
    fun swapBigger(){
        val newArr=IntArray(size*2)
        size*=2
        for(i in arr.indices){
            newArr[i]=arr[i]
        }
        
        arr=newArr
    }
    
    
    
    fun pop():Int?{
        if(top==-1){
            println("stack is empty")
            return null
        }
        val e=arr[top]
        top--
        return e
    }
    
}

class LinkedListStack(){
    
    val arr=LinkedList<Int>()
    
    fun push(e:Int){
        arr.add(e)
    }
    
    fun pop():Int?{
        if(arr.isEmpty()) return null
        return arr.removeLast()
    }
    
}

fun main() {
    val stack=DynamicArrayStack()
    
    stack.push(1)
    stack.push(2)
    stack.push(3)
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    
}