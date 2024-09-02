fun binarySearch(e:Int,arr:IntArray):Int{
    
    var low=0
    var high=arr.size-1
    
    while(low<=high){
        val mid=low+(high-low)/2
        
        if(arr[mid]>e){
            high=mid-1
        }else if(arr[mid]<e){
            low=mid+1
        }else return mid
    }
    
    return -1
}